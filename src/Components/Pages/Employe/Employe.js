import { useState } from "react";
import { useNavigate } from "react-router-dom";
import Button from "../../Common/Button/Button";
import "../Employe/Employe.css";
import { colors } from "@mui/material";

const Employee_login = () => {
    const navigate = useNavigate();
    const [userId, setUserId] = useState('');
    const [password, setPassword] = useState('');
    const [message, setMessage] = useState('');

    const handleLogin = () => {
        const storedEmployees = JSON.parse(localStorage.getItem('employees'));
        const employee = storedEmployees.find(employee => employee.userID === userId && employee.password === password);

        if (employee) {
            setMessage('Login successful!');
            // Redirect to dashboard or any other page after successful login
            // navigate('/dashboard');
        } else {
            setMessage('Invalid UserID or Password.');
        }
    };

    return (
        <div id="employe-login">
            <form id="employe-login-form">
                <div className="employe-div">
                    <label>UserId</label>
                    <input type="text" placeholder="UserId" value={userId} onChange={e => setUserId(e.target.value)} required />
                </div>
                <div className="employe-div">
                    <label>Password</label>
                    <input type="password" placeholder="Password" value={password} onChange={e => setPassword(e.target.value)} required />
                </div>
                <button className="btn">Login</button>
                <div style={{color:"var(--black)"}}>
                <span onClick={() => navigate("/employe-register")}>If New click here to register !!!</span>
            </div>
            </form>
            <div>{message && <p className="login-message">{message}</p>}</div>
           
        </div>
    );
}

export default Employee_login;
