import logo from './logo.svg';
import './App.css';
import {Route, Routes} from "react-router-dom";
import {HomeUser} from "./tour/view/Home-user";
import {About} from "./tour/view/About";
import {InfoLover} from "./tour/view/InfoLover";
import {FormLogin} from "./tour/view/FormLogin";
import {Layout} from "./tour/view/Layout";
import {Demo} from "./tour/view/Demo";
import {InfoUser} from "./tour/view/InfoUser";


function App() {
    return (
        <>
            <Routes>
                <Route path={'/'} element={<Layout/>}>
                    <Route path={""} element={<HomeUser/>}></Route>
                </Route>
                <Route path={'/info-lover'} element={<InfoLover/>}></Route>
                <Route path={'/info-user'} element={<InfoUser/>}></Route>
                <Route path={'/demo'} element={<Demo/>}></Route>
            </Routes>
        </>
    );
}

export default App;
