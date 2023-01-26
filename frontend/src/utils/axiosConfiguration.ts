import axios from 'axios';
import { redirectToGoogleLogin } from './authUtil';

axios.defaults.baseURL = 'http://localhost:8080'
axios.defaults.withCredentials = true;

export type Pageable = {
    page?: number;
    size?: number;
    sort?: string;
}

export const setupResponseInterceptor = () => {
    axios.interceptors.response.use(response => {
        return response;
    }, error => {
        if (error.response.status === 401) {
            redirectToGoogleLogin();
        }
        return Promise.reject();
    });
}
