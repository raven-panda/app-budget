import axios from "axios";
import { QueryClient } from "react-query";

const BASE_URL = import.meta.env.VITE_FIXTURES_ENABLED === "true" ? import.meta.env.VITE_FIXTURES_URL : import.meta.env.VITE_API_URL;

export const queryClient = new QueryClient();

export const apiClient = axios.create({
    baseURL: BASE_URL,
    headers: {
      Accept: "application/json, text/plain, */*",
    }
})