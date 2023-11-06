import axios from "axios";
import {useState,useEffect} from "react";
import {Link, } from "react-router-dom";

function ListTours() {
    const [tours, setTours] = useState([]);
    const [check, setCheck] = useState(true)
    const [search, setSearch] = useState("")
    useEffect(() => {
            axios.get("http://localhost:8080/tours").then(res => {
                setTours(res.data)
            }).catch(error => {
                throw error
            })
        }, [check]
    )

    function searchByName(){
        axios.get("http://localhost:8080/tours/search?username="+ search)
            .then(response => {
                   setTours(response.data)
                }
            )
    }

return (
    <>
        <h1>List Tours</h1>
        <div className={'input-group mb-3'}>
            <input type="text" onChange={(e) => {
                setSearch(e.target.value)
            }} id={'search'} name={'search'} className={"form-control"} placeholder="Recipient's username"
                   aria-label="Recipient's username" aria-describedby="button-addon2"/>
            <button className={'btn btn-primary'} onClick={searchByName}>Search</button>
        </div>
        <Link to={'/create'} class="btn btn-warning">Create new Student</Link>

        <table className={"table table-striped"}>
            <thead>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Price</th>
                <th>Description</th>
                <th colSpan={2}>Action</th>
            </tr>
            </thead>
            <tbody>
            {tours.map((x) => {
                return (
                    <>
                        <tr>
                            <td>{x.id}</td>
                            <td><Link to={'/tour/'+x.id}>{x.title}</Link></td>
                            <td>{x.price}</td>
                            <td>{x.description}</td>
                            <td>
                                <Link to={"/update/" + x.id} class="btn btn-warning">update</Link>
                            </td>
                            <td>
                                <button onClick={() => (deleteStudent(x.id))} className="btn btn-danger">Delete</button>
                            </td>
                        </tr>
                    </>
                )
            })}
            </tbody>
        </table>
    </>
)

    function deleteStudent(id) {
        axios.get("http://localhost:8080/tours/delete/" + id).then(() => {
            setCheck(!check)
        })
    }
}

export default ListTours