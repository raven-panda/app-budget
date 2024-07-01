import { ErrorResponse, isRouteErrorResponse, useRouteError } from "react-router-dom";

export default function ErrorPage({data}: {data?: "NOT_FOUND"|"NOT_ALLOWED"}) {
  const unknownError = useRouteError();
  let error: ErrorResponse|null = null;
  const errorMessage: string =
    data === "NOT_FOUND" ? "Page non trouvée" :
    data === "NOT_ALLOWED" ? "Vous n'êtes pas autorisé à accéder à cette page"
    : "Il semblerait qu'il y ait un problème avec cette page...";

  if (isRouteErrorResponse(unknownError)) {
    error = unknownError;
  }

  return (
    <div className="flex flex-col justify-center items-center min-h-screen">
      <h1 className="text-4xl font-bold">Oups !</h1>
      <p>{errorMessage}</p>
      
      {/**
       * @TODO Show error details only in development
       */}
      <p><i>{(error?.status || "") + " " + (error?.statusText || "")}</i></p>
      <p><i>{error?.data}</i></p>
    </div>
  );
  
  
  
}