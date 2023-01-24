import axios from "axios";
import { useEffect } from "react";
import { atom, useRecoilState } from "recoil"

type Props = {}

export const teamsData = atom<[] | [{id: number, name: string}]>({
    key: 'teamsData',
    default: []
})

function Teams({ }: Props) {

    const [teams, setTeams] = useRecoilState(teamsData);

    const getTeams = () => {
        axios.get('/api/v1/teams')
            .then(response => setTeams(response.data.content))
            .catch(error => setTeams([]));
    }

    useEffect(() => {
        getTeams();
    }, [])

    return (
        <>
            {teams?.map(team => {
                return <div>
                    <span>{`${team.id}: ${team.name}`}</span>
                </div>
            })}
        </>
    )
}

export default Teams