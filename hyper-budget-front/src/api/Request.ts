import axios from "axios";
import { QueryClient } from "react-query";

const BASE_URL = process.env.REACT_APP_FIXTURES_ENABLED === "true" ? process.env.REACT_APP_FIXTURES_URL : process.env.REACT_APP_API_URL;

export const queryClient = new QueryClient();

export const apiClient = axios.create({
    baseURL: BASE_URL,
    headers: {
      Accept: "application/json, text/plain, */*",
    }
})