import React, { useState } from "react";
import "../User/User.css";
import { useNavigate } from "react-router-dom";



const User = () => {

     const navigate = useNavigate();
  const [formData, setFormData] = useState({
    firstname: "",
    lastname: "",
    number: "",
    email: "",
    experience: "",
    rel_exp: "",
    qualification: "",
    skill: "",
    currentjob: "",
    joblocation: "",
    city: "",
    zipcode: "",
    resume: null,
  });

  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({
      ...prevData,
      [name]: value,
    }));
  };

  const handleFileChange = (e) => {
    const file = e.target.files[0];
    setFormData((prevData) => ({
      ...prevData,
      resume: file,
    }));
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    const form = e.target;
    if (!form.checkValidity()) {
      console.error("Form is invalid");
      return;
    }

    const userData = JSON.parse(localStorage.getItem('userData')) || [];

    localStorage.setItem('userData', JSON.stringify([...userData, formData]));
     navigate("/user/dashboard");
    
  };

  return (
    <div id="user">
      <form id="user-form" onSubmit={handleSubmit}>
        <div className="user-div">
          <label>First Name:</label>
          <input
            type="text"
            name="firstname"
            value={formData.firstname}
            placeholder="First Name"
            onChange={handleInputChange}
            required
          />
        </div>
        <div className="user-div">
          <label>Last Name:</label>
          <input
            type="text"
            name="lastname"
            value={formData.lastname}
            placeholder="Last Name"
            onChange={handleInputChange}
            required
          />
        </div>
        <div className="user-div">
          <label>Phone Number:</label>
          <input
            type="tel"
            name="number"
            value={formData.number}
            placeholder="Phone"
            onChange={handleInputChange}
            required
          />
        </div>
        <div className="user-div">
          <label>Email:</label>
          <input
            type="email"
            name="email"
            value={formData.email}
            placeholder="Email"
            onChange={handleInputChange}
            required
          />
        </div>
        <div className="user-div-select">
          <label>Experience in Years:</label>
          <select
            name="experience"
            value={formData.experience}
            onChange={handleInputChange}
            required
          >
            <option value="">Select...</option>
            <option value="0">Fresher</option>
            <option value="2">1-2 years</option>
            <option value="5">3-5 years</option>
            <option value="8">more than 5</option>
          </select>
        </div>
        <div className="user-div-select">
          <label>Relevant Experience:</label>
          <select
            name="rel_exp"
            value={formData.rel_exp}
            onChange={handleInputChange}
            required
          >
            <option value="">Select...</option>
            <option value="0">Fresher</option>
            <option value="2">1-2 years</option>
            <option value="5">3-5 years</option>
            <option value="8">more than 5</option>
          </select>
        </div>
        <div className="user-div">
          <label>Highest Qualification Held:</label>
          <input
            type="text"
            name="qualification"
            value={formData.qualification}
            placeholder="Qualification"
            onChange={handleInputChange}
            required
          />
        </div>
        <div className="user-div">
          <label>Skills:</label>
          <input
            type="text"
            name="skill"
            value={formData.skill}
            placeholder="Skills"
            onChange={handleInputChange}
            required
          />
        </div>
        <div className="user-div">
          <label>Current Job Title:</label>
          <input
            type="text"
            name="currentjob"
            value={formData.currentjob}
            placeholder="Current Job Title"
            onChange={handleInputChange}
            required
          />
        </div>
        <div className="user-div">
          <label>Current Job Location:</label>
          <input
            type="text"
            name="joblocation"
            value={formData.joblocation}
            placeholder="Current Job Location"
            onChange={handleInputChange}
            required
          />
        </div>
        <div className="user-div">
          <label>City:</label>
          <input
            type="text"
            name="city"
            value={formData.city}
            placeholder="City"
            onChange={handleInputChange}
            required
          />
        </div>
        <div className="user-div">
          <label>Zip Code:</label>
          <input
            type="text"
            name="zipcode"
            value={formData.zipcode}
            placeholder="Zip-Code"
            onChange={handleInputChange}
            required
          />
        </div>
        <div id="upload" className="user-div">
          <label>Upload resume:</label>
          <input
            type="file"
            name="resume"
            accept=".pdf, .doc, .docx"
            onChange={handleFileChange}
            required
          />
        </div>
        <button id="btn" type="submit">Register</button>
      </form>
    </div>
  );
};

export default User;
