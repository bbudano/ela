import axios from "axios";

export const redirectToGoogleLogin = () => {
    window.location.replace('http://localhost:8080/oauth2/authorization/google')
}

export const getUserProfile = async () => {
    try {
        const response = await axios.get("/api/v1/users/profile");
        return response.data;
    } catch (error) {
        return null;
    }
}

export const logout = async () => {
    try {
        const response = await axios.post("/logout");
        return response;
    } catch (error) {
        return undefined;
    }
}