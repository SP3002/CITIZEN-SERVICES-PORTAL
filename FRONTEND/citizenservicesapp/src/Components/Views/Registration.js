import React, { useState } from "react";
import { Link } from "react-router-dom";
import axios from "axios";
import bcrypt from "bcryptjs";

const Register = () => {
  const [formData, setFormData] = useState({
    firstName: "",
    middleName: "",
    lastName: "",
    dateOfBirth: "",
    mobileNumber: "",
    pincode: "",
    address: "",
    aadharId: "",
    email: "",
    password: ""
  });

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value,
      fullName: `${formData.firstName} ${formData.middleName} ${formData.lastName}`
    });
  };

  const checkPincode = async () => {
    if (formData.pincode.length === 6) {
      try {
        const response = await axios.get(`https://api.postalpincode.in/pincode/${formData.pincode}`);
        if (response.data[0].Status === "Success") {
          setFormData({ ...formData, address: response.data[0].PostOffice[0].Name });
        } else {
          alert("Invalid Pincode");
        }
      } catch (error) {
        console.error("Pincode API Error", error);
      }
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (formData.mobileNumber.length !== 10 || formData.aadharId.length !== 12) {
      alert("Invalid Mobile or Aadhaar Number");
      return;
    }
    const hashedPassword = await bcrypt.hash(formData.password, 10);
    const payload = { ...formData, password: hashedPassword };
    console.log("Submitting Data: ", payload);
  };

  return (
    <div className="container">
      <h2>Register</h2>
      <form onSubmit={handleSubmit} className="form-container">
        <input type="text" name="firstName" placeholder="First Name" onChange={handleChange} required />
        <input type="text" name="middleName" placeholder="Middle Name" onChange={handleChange} />
        <input type="text" name="lastName" placeholder="Last Name" onChange={handleChange} required />
        <input type="text" name="fullName" value={formData.fullName} readOnly />
        <input type="date" name="dateOfBirth" onChange={handleChange} required />
        <input type="text" name="mobileNumber" placeholder="Mobile Number" maxLength="10" onChange={handleChange} required />
        <input type="text" name="pincode" placeholder="Pincode" maxLength="6" onBlur={checkPincode} onChange={handleChange} required />
        <input type="text" name="address" value={formData.address} readOnly />
        <input type="text" name="aadharId" placeholder="Aadhaar ID" maxLength="12" onChange={handleChange} required />
        <input type="email" name="email" placeholder="Email" onChange={handleChange} required />
        <input type="password" name="password" placeholder="Password" onChange={handleChange} required />
        <button type="submit">Register</button>
      </form>
      <p>Existing user? <Link to="/">Goto Login</Link></p>
    </div>
  );
};

export default Register;
