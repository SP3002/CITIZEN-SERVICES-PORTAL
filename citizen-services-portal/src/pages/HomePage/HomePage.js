import React from 'react';
// import "bootstrap/dist/css/bootstrap.min.css";
// import "bootstrap/dist/js/bootstrap.bundle.min";
import WelcomeImage from "../../Assets/HomePagebg.jpg"
import './HomePage.css';


const HomePage = () => {


  return (
    <div className='homepage-container'>

      {/* <Navbar /> */}

      <div className='image'>
        <img src={WelcomeImage} alt='Welcome to JanSeva'></img>
      </div>

      <div className='welcome'>
          <p>A Citizen Scheme Service Portal</p>

          <div className='description'>
          <h6>Despcription:</h6>
          <p>The Citizen Service Portal is a comprehensive web-based application designed to enhance accessibility and transparency in public services. Built using Spring Boot, MySQL, and React, the platform leverages RESTful APIs to provide a seamless experience for citizens searching and identifying government schemes tailored to their needs.

          With a user-friendly interface and secure authentication mechanisms, the portal ensures efficient data management, real-time updates, and personalized recommendations. Citizens can explore various categories of schemes, filter results based on eligibility criteria, and stay informed about newly introduced initiatives.

          By integrating modern web technologies and a scalable architecture, the Citizen Service Portal aims to bridge the gap between the government and the public, fostering digital empowerment and improved service delivery.</p>
        </div>

        <div className='developers'>
          <h6>Made by</h6>
          <p>-Aayushi Thakur (240840120003)
          -Saurabh Patil (240840120157)
          -Shashant Nagpure (240840120163)
          -Shruti Deshpande (240840120178)
          -Sonal Nikam (240840120191)</p>
        </div>
      </div>
    </div>
  )
}

export default HomePage
