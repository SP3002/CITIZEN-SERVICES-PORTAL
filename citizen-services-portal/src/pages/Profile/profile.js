import React, { useState, useEffect } from 'react';
import axios from "axios";
import './profile.css';
import { useAuth } from "../../components/AuthContext";

const UpdateProfile = () => {

    const { isAuthenticated, logout } = useAuth();

    const [userDetails, setUserDetails] = useState({
        firstName: "",
        middleName: "",
        lastName: "",
        dateOfBirth: "",
        gender: "",
        maritalStatus: "",
        area: "",
        state: "",
        caste: "",
        differentlyAbled: "",
        differentlyAbledPercentage: "",
        minority: "",
        student: "",
        currentEmployment: "",
        bpl: "",
        hardship: "",
        familyIncome: "",
        pincode: "",
        mobileNumber: "",
        aadharNumber: "",
        email: "",
        password: ""
    });

    const genderOptions = ["MALE","FEMALE","TRANSGENDER"];
    const maritalStatusOptions = ["MARRIED","UNMARRIED","DIVORCED","WIDOW"];
    const areaOptions = ["RURAL","URBAN"];
    const casteOptions = ["General", "OBC", "SC", "ST"];
    const differentlyAbledOptions = ["YES", "NO"];
    
    const minorityOptions = ["YES", "NO"];
    const studentOptions = ["YES", "NO"];
    const employmentOptions = ["EMPLOYED", "UNEMPLOYED"];
    const bplOptions = ["YES", "NO"];
    const hardshipOptions = ["YES", "NO"];;

    useEffect(() => {
        axios.get("/getProfile", { withCredentials: true })
            .then(response => {
                if (response.data) {
                    setUserDetails(response.data);
                }
            })
            .catch(error => console.error("Error fetching user details:", error));
    }, []);

    const handleChange = (e) => {
        setUserDetails({ ...userDetails, [e.target.name]: e.target.value });
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
            await axios.post("/updateProfile", userDetails, {
                withCredentials: true
            });
            alert("Profile updated successfully!");
        } catch (error) {
            console.error("Error updating profile:", error);
            alert("Failed to update profile.");
        }
    };

    return (
        <div>
            <h2>Update Profile</h2>
            <form onSubmit={handleSubmit}>
                {Object.keys(userDetails).map((key) => (
                    key !== "aadharNumber" ? (
                        <div key={key} className="form-group">
                            <label>{key.replace(/([A-Z])/g, " $1").trim()}</label>
                            {[
                                "gender", "maritalStatus", "area", "state", "caste",
                                "differentlyAbled", "differentlyAbledPercentage", "minority",
                                "student", "currentEmployment", "bpl", "hardship"
                            ].includes(key) ? (
                                <select name={key} value={userDetails[key] || ""} onChange={handleChange} required>
                                    <option value="">Select {key.replace(/([A-Z])/g, " $1").trim()}</option>
                                    {(() => {
                                        switch (key) {
                                            case "gender": return genderOptions;
                                            case "maritalStatus": return maritalStatusOptions;
                                            case "area": return areaOptions;
                                            case "caste": return casteOptions;
                                            case "differentlyAbled": return differentlyAbledOptions;
                                            case "minority": return minorityOptions;
                                            case "student": return studentOptions;
                                            case "currentEmployment": return employmentOptions;
                                            case "bpl": return bplOptions;
                                            case "hardship": return hardshipOptions;
                                            default: return [];
                                        }
                                    })().map((option, index) => (
                                        <option key={index} value={option}>{option}</option>
                                    ))}
                                </select>
                            ) : (
                                <input
                                    type="text"
                                    name={key}
                                    value={userDetails[key] || ""}
                                    onChange={handleChange}
                                    required
                                />
                            )}
                        </div>
                    ) : (
                        <div key={key} className="form-group">
                            <label>{key.replace(/([A-Z])/g, " $1").trim()}</label>
                            <input
                                type="text"
                                name={key}
                                value={userDetails[key] || ""}
                                disabled
                            />
                        </div>
                    )
                ))}
                <button type="submit">Update Profile</button>
            </form>
        </div>
    );
};

export default UpdateProfile;
