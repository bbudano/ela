import { useRecoilValue } from 'recoil';
import { userData } from '../App';

type Props = {}

function Home({ }: Props) {

    const user = useRecoilValue(userData);

    return (
        <>
            <div>{user?.email}</div>
            <div>{user?.firstName}</div>
            <div>{user?.lastName}</div>
            <div>{user?.role}</div>
            <div>{user?.team}</div>
        </>
    )
}

export default Home
