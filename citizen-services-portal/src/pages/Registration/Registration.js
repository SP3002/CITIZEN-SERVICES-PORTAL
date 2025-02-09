import { useState } from "react";
import { Formik, Form, Field, ErrorMessage } from "formik";
import * as Yup from "yup";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import "./Registration.css";
 
const Registration = () => {
  const navigate = useNavigate();
  const [serverError, setServerError] = useState("");

  const initialValues = {
    firstName: "",
    middleName: "",
    lastName: "",
    dateOfBirth: "",
    gender: "",
    maritalStatus: "",
    area: "",
    state: "",
    caste: "",
    differentlyAbled: "NO",
    differentlyAbledPercentage: "",
    minority: "NO",
    student: "NO",
    currentEmployment: "",
    bpl: "NO",
    hardship: "NO",
    familyIncome: "",
    pincode: "",
    mobileNumber: "",
    aadharNumber: "",
    email: "",
    password: "",
  };

  const validationSchema = Yup.object({
    firstName: Yup.string().required("Required"),
    middleName: Yup.string(),
    lastName: Yup.string().required("Required"),
    dateOfBirth: Yup.date().required("Required"),
    gender: Yup.string().required("Required"),
    maritalStatus: Yup.string().required("Required"),
    area: Yup.string().required("Required"),
    state: Yup.string().required("Required"),
    caste: Yup.string().required("Required"),
    differentlyAbledPercentage: Yup.number()
      .min(0, "Invalid Percentage")
      .max(100, "Invalid Percentage"),
    currentEmployment: Yup.string().required("Current Employment is required"),
    familyIncome: Yup.number().required("Required"),
    pincode: Yup.string().matches(/^\d{6}$/, "Invalid Pincode").required("Required"),
    mobileNumber: Yup.string().matches(/^\d{10}$/, "Invalid Mobile Number").required("Required"),
    aadharNumber: Yup.string().matches(/^\d{12}$/, "Invalid Aadhar Number").required("Required"),
    email: Yup.string().email("Invalid Email").required("Required"),
    password: Yup.string().min(5, "Password must be at least 5 characters").required("Required"),
  });

  const handleSubmit = async (values) => {
    try {
      await axios.post("/RegisterUser", values);
      alert("Registration Successful!");
      navigate("/login");
    } catch (error) {
      setServerError(error.response?.data?.message || "Registration Failed");
    }
  };

  return (
    <div className="register-container">
      <div className="register-form">
        <h2>Register</h2>
        {serverError && <p className="error-message">{serverError}</p>}
        <Formik initialValues={initialValues} validationSchema={validationSchema} onSubmit={handleSubmit}>
          <Form className="form">
            {/* First Name */}
            <div className="form-group">
              <Field type="text" name="firstName" placeholder="First Name" className="input-field" />
              <ErrorMessage name="firstName" component="div" className="error-message" />
            </div>

            {/* Middle Name */}
            <div className="form-group">
              <Field type="text" name="middleName" placeholder="Middle Name" className="input-field" />
              <ErrorMessage name="middleName" component="div" className="error-message" />
            </div>

            {/* Last Name */}
            <div className="form-group">
              <Field type="text" name="lastName" placeholder="Last Name" className="input-field" />
              <ErrorMessage name="lastName" component="div" className="error-message" />
            </div>

            {/* Date of Birth */}
            <div className="form-group">
              <Field type="date" name="dateOfBirth" className="input-field" />
              <ErrorMessage name="dateOfBirth" component="div" className="error-message" />
            </div>

            {/* Gender */}
            <div className="form-group">
              <Field as="select" name="gender" className="input-field">
                <option value="">Select Gender</option>
                <option value="MALE">MALE</option>
                <option value="FEMALE">FEMALE</option>
                <option value="TRANSGENDER">TRANSGENDER</option>
              </Field>
              <ErrorMessage name="gender" component="div" className="error-message" />
            </div>

            {/* Marital Status */}
            <div className="form-group">
              <Field as="select" name="maritalStatus" className="input-field">
                <option value="">Select Marital Status</option>
                <option value="UNMARRIED">UNMARRIED</option>
                <option value="MARRIED">MARRIED</option>
                <option value="WIDOW">WIDOW</option>
                <option value="DIVORCED">DIVORCED</option>
              </Field>
              <ErrorMessage name="maritalStatus" component="div" className="error-message" />
            </div>

            {/* Area */}
            <div className="form-group">
              <Field as="select" name="area" placeholder="Area" className="input-field" >
                <option value="">Select Area</option>
                <option value="URBAN">URBAN</option>
                <option value="RURAL">RURAL</option>
              </Field>
              <ErrorMessage name="area" component="div" className="error-message" />
            </div>
            
            {/* State */}
            <div className="form-group">
              <Field type="text" name="state" placeholder="State" className="input-field" />
              <ErrorMessage name="state" component="div" className="error-message" />
            </div>

            {/* Caste */}
            <div className="form-group">
              <Field as="select" name="caste" placeholder="Caste" className="input-field" >
                <option value="">Select Caste</option>
                <option value="GEN">GEN</option>
                <option value="OBC">OBC</option>
                <option value="SC">SC</option>
                <option value="ST">ST</option>
              </Field>  
              <ErrorMessage name="caste" component="div" className="error-message" />
            </div>

            {/* Differently Abled */}
            <div className="form-group">
              <label>Are you differently abled?</label>
              <Field as="select" name="differentlyAbled" className="input-field">
                <option value="NO">NO</option>
                <option value="YES">YES</option>
              </Field>
            </div>

            {/* Differently Abled Percentage */}
            <div className="form-group">
              <Field
                type="number"
                name="differentlyAbledPercentage"
                placeholder="Differently Abled Percentage"
                className="input-field"
              />
              <ErrorMessage
                name="differentlyAbledPercentage"
                component="div"
                className="error-message"
              />
            </div>

            {/* Minority */}
            <div className="form-group">
              <label>Minority Status</label>
              <Field as="select" name="minority" className="input-field">
                <option value="NO">No</option>
                <option value="YES">Yes</option>
              </Field>
            </div>

            {/* Student */}
            <div className="form-group">
              <label>Are you a student?</label>
              <Field as="select" name="student" className="input-field">
                <option value="NO">No</option>
                <option value="YES">Yes</option>
              </Field>
            </div>

            {/* Current Employment */}
            <div className="form-group">
              <Field
                as="select"
                name="currentEmployment"
                placeholder="Current Employment"
                className="input-field"
              >
                <option value="">Select Employment</option>
                <option value="EMPLOYED">EMPLOYED</option>
                <option value="UNEMPLOYED">UNEMPLOYED</option>
                <option value="SELF_EMPLOYED">SELF EMPLOYED</option>
                
               </Field> 
              <ErrorMessage
                name="currentEmployment"
                component="div"
                className="error-message"
              />
            </div>

            {/* BPL */}
            <div className="form-group">
              <label>BPL (Below Poverty Line)</label>
              <Field as="select" name="bpl" className="input-field">
                <option value="NO">No</option>
                <option value="YES">Yes</option>
              </Field>
            </div>

            {/* Hardship */}
            <div className="form-group">
              <label>Do you face any hardship?</label>
              <Field as="select" name="hardship" className="input-field">
                <option value="NO">No</option>
                <option value="YES">Yes</option>
              </Field>
            </div>

            {/* Family Income */}
            <div className="form-group">
              <Field
                type="number"
                name="familyIncome"
                placeholder="Family Income"
                className="input-field"
              />
              <ErrorMessage
                name="familyIncome"
                component="div"
                className="error-message"
              />
            </div>

            {/* PinCode */}
            <div className="form-group">
              <Field type="text" name="pincode" placeholder="Pincode" className="input-field" />
              <ErrorMessage name="pincode" component="div" className="error-message" />
            </div>

            {/* Mobile Number */}
            <div className="form-group">
              <Field type="text" name="mobileNumber" placeholder="Mobile Number" className="input-field" />
              <ErrorMessage name="mobileNumber" component="div" className="error-message" />
            </div>

            {/* Aadhar Number */}
            <div className="form-group">
              <Field type="text" name="aadharNumber" placeholder="Aadhar Number" className="input-field" />
              <ErrorMessage name="aadharNumber" component="div" className="error-message" />
            </div>

            {/* Email */}
            <div className="form-group">
              <Field type="email" name="email" placeholder="Email" className="input-field" />
              <ErrorMessage name="email" component="div" className="error-message" />
            </div>

            {/* Password */}
            <div className="form-group">
              <Field type="password" name="password" placeholder="Password" className="input-field" />
              <ErrorMessage name="password" component="div" className="error-message" />
            </div>

            <button type="submit" className="submit-btn">Register</button>
          </Form>
        </Formik>
        <div className="login-link">
          <span>Already have an account? </span>
          <a href="/login">Login here</a>
        </div>
      </div>
    </div>
  );
};

export default Registration;
