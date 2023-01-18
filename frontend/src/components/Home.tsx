import { useRecoilValue } from 'recoil';
import { userData } from '../App';

type Props = {}

function Home({ }: Props) {

    const user = useRecoilValue(userData);

    return (
        <>
            <div>{user?.name}</div>
        </>
    )
}

export default Home
