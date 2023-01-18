import axios from 'axios';
import { useNavigate } from 'react-router-dom';
import { useRecoilState } from 'recoil';
import { userData } from '../App';

type Props = {}

function Home({ }: Props) {

    const navigate = useNavigate();
    const [user, setUser] = useRecoilState(userData);

    const logout = () => {
        axios.post("/logout")
            .then(response => {
                setUser(null);
                navigate("/login");
            })
    }

    return (
        <>
            <div>{user}</div>
            <button onClick={logout}>Logout</button>
        </>
    )
}

export default Home