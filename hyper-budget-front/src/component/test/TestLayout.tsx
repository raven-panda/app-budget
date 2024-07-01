import { Outlet } from "react-router-dom";

export default function TestLayout() {
  return (
    <div className="min-h-screen">
      <div className="bg-gray">Test</div>
      <div className="h-full">
        <Outlet />
      </div>
      <div className="bg-gray">mdr</div>
    </div>
  )
}