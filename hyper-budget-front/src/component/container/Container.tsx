import { twMerge } from "tailwind-merge";

export default function Container({children, background}: {children: JSX.Element | JSX.Element[], background?: string}) {
  return (
    <div className={"p-24px " + twMerge(!!background && "bg-" + background)}>
      {children}
    </div>
  );
}