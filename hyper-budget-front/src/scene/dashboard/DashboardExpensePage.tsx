import DashboardHeader from "@component/dashboard/DashboardHeader";
import { useContext } from "react";
import { UserContext } from "@service/context/UserContext";

export default function DashboardExpensePage() {
  const user = useContext(UserContext);

  return (
    <>
      <DashboardHeader username={user.username}>
        <>
          <p className="font-bold text-primary-faded">Dépenses totale du mois de Mai</p>
          <span>{user.totalExpensesAmount}</span>
        </>
      </DashboardHeader>
    </>
  )
}