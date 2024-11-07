import { QueryClient } from "react-query";
import { apiClient } from "@/api/Request";

const getWelcomeDetails = () => ({
  queryKey: "welcome-get",
  queryFn: async () => await apiClient.get("/data.json")
})

const WelcomeService = {
  loader: (queryClient: QueryClient) => async () => {
    const query = getWelcomeDetails();
    return (
      queryClient.getQueryData(query.queryKey) ??
      (await queryClient.fetchQuery(query))
    );
  }
}

export default WelcomeService;