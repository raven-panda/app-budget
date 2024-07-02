import { ErrorResponse, isRouteErrorResponse, useRouteError } from "react-router-dom";
import { ResponseErrorEnum } from "../../component/enum/ResponseErrorEnum";

export default function ErrorPage({data}: {data?: ResponseErrorEnum}) {
  const unknownError = useRouteError();
  let error: ErrorResponse|null = null;
  let errorMessage: string = data ? data : ResponseErrorEnum.DEFAULT;
  console.log({ data, errorMessage });

  if (isRouteErrorResponse(unknownError)) {
    error = unknownError;
    if (error.status === 404) errorMessage = ResponseErrorEnum.NOT_FOUND;
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