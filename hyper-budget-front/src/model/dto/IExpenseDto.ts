import { DefaultCategoryType } from "../type/DefaultCategoryType";

export default interface IExpenseDto {
  id: number;
  userId: number;
	name: string;
	amount: number;
	date: Date;
	category: DefaultCategoryType;
	createdAt: string;
	updatedAt: string;
}