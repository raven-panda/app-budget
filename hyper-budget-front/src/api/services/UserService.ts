import { apiClient } from "@/api/Request";
import { IQuery } from "@/model/type/IQuery";

const UserService = {
  getUserByUsername: (): IQuery => ({
    queryKey: "user-by-username",
    queryFn: async () => await apiClient.get("/user-by-username-data.json")
  })
}

export default UserService;
