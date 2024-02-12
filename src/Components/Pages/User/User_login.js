import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import Button from "../../Common/Button/Button";
import "../User/User_login.css";

const User_login = () => {
    const navigate = useNavigate();
    const [userId, setUserId] = useState('');

    const handleLogin = () => {
        const userData = JSON.parse(localStorage.getItem('userData'));
        const user = userData.find(user => user.firstname === userId);

        if (user) {
            navigate(`/user/dashboard/${userId}`); ;
        } else {
            alert("User not found");
        }
       
    };

    return (
        <div id="user-login">
            <form id="user-login-form">
                <div>
                    <h1>User Login</h1>
                </div>
                <div className="user-div">
                    <label>UserId</label>
                    <input
                        type="text"
                        placeholder="UserId"
                        value={userId}
                        onChange={(e) => setUserId(e.target.value)}
                        required
                    />
                </div>
                <button onClick={handleLogin} className="btn" >Check Status</button>
                <p>New user Click on <span onClick={() => navigate('/register')}>Register</span></p>
            </form>
        </div>
    );
}

export default User_login;
