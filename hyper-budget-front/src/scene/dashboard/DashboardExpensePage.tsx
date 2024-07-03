import DashboardHeader from "@component/dashboard/DashboardHeader";
import UserService from "@service/UserService";

export default function DashboardExpensePage() {
  const user = UserService.getUser();

  return (
    <>
      <DashboardHeader username={user.username} />
    </>
  )
}