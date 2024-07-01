import { Navigate, Outlet, createBrowserRouter } from "react-router-dom";
import ErrorPage from "./scene/error/ErrorPage";

const router = createBrowserRouter([
  {
    path: "/",
    element: <div>Hello world!</div>,
    errorElement: <ErrorPage />
  },
  {
    path: "/not-allowed",
    element: <ErrorPage data="NOT_ALLOWED" />
  },
  {
    path: "/dashboard",
    element: <Outlet />,
    children: [
      {
        path: "",
        element: <Navigate to="/not-allowed" replace />,
      },
      {
        path: "expense",
        element: <div>aaaa</div>
      }
    ]
  }
]);

export default router;