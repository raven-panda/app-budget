import { PeriodTypeEnum } from "../enum/PeriodTypeEnum";
import { PreferredThemeEnum } from "../enum/PreferredThemeEnum";
import IExpenseDto from "./IExpenseDto";

export default interface IUserDto {
  id: number;
  role: string;
  email: string;
  username: string;
  password: string;
  createdAt: Date;
  updatedAt: Date;
  theme: PreferredThemeEnum;
  periodType: PeriodTypeEnum;
  isEditWarnEnabled: boolean;
  totalExpensesAmount: number;
  notifications: any[];
  expenses: IExpenseDto[];
}