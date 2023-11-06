// import React, { useState, useEffect } from "react";
import { Formik, Form, Field, ErrorMessage } from "formik";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import * as Yup from "yup";
import "./create.css"

function Create() {
    const navigate = useNavigate();

    const initialValues = {
        title: "",
        price: "",
        description: "",
    };

    const validationSchema = Yup.object().shape({
        title: Yup.string().required(" title is required"),
        price: Yup.string().required(" price is required"),
        description: Yup.string().required(" description is required"),
    });

    function handleSubmit(e) {
        const tours = {
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
                console.error("Error creating student:", error);
            });
    };

    return (
        <>
            <h1 >Create Tours</h1>
            <Formik
                initialValues={initialValues}
                validationSchema={validationSchema}
                onSubmit={(e) =>handleSubmit(e)}
            >
                <Form>
                    <div>
                        <label htmlFor="title">Title:</label>
                        <Field type="text" name={'title'} class="form-control"/>
                        <ErrorMessage name="title" component="div" />
                    </div>

                    <div>
                        <label htmlFor="price">Price:</label>
                        <Field type="text" name={'price'} class="form-control"/>
                        <ErrorMessage name="price" component="div" />
                    </div>

                    <div>
                        <label htmlFor="description">Description:</label>
                        <Field type="text" name={'description'} class="form-control"/>
                        <ErrorMessage name="description" component="div" />
                    </div>

                    <button type="submit" class="btn btn-warning">Create</button>
                </Form>
            </Formik>
        </>
    );
}

export default Create;