import { useState } from "react";
import { Formik, Form, Field, ErrorMessage } from "formik";
import * as Yup from "yup";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../../components/AuthContext";
import './Login.css';
  
const Login = () => {
  const navigate = useNavigate();
  const { isAuthenticated, login } = useAuth();
  const [serverError, setServerError] = useState("");

  const initialValues = {
    username: "",
    password: "",
  };

  const validationSchema = Yup.object({
    username: Yup.string().required("Required"),
    password: Yup.string().required("Required"),
  });

  const handleSubmit = async (values) => {
    try {
        await axios.post("/login", values,{
          auth: {
            username: "csp",
            password: "csp123"
          },
          withCredentials: true 
        });
        alert("Login Successful!");
        login();
        navigate("/user"); // Change based on success
      } catch (error) {
        setServerError(error.response?.data?.message || "Login Failed");
      }
  };

  return (
    <div className="login-container">
      <div className="login-form">
        <h2>Login</h2>
        {serverError && <p className="error-message">{serverError}</p>}
        <Formik initialValues={initialValues} validationSchema={validationSchema} onSubmit={handleSubmit}>
          <Form className="form">
            <Field type="text" name="username" placeholder="Email, Mobile, or Aadhar" className="input-field" />
            <ErrorMessage name="username" component="div" className="error-message" />

            <Field type="password" name="password" placeholder="Password" className="input-field" />
            <ErrorMessage name="password" component="div" className="error-message" />

            <button type="submit" className="submit-btn" >Login</button>
          </Form>
        </Formik>
        <div className="register-link">
          <span>New user? </span>
          <a href="/register">Register here</a>
        </div>
      </div>
    </div>
  );
};

export default Login;
