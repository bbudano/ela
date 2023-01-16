import axios from 'axios'
import { useEffect, useState } from 'react';
import { Routes, Route } from 'react-router-dom';
import './App.css';
import Admin from './components/Admin';
import User from './components/User';
import setupResponseInterceptor from './axiosConfig';

setupResponseInterceptor();

function App() {

  const [user, setUser] = useState<null | string>(null);

  useEffect(() => {
    axios.get("/v1/user/profile")
      .then(response => {
        setUser(response.data.name)
      })
  }, [])

  return (
    <div className="App">
      <h1>{user}</h1>
      <Routes>
        <Route path="admin" element={ <Admin /> } />
        <Route path="user" element={ <User /> } />
      </Routes>
    </div>
  );
}

export default App;
