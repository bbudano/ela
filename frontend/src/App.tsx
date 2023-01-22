import { useEffect } from 'react';
import { Route, Routes } from 'react-router-dom';
import { atom, useRecoilState } from 'recoil';
import './App.css';
import Home from './components/Home';
import Login from './components/Login';
import Navbar from './components/Navbar';
import { getUserProfile } from './utils/AuthUtils';
import setupResponseInterceptor from './utils/AxiosConfig';

setupResponseInterceptor();

export const userData = atom<null | { email: string, firstName: string, lastName: string, role: string, team: string }>({
  key: 'userData',
  default: null
})

function App() {

  const [user, setUser] = useRecoilState(userData);

  useEffect(() => {
    getUserProfile().then(user => setUser(user));
  }, [])

  return (
    <div className="App">
      {user && <Navbar />}
      <Routes>
        <Route index element={<Home />} />
        <Route path="/login" element={<Login />} />
      </Routes>
    </div>
  );
}

export default App;
