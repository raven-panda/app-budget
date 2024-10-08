import { twMerge } from "tailwind-merge";

export default function Container({children, background}: {children: JSX.Element | JSX.Element[], background?: string}) {
  return (
    <div className={twMerge("p-16px", background)}>
      {children}
    </div>
  );
}