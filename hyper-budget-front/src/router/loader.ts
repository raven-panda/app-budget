import { IQuery } from "@/model/type/IQuery";
import { QueryClient } from "react-query";

export const loader = (queryClient: QueryClient, query: IQuery) => async () => {
  return (
    queryClient.getQueryData(query.queryKey) ??
    (await queryClient.fetchQuery(query))
  );
};