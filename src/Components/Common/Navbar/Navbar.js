import React from 'react';
import { Link } from 'react-router-dom';
import "../Navbar/Navbar.css";
import icon from "../../Images/Icon.png";

const Nav_bar = () => {
    return (
        <div id="nav-bar">
            <div id="nav-left">
                <img src={icon} alt="Logo" />
                <h2>Elfonze</h2>
            </div>
            <div id="nav-right">
                <Link to="/admin/login"><p>Admin</p></Link>
                <Link to="/employe/login"><p>Employee</p></Link>
                <Link to="/about"><p>About us</p></Link>
                <Link to="/contact"><p>Contact</p></Link>
            </div>
        </div>
    );
}

export default Nav_bar;
