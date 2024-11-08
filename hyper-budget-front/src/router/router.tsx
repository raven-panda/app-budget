import { queryClient } from "@/api/Request";
import DashboardHomePage from "@/scene/dashboard/DashboardHomePage";
import ErrorPage from "@scene/error/ErrorPage";
import WelcomePage from "@scene/WelcomePage";
import { createBrowserRouter, Outlet } from "react-router-dom";
import { loader } from "./loader";
import ExpensesService from "@/api/services/ExpenseService";

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
            loader: loader(queryClient, ExpensesService.getExpensesData())
          }
        ]
      }
    ]
  },
]);