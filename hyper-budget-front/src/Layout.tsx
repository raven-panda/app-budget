import { Outlet } from "react-router-dom";

export default function AppLayout() {
  return (
    <>
      <div>
        Layout
      </div>
      <Outlet />
    </>
  )
}