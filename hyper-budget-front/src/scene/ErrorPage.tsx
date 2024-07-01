import { useState } from "react";
import { ErrorResponse, isRouteErrorResponse, useRouteError } from "react-router-dom";
import NotFoundError from "../component/error/NotFoundError";

export default function ErrorPage() {
  const unknownError = useRouteError();
  let error: ErrorResponse|null = null;

  if (isRouteErrorResponse(unknownError)) {
    error = unknownError;
  }

  return (
    <div className="flex flex-col justify-center items-center min-h-screen">
      {error?.status === 404 ? 
        <NotFoundError />
        :
      <>
        <h1 className="text-4xl font-bold">Oups !</h1>
        <p>Il semblerait qu'il y ait un problème avec cette page...</p>
        <p><i>{error?.status + " " + error?.statusText}</i></p>
        <p><i>{error?.data}</i></p>
      </>}
    </div>
  );
  
  
  
}