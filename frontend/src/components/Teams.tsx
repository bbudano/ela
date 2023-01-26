import { useEffect } from "react";
import { atom, useRecoilState } from "recoil";
import { getTeams, TeamsResponse } from "../api/teamsApi";

type Props = {}

export const teamsData = atom<TeamsResponse>({
    key: 'teamsData',
    default: []
})

function Teams({ }: Props) {

    const [teams, setTeams] = useRecoilState(teamsData);

    useEffect(() => {
        getTeams({ page: 0, size: 10 }).then(response => setTeams(response));
    }, [])

    return (
        <>
            {teams?.map((team) => {
                return <div key={team.id}>
                    <span>{`${team.id}: ${team.name}`}</span>
                </div>
            })}
        </>
    )
}

export default Teams