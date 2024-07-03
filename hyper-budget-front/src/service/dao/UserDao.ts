import IExpenseDto from "src/model/dto/IExpenseDto";
import IUserDto from "src/model/dto/IUserDto";
import { DefaultCategoryType } from "src/model/type/DefaultCategoryType";

export default class UserDao {
  public static adaptUser(user: any): IUserDto {
    return {
      ...user,
      expenses: user.expenses.map((expense: any) => this.adaptExpense(expense))
    };
  }

  public static adaptExpense(expense: any): IExpenseDto {
    return {
      ...expense,
      category: this.adaptCategory(expense.category),
      date: new Date(expense.date)
    };
  }

  public static adaptCategory(category: string): DefaultCategoryType {
    const validCategories: DefaultCategoryType[] = [
      "INSURANCE", "TRANSPORT", "LEISURE", "FOOD", "DIGITAL",
      "HOUSING", "HEALTH", "TAXES", "ANIMALS", "CHILDREN", "OTHER"
    ];

    if (validCategories.includes(category as DefaultCategoryType)) {
      return category as DefaultCategoryType;
    } else {
      throw new Error(`Invalid category: ${category}`);
    }
  }
}