import axios from "axios";

const api = axios.create({
  baseURL: "http://localhost:8080/api", // backend url
  timeout: 10000,
});

// attach token automatically if present in localStorage
api.interceptors.request.use((config) => {
  const token = localStorage.getItem("token");
  if (token) {
    config.headers = config.headers || {};
    config.headers.Authorization = `Bearer ${token}`;
  }
  return config;
}, (error) => Promise.reject(error));

export default api;
