import { useNavigate } from 'react-router-dom';
import { useRecoilState } from 'recoil';
import { userData } from '../App';
import { logout } from '../utils/AuthUtils';

type Props = {}

function Navbar({ }: Props) {

    const navigate = useNavigate();
    const [user, setUser] = useRecoilState(userData);

    const handleLogout = () => {
        logout().then(response => {
            if (typeof response === 'undefined') return;
            setUser(null);
            navigate("/login");
        })
    }

    return (
        <div style={{ backgroundColor: '#95fcd0', display: 'flex', justifyContent: 'space-between' }}>
            <span style={{ padding: '6px', margin: '6px 6px 6px 10px' }}>ela</span>
            <button style={{ padding: '6px', margin: '4px', }} onClick={handleLogout}>Logout</button>
        </div>
    )
}

export default Navbar