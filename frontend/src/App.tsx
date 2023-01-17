import axios from 'axios'
import { useEffect, useState } from 'react';
import { Routes, Route, useNavigate } from 'react-router-dom';
import './App.css';
import setupResponseInterceptor from './axiosConfig';

setupResponseInterceptor();

function App() {

  const navigate = useNavigate();
  const [user, setUser] = useState<null | string>(null);

  useEffect(() => {
    axios.get("/api/v1/user/profile")
      .then(response => {
        setUser(response.data.name);
      })
  }, [])

  const logout = () => {
    axios.post("/logout")
    .then(response => {
      setUser(null);
      navigate("/login");
    })
  }

  return (
    <div className="App">
      <h1>{user}</h1>
      <button onClick={logout}>Logout</button>
      <Routes>
        <Route path="login" element={ <div>Login page</div> } />
      </Routes>
    </div>
  );
}

export default App;
