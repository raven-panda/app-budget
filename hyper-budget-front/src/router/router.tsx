import { queryClient } from "@/api/Request";
import DashboardHomePage from "@scene/private/dashboard/DashboardHomePage";
import ErrorPage from "@scene/public/error/ErrorPage";
import WelcomePage from "@scene/public/WelcomePage";
import { createBrowserRouter, Outlet } from "react-router-dom";
import { loader } from "./loader";
import UserService from "@/api/services/UserService";

export const clientRoutes = {
  root: "/",
  dashboard: "dashboard"
}

export const router = createBrowserRouter([
  {
    path: clientRoutes.root,
    element: <Outlet/>,
    errorElement: <ErrorPage />,
    children: [
      {
        path: "",
        element: <WelcomePage />
      },
      {
        path: clientRoutes.dashboard,
        element: <Outlet/>,
        children: [
          {
            path: "",
            element: <DashboardHomePage />, 
            loader: loader(queryClient, UserService.getUserByUsername())
          }
        ]
      }
    ]
  },
]);