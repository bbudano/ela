import { Table, TableBody, TableCell, TableHead, TablePagination, TableRow } from "@mui/material";
import { useEffect } from "react";
import { atom, useRecoilState } from "recoil";
import { getTeams, TeamsResponse } from "../api/teamsApi";

type Props = {}

export const teamsResponse = atom<TeamsResponse>({
    key: 'teamsResponse',
    default: undefined
})

function Teams({ }: Props) {

    const [teams, setTeams] = useRecoilState(teamsResponse);

    useEffect(() => {
        getTeams({ page: 0, size: 10 }).then(response => response && setTeams(response));
    }, [])

    return (
        <>
            <Table>
                <TableHead>
                    <TableRow>
                        <TableCell align="left">ID</TableCell>
                        <TableCell align="center">Name</TableCell>
                        <TableCell align="right">Base allowance</TableCell>
                    </TableRow>
                </TableHead>
                <TableBody>
                    {teams?.content.map((team) => (
                        <TableRow key={team.id}>
                            <TableCell align="left">{team.id}</TableCell>
                            <TableCell align="center">{team.name}</TableCell>
                            <TableCell align="right">{team.baseAllowance}</TableCell>
                        </TableRow>
                    ))}
                </TableBody>
            </Table>
            <TablePagination
                rowsPerPageOptions={[5, 10, 20, 50, 100]}
                component="div"
                count={teams?.totalElements | 0}
                rowsPerPage={teams?.size || 10}
                page={teams?.number || 0}
                onPageChange={() => { }}
                onRowsPerPageChange={() => { }}
            />
        </>
    )
}

export default Teams