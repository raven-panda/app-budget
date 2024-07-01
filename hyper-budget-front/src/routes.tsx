export interface AppRoute {
  path: string;
  element: React.ReactNode;
}

const appRoutes: AppRoute[] = [
  {
    path: "test",
    element: <div>a</div>
  }
]

export default appRoutes;