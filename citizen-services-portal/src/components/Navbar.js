import React from 'react';
import { Link, useNavigate } from 'react-router-dom';
import './Navbar.css';
import logo from '../Assets/JSLightGreen.jpg'; // Importing logo
import profileImg from '../Assets/ProfileImg.jpg'; // Import Profile Image
import { useAuth } from './AuthContext'; // Import Auth Context

const Navbar = () => {
    const { isAuthenticated, logout } = useAuth(); // Get auth state & logout function
    const navigate = useNavigate();

    const handleLogout = () => {
        logout();
        navigate('/');
    };

    return (
        <div className='navbar'>
            <div className='logo'>
                <Link to="/">
                    <img src={logo} alt="Logo" className="navbar-logo" />
                </Link>
            </div>
            <div className='nav-links'>
                {isAuthenticated ? (
                    <>
                        <button onClick={handleLogout} className="auth-btn">Logout</button>
                        <Link to="/profile">
                            <img src={profileImg} alt="Profile" className="profile-pic" />
                        </Link>
                    </>
                ) : (
                    <div className="buttons">
                        <Link to="/login"><button className='auth-btn'>Login</button></Link>
                        <Link to="/register"><button className='auth-btn'>Register</button></Link>
                    </div>
                )}
            </div>
        </div>
    );
};

export default Navbar;
