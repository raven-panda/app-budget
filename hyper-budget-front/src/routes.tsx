import { createBrowserRouter } from "react-router-dom";
import ErrorPage from "./scene/ErrorPage";

const router = createBrowserRouter([
  {
    path: "/",
    element: <div>Hello world!</div>,
    errorElement: <ErrorPage />
  },
  {
    path: "/test",
    element: <div>Test</div>,
    children: [
      {
        path: "aaaa",
        element: <div>aaaa</div>
      }
    ]
  }
]);

export default router;