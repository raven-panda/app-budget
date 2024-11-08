import { AxiosResponse } from "axios";

export interface IQuery {
  queryKey: string;
  queryFn: () => Promise<AxiosResponse>;
}