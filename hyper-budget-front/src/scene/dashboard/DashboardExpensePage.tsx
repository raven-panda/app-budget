import DashboardHeader from "@component/dashboard/DashboardHeader";
import { useContext } from "react";
import { UserContext } from "@service/context/UserContext";
import { Link } from "react-router-dom";
import IExpenseDto from "@model/dto/IExpenseDto";
import DateUtils from "@service/utils/DateUtils";
import ExpenseService from "@service/ExpenseService";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

interface IExpenseByDate {
  date: Date;
  expenses: IExpenseDto[];
};
export default function DashboardExpensePage() {
  const user = useContext(UserContext)[0];

  /**
   * Group and sort expenses groups by date
   */ 
  const categorizeExpensesByDate = (): IExpenseByDate[] => {
    const expensesByDate: IExpenseByDate[] = [];

    user?.expenses?.forEach((expense) => {
      if (expensesByDate.some((item) => item.date.getTime() === expense.date.getTime()))
        expensesByDate.find((item) => item.date.getTime() === expense.date.getTime())?.expenses.push(expense);
      else
        expensesByDate.push({date: expense.date, expenses: [expense]});
    })

    expensesByDate.sort((a, b) => b.date.getTime() - a.date.getTime());

    return expensesByDate;
  }

  return (
    <>
      <DashboardHeader username={user.username}>
        <p className="font-bold text-primary-faded">Dépenses totale du mois de Mai</p>
        <span className="font-bold text-3xl">{user.totalExpensesAmount} €</span>
      </DashboardHeader>
      <section className="p-16px flex flex-col">
        {categorizeExpensesByDate().map(item => (
          <article key={item.date.getTime()} className="mb-20px">
            <p className="text-primary-faded">{item.date.getDay()} {DateUtils.getMonthName(item.date.getMonth())}</p>
            <section className="px-10px py-[5px] rounded-10px border-primary-faded border-1">
              {item.expenses.map(expense => (
                <article key={expense.name} className="flex items-center">
                  <FontAwesomeIcon
                    icon={ExpenseService.getIconFromCategory(expense.category)}
                    className="text-primary-faded text-2xl"
                    style={{color: ExpenseService.getIconColorFromCategory(expense.category)}}
                  />
                  <div className="ml-10px">
                    <p>{expense.name}</p>
                    <p className="text-primary-faded font-light">{expense.date.getDay()}/{expense.date.getMonth()}</p>
                  </div>
                  <span className="ml-auto">-{expense.amount} €</span>
                </article>
              ))}
            </section>
          </article>
        ))}
        <Link to={"#"} className="underline text-blue-800">Afficher plus de dépenses</Link>
      </section>
    </>
  );
}