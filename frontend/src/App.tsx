import { Routes, Route } from 'react-router-dom';
import './App.css';
import Admin from './components/Admin';
import User from './components/User';

function App() {
  return (
    <div className="App">
      <h1>Hello</h1>
      <Routes>
        <Route path="admin" element={ <Admin /> } />
        <Route path="user" element={ <User /> } />
      </Routes>
    </div>
  );
}

export default App;
