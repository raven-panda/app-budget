import { useLoaderData } from "react-router-dom"
import IUserDto from "@/model/dto/IUserDto";
import DashboardHeader from "@/component/dashboard/DashboardHeader";

export default function DashboardHomePage() {
  const { data } = useLoaderData() as { data: IUserDto } || { data: null };

  return (
    <>
      <DashboardHeader username={data.username} notifications={data.notifications}></DashboardHeader>
      <main></main>
    </>
  )
}