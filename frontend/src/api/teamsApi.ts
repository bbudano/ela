import axios from "axios";
import { Pageable } from "../utils/axiosConfiguration";

export type TeamsContent = [] | {
    id: number;
    name: string;
    baseAllowance: number;
}[]

export type TeamsResponse = {
    content: TeamsContent,
    totalElements: number,
    totalPages: number,
    size: number,
    number: number
}

export const getTeams = ({ page, size }: Pageable) => {
    return axios.get('/api/v1/teams', {
        params: { page, size }
    })
        .then(response => response.data as TeamsResponse)
        .catch(error => undefined);
}
