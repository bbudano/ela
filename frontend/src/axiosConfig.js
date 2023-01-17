import axios from 'axios';

axios.defaults.baseURL = 'http://localhost:8080'
axios.defaults.withCredentials = true;

const setupResponseInterceptor = () => {
    axios.interceptors.response.use(response => {
        return response;
    }, error => {
        if (error.response.status === 401) {
            window.location.replace('http://localhost:8080/oauth2/authorization/google')
        }
        return Promise.reject();
    });
}

export default setupResponseInterceptor; 