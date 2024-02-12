import React, { useState } from 'react';
import './Employe_registration.css'; // Import CSS file
import { useNavigate } from 'react-router-dom';

const Employ_register = () => {
    const [name, setName] = useState('');
    const [userID, setUserID] = useState('');
    const [email, setEmail] = useState('');
    const [phone, setPhone] = useState('');
    const [password, setPassword] = useState('');
    const [message, setMessage] = useState('');
    const navigate = useNavigate();

    const handleRegistration = () => {
        const storedEmployees = JSON.parse(localStorage.getItem('employees'));
        const employeeExists = storedEmployees && storedEmployees.some(employee => employee.name === name);

        if (employeeExists) {
            const newEmployee = {
                userID,
                name,
                email,
                phone,
                password
            };
            localStorage.setItem('employees', JSON.stringify([...storedEmployees, newEmployee]));
            navigate("/employe/login")
            
        } else {
            setMessage('You need to contact administration to create your account.');
        }
    };

    return (
        <div className="employ-register-container">
            <h1>Employee Registration</h1>
            <form onSubmit={e => { e.preventDefault(); handleRegistration(); }}>
                <input type="text" placeholder="Name" value={name} onChange={e => setName(e.target.value)} />
                <input type="text" placeholder="User ID" value={userID} onChange={e => setUserID(e.target.value)} />
                <input type="email" placeholder="Email" value={email} onChange={e => setEmail(e.target.value)} />
                <input type="text" placeholder="Phone" value={phone} onChange={e => setPhone(e.target.value)} />
                <input type="password" placeholder="Password" value={password} onChange={e => setPassword(e.target.value)} />
                <button type="submit">Register</button>
            </form>
            {message && <div className="message">{message}</div>}
        </div>
    );
}

export default Employ_register;
