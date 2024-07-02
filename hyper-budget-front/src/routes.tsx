import { Navigate, Outlet, createBrowserRouter } from "react-router-dom";
import ErrorPage from "./scene/error/ErrorPage";
import { ResponseErrorEnum } from "./component/enum/ResponseErrorEnum";
import DashboardExpensePage from "./scene/dashboard/DashboardExpensePage";
import DashboardHomePage from "./scene/dashboard/DashboardHomePage";


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