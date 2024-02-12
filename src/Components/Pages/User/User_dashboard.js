import React from "react";
import { useParams } from "react-router-dom";
import "../User/User_dashboard.css";

const User_dashboard = () => {
    const { userId } = useParams();

    const userData = JSON.parse(localStorage.getItem('userData')) || [];
    const user = userData.find(user => user.firstname.toLowerCase() === userId.toLowerCase());

    return (
        <div id="user_dashboard">
            <h1>User Dashboard</h1>
            {user ? (
                <div>
                    <div>
                        <h2>User Details</h2>
                        <ul>
                            <li>
                                <strong>Name:</strong> {user.firstname} {user.lastname}<br />
                                <strong>Email:</strong> {user.email}<br />
                            </li>
                        </ul>
                    </div>
                    <div>
                        <h2>Status of Profile</h2>
                        <p>{user.status}</p>
                    </div>
                </div>
            ) : (
                <p>User not found</p>
            )}
        </div>
    );
}

export default User_dashboard;
