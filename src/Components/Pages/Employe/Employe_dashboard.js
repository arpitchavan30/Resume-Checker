import React, { useState } from "react";
import '../Employe/Employe_dashboard.css'; 

const EmployeeDashboard = () => {
    const [keywords, setKeywords] = useState('');
    const [users, setUsers] = useState(JSON.parse(localStorage.getItem('userData')) || []);

    const filterUsers = () => {
        const filteredUsers = users.filter(user =>
            user.skill.includes(keywords.toLowerCase())
        );
        return filteredUsers;
    };

    const handleShortlist = (userName) => {
        const updatedUsers = users.map(user => {
            if (user.firstname === userName) {
                return { ...user, status: 'shortlisted' };
            }
            return user;
        });
        setUsers(updatedUsers);
        localStorage.setItem('userData', JSON.stringify(updatedUsers));
    };

    return (
        <div className="employee-dashboard">
            <h1>Employee Dashboard</h1>
            <div className="search">
                <label>Enter Job Keywords:</label>
                <input
                    type="text"
                    value={keywords}
                    onChange={(e) => setKeywords(e.target.value)}
                />
            </div>
            <table>
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Status</th>
                        <th>Skills</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    {filterUsers().map(user => (
                        <tr key={user.name}>
                            <td>{user.firstname}</td>
                            <td>{user.status}</td>
                            <td>{user.skill}</td>
                            <td>
                                {user.status !== 'shortlisted' &&
                                    <button onClick={() => handleShortlist(user.name)}>
                                        Shortlist
                                    </button>
                                }
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
}

export default EmployeeDashboard;
