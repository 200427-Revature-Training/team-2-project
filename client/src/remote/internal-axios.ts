import Axios from 'axios';

const baseUrl = 'http://ec2-18-224-183-46.us-east-2.compute.amazonaws.com:3001';

export const internalAxios = Axios.create({
    baseURL: baseUrl
});

// Authenication: send token
export const authAxios = Axios.create({
    baseURL: baseUrl,
    headers: {
        Authorization: `Bearer ${localStorage.getItem('accessToken')}`,
    },
});