import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";
import "./CategoryPage.css";
 
const CategoryPage = () => {
  const { category } = useParams(); // Get category from URL
  const [schemes, setSchemes] = useState([]);
  const [error, setError] = useState("");

  useEffect(() => {
    const fetchSchemes = async () => {
      try{
        const response = await axios.post(
          "/eligibleschemes",
          { category }, // Send category in the request body as JSON
          {
            auth: {
              username: "csp",
              password: "csp123",
            },
            withCredentials: true, // Ensures session data is sent
            headers: {
              "Content-Type": "application/json",
            },
          }
        );
        setSchemes(response.data);
      }
      catch(err){
        setError("Error fetching schemes");
      }
    };

    fetchSchemes();
}, [category]);

  return (
    <div className="category-container">
      <h1>{category} Schemes</h1>
      {error && <p className="error-message">{error}</p>}
      <div className="card-container">
        {schemes.length > 0 ? (
          schemes.map((scheme) => (
            <div className="card" key={scheme.schemeId}>
              <h2>{scheme.schemeName}</h2>
              <p>{scheme.description}</p>
              <a href={scheme.schemeURL} target="_blank" rel="noopener noreferrer">Goto Website</a>
            </div>
          ))
        ) : (
          <p>No schemes available for this category.</p>
        )}
      </div>
    </div>
  );
};

export default CategoryPage;
