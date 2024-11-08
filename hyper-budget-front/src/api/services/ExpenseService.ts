import { apiClient } from "@/api/Request";
import { IQuery } from "@/model/type/IQuery";

const ExpensesService = {
  getExpensesData: (): IQuery => ({
    queryKey: "expenses",
    queryFn: async () => await apiClient.get("/expenses-data.json")
  })
}

export default ExpensesService;
