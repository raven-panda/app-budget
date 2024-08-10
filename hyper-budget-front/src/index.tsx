import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import { RouterProvider } from "react-router-dom";
import reportWebVitals from './reportWebVitals';
import router from './routes';
import UserService from '@service/UserService';
import { UserContext } from '@service/context/UserContext';

export default function App() {
  const userService = new UserService();

  return (
    <React.StrictMode>
      <UserContext.Provider value={[userService.getUser(), ""]}>
        <RouterProvider router={router}/>
      </UserContext.Provider>
    </React.StrictMode>
  )
}

const root = ReactDOM.createRoot(
  document.getElementById('root') as HTMLElement
);
root.render(<App />);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
