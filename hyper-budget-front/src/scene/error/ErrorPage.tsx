import { ErrorResponse, isRouteErrorResponse, useRouteError } from "react-router-dom";
import { ResponseErrorEnum } from "@model/enum/ResponseErrorEnum";

export default function ErrorPage({data}: {data?: ResponseErrorEnum}) {
  const unknownError = useRouteError();
  const error: ErrorResponse|null = isRouteErrorResponse(unknownError) ? unknownError : null;
  const errorMessage: string = data ? data : error?.status === 404 ? ResponseErrorEnum.NOT_FOUND : ResponseErrorEnum.DEFAULT;

  return (
    <div className="flex flex-col justify-center items-center min-h-screen">
      <h1 className="text-4xl font-bold">Oups !</h1>
      <p>{errorMessage}</p>
      
      {/**
       * @TODO Show error details only in development
       */}
      <p><i>{[error?.status, error?.statusText, null].map(e => e).join(" ")}</i></p>
      <p><i>{error?.data}</i></p>
    </div>
  );
}