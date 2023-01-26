import axios from "axios";
import { Pageable } from "../utils/axiosConfiguration";

export type TeamsResponse = [] | {
    id: number;
    name: string;
    baseAllowance: number;
}[]

export const getTeams = ({ page, size }: Pageable) => {
    return axios.get('/api/v1/teams', {
        params: { page, size }
    })
        .then(response => response.data.content as TeamsResponse)
        .catch(error => []);
}
