import IExpenseDto from "./IExpenseDto";

export default interface IUserDto {
  id: number;
  role: string;
  email: string;
  username: string;
  password: string;
  createdAt: string;
  updatedAt: string;
  theme: string;
  periodType: string;
  isEditWarnEnabled: boolean;
  totalExpensesAmount: number;
  expenses: IExpenseDto[];
}