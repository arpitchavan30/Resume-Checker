import React, { useState, useEffect } from 'react';
import "../Admin/Admin_function.css";

function EmployeeManagement() {
    const [employees, setEmployees] = useState([]);
    const [name, setName] = useState('');
    const [email, setEmail] = useState('');

    // Load employees from localStorage on component mount
    useEffect(() => {
        const storedEmployees = localStorage.getItem('employees');
        if (storedEmployees) {
            setEmployees(JSON.parse(storedEmployees));
        }
    }, []);

    // Function to generate random password
    const generatePassword = () => {
        const characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
        let password = '';
        for (let i = 0; i < 8; i++) {
            password += characters.charAt(Math.floor(Math.random() * characters.length));
        }
        return password;
    };

    // Function to handle employee creation
    const handleCreateEmployee = () => {
        const password = generatePassword();
        const newEmployee = { id: Date.now(), name, email, password, active: true };
        setEmployees([...employees, newEmployee]);
        setName('');
        setEmail('');
        saveEmployees([...employees, newEmployee]);
    };

    // Function to handle employee deactivation
    const handleDeactivateEmployee = (id) => {
        const updatedEmployees = employees.map(employee => {
            if (employee.id === id) {
                employee.active = false;
            }
            return employee;
        });
        setEmployees(updatedEmployees);
        saveEmployees(updatedEmployees);
    };

    // Function to handle employee deletion
    const handleDeleteEmployee = (id) => {
        const updatedEmployees = employees.filter(employee => employee.id !== id);
        setEmployees(updatedEmployees);
        saveEmployees(updatedEmployees);
    };

    // Function to save employees to localStorage
    const saveEmployees = (employees) => {
        localStorage.setItem('employees', JSON.stringify(employees));
    };

    return (
        <div className="employee-management">
            <h1>Employee Management</h1>
            <form onSubmit={e => { e.preventDefault(); handleCreateEmployee(); }}>
                <input type="text" placeholder="Name" value={name} onChange={e => setName(e.target.value)} />
                <input type="email" placeholder="Email" value={email} onChange={e => setEmail(e.target.value)} />
                <button  style={{width : "250px"}} type="submit">Create Employee</button>
            </form>
            <h2>Employees</h2>
            <table>
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Password</th>
                        <th>Active</th>
                        <th>Actions</th>
                    </tr>
                </thead>
                <tbody>
                    {employees.map(employee => (
                        <tr key={employee.id}>
                            <td>{employee.name}</td>
                            <td>{employee.email}</td>
                            <td>{employee.password}</td>
                            <td>{employee.active ? 'Yes' : 'No'}</td>
                            <td>
                                <button onClick={() => handleDeactivateEmployee(employee.id)}>Deactivate</button>
                                <button onClick={() => handleDeleteEmployee(employee.id)}>Delete</button>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}

export default EmployeeManagement;
