import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import Button from "../../Common/Button/Button";
import "../Admin/Admin.css";

const Admin_login = () => {
  const [userId, setUserId] = useState("");
  const [password, setPassword] = useState("");
  const [error, setError] = useState("");
  const navigate = useNavigate();

  const handleSubmit = (e) => {
    e.preventDefault();
    setError("");

    const validUserId = "admin";
    const validPassword = "password";

    if (userId === validUserId && password === validPassword) {
      navigate("/admin/functions");
    } else {
      setError("Invalid userId or password");
    }
  };

  return (
    <div id="admin-login">
      <form id="admin-login-form" onSubmit={handleSubmit}>
        <div className="admin-div">
          <label>UserId:</label>
          <input
            type="text"
            value={userId}
            onChange={(e) => setUserId(e.target.value)}
            placeholder="UserId"
            required
          />
        </div>
        <div className="admin-div">
          <label>Password:</label>
          <input
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            placeholder="Password"
            required
          />
        </div>
        {error && <p className="error-message">{error}</p>}
        <button className="btn">Login</button>
      </form>
    </div>
  );
};

export default Admin_login;
