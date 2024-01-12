import axios from 'axios';

const axiosInstance = axios.create({
    baseURL: 'http://localhost:8000/api',
    headrers: {
        'Content-type': 'application/json'
    }
});

export default axiosInstance;
