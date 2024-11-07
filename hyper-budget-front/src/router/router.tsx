import ErrorPage from "@scene/error/ErrorPage";
import WelcomePage from "@scene/WelcomePage";
import { createBrowserRouter, Outlet } from "react-router-dom";
import { queryClient } from "@/api/Request";
import WelcomeService from "@/api/services/WelcomeService/service";

export const clientRoutes = {
  root: "/"
}

export const router = createBrowserRouter([
  {
    path: clientRoutes.root,
    element: <Outlet/>,
    errorElement: <ErrorPage />,
    children: [
      {
        path: "",
        element: <WelcomePage />,
        loader: WelcomeService.loader(queryClient)
      }
    ]
  },
]);