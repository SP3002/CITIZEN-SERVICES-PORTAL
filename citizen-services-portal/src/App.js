import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import HomePage from "./pages/HomePage/HomePage";
import Login from "./pages/Login/Login"
import Registration from "./pages/Registration/Registration"
import UserPage from "./pages/UserPage/UserPage"
import Navbar from "./components/Navbar";
import CategoryPage from "./pages/CategoryPage/CategoryPage";
import Profile from "./pages/Profile/profile";
import { AuthProvider } from "./components/AuthContext";

function App() {
  return (
    <AuthProvider>
      <Router>
        <Navbar />
        
        <Routes>
          <Route path="/" element={<HomePage/>} />
          <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Registration />} />
          <Route path="/user" element={<UserPage />} />
          {/* Dynamic route for category-based scheme pages */}
          <Route path="/category/:category" element={<CategoryPage />} />
          <Route path="/profile" element={<Profile />} />
        </Routes>
      </Router>
    </AuthProvider>
  );
}

export default App;
