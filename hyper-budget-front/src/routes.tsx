import { Navigate, Outlet, createBrowserRouter } from "react-router-dom";
import ErrorPage from "./scene/ErrorPage";

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
    path: "/test",
    element: <>
      <div>Test</div>
      <Outlet />
    </>,
    children: [
      {
        path: "",
        element: <Navigate to="/not-allowed" replace />,
      },
      {
        path: "aaaa",
        element: <div>aaaa</div>
      }
    ]
  }
]);

export default router;