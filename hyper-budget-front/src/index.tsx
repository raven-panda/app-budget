import React from 'react';
import ReactDOM from 'react-dom/client';
import { RouterProvider } from "react-router-dom";
import { ToastContainer } from 'react-toastify';
import 'react-toastify/dist/ReactToastify.css';
import './index.css';
import reportWebVitals from './reportWebVitals';
import { router } from './router/router';
import { QueryClientProvider } from 'react-query';
import { queryClient } from './api/Request';

const IS_STRICT_MODE = import.meta.env.VITE_STRICT_MODE_ENABLED === "true";

export default function App() {
  return IS_STRICT_MODE ?
      <React.StrictMode>
        <ToastContainer/>
        <QueryClientProvider client={queryClient}>
          <RouterProvider router={router}/>
        </QueryClientProvider>
      </React.StrictMode>
      : <>
        <ToastContainer/>
        <QueryClientProvider client={queryClient}>
          <RouterProvider router={router}/>
        </QueryClientProvider>
      </>
}

let container: HTMLElement|null = null;

document.addEventListener('DOMContentLoaded', function(event) {
  if (!container) {
    container = document.getElementById('root') as HTMLElement;
    const root = ReactDOM.createRoot(container)
    root.render(<App/>);
  }
});

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
