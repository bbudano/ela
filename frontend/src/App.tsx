import axios from 'axios';
import { useEffect } from 'react';
import { Route, Routes } from 'react-router-dom';
import { atom, useRecoilState } from 'recoil';
import './App.css';
import setupResponseInterceptor from './utils/AxiosConfig';
import Home from './components/Home';
import Login from './components/Login';

setupResponseInterceptor();

export const userData = atom({
  key: 'userData',
  default: null
})

function App() {

  const [user, setUser] = useRecoilState(userData);

  useEffect(() => {
    axios.get("/api/v1/user/profile")
      .then(response => {
        setUser(response.data.name);
      })
  }, [])

  return (
    <div className="App">
      <Routes>
        <Route index element={ <Home /> } />
        <Route path="/login" element={ <Login /> } />
      </Routes>
    </div>
  );
}

export default App;
