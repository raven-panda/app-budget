import { Navigate, Outlet, createBrowserRouter } from "react-router-dom";
import ErrorPage from "@scene/error/ErrorPage";
import { ResponseErrorEnum } from "@model/enum/ResponseErrorEnum";
import DashboardExpensePage from "@scene/dashboard/DashboardExpensePage";
import DashboardHomePage from "@scene/dashboard/DashboardHomePage";
import WelcomePage from "@scene/WelcomePage";


const router = createBrowserRouter([
  {
    path: "/",
    element: <div>Hello world!</div>,
    errorElement: <ErrorPage />
  },
  {
    path: "/not-allowed",
    element: <ErrorPage data={ResponseErrorEnum.NOT_ALLOWED} />
  },
  {
    path: "/welcome",
    element: <WelcomePage />,
  },
  {
    path: "/dashboard",
    element: <Outlet />,
    children: [
      {
        path: "",
        element: <Navigate to="home" replace />,
      },
      {
        path: "home",
        element: <DashboardHomePage />
      },
      {
        path: "expense",
        element: <DashboardExpensePage />
      }
    ]
  }
]);

export default router;