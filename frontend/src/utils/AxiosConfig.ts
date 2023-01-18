import axios from 'axios';
import { redirectToGoogleLogin } from './AuthUtils';

axios.defaults.baseURL = 'http://localhost:8080'
axios.defaults.withCredentials = true;

const setupResponseInterceptor = () => {
    axios.interceptors.response.use(response => {
        return response;
    }, error => {
        if (error.response.status === 401) {
            redirectToGoogleLogin();
        }
        return Promise.reject();
    });
}

export default setupResponseInterceptor; 