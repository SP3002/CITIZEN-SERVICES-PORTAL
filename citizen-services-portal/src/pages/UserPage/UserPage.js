import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import "./UserPage.css";

const UserPage = () => {
  const navigate = useNavigate();
  const [user, setUser] = useState(null);

  useEffect(() => {
    fetch("/UserPage", {  
      method: "GET",
      credentials: "include",
      headers: {
        "Content-Type": "application/json"
      }
    })
      .then((response) => {
        if (!response.ok) {
          throw new Error("No user found");
        }
        return response.json();
      })
      .then((data) => setUser(data))
      .catch((error) => {
        console.error("Error Fetching user details:", error);
        navigate("/login");
      });
  }, [navigate]);

  const handleCategoryClick = (category) => {
    navigate(`/category/${category}`);
  };

  return (
    <div className="buttons-container">
      <div className="welcome-user">
        <h1>Welcome,{user ? `${user.firstName} ${user.middleName} ${user.lastName}` : "Loading..."}</h1>
      </div>
      <div className="user-content">
        <h1>Government Schemes Categories</h1>
        <div className="button-wrapper">
          {["Agriculture, Rural & Environment", "Education & Learning", "Health & Wellness", "Women & Child"].map((category) => (
            <button key={category} className="category-button" onClick={() => handleCategoryClick(category)}>
              {category}
            </button>
          ))}
        </div>
      </div>
    </div>
  );
};

export default UserPage;
