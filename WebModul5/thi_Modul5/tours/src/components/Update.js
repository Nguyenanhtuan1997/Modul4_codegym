import React, {useEffect, useState} from "react";
import {Formik, Form, Field, ErrorMessage} from "formik";
import {useNavigate, useParams} from "react-router-dom";
import axios from "axios";
import * as Yup from "yup";
import "./create.css"

function Update() {
    const navigate = useNavigate();
    const [tours, setTours] = useState({});
    let {id} = useParams();

    useEffect(() => {
        axios.get("http://localhost:8080/tours/" + id).then(res => {
            setTours(res.data)
        }).catch(() => {
            return {}
        })
    }, [])
    const initialValues = {
        title: tours.title,
        price: tours.price,
        description: tours.description,
    };

    const validationSchema = Yup.object().shape({
        title: Yup.string().required("Title is required"),
        price: Yup.string().required("price is required"),
        description: Yup.string().required("Descriptionis required"),
    });

    function handleSubmit(e) {
        const tours = {
            id: id,
            title: e.title,
            price: e.price,
            description: e.description,
        };
        axios
            .post("http://localhost:8080/tours", tours)
            .then(() => {
                navigate("/");
            })
            .catch((error) => {
                console.error("Error creating tours:", error);
            });
    };

    return (
        <>
            <h1>update Tours</h1>
            <Formik
                initialValues={initialValues}
                validationSchema={validationSchema}
                onSubmit={(e) =>
                    handleSubmit(e)}
                enableReinitialize={true}
            >
                <Form>
                    <div>
                        <label htmlFor="title">Title:</label>
                        <Field type="text" name={'title'} class="form-control"/>
                        <ErrorMessage name="title" component="div"/>
                    </div>

                    <div>
                        <label htmlFor="price">Price:</label>
                        <Field type="text" name={'price'} class="form-control"/>
                        <ErrorMessage name="price" component="div"/>
                    </div>

                    <div>
                        <label htmlFor="description">Description:</label>
                        <Field type="text" name={'description'} class="form-control"/>
                        <ErrorMessage name="description" component="div"/>
                    </div>

                    <button type="submit" class="btn btn-warning">Update</button>
                </Form>
            </Formik>
        </>
    );
}

export default Update;