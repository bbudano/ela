import { useRecoilValue } from 'recoil';
import { userData } from '../App';

type Props = {}

function Dashboard({ }: Props) {

    const user = useRecoilValue(userData);

    return (
        <>
            <img src={user?.imageUrl} />
            <div>{user?.email}</div>
            <div>{user?.firstName}</div>
            <div>{user?.lastName}</div>
            <div>{user?.role}</div>
            <div>{user?.team}</div>
        </>
    )
}

export default Dashboard
