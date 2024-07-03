import { twMerge } from "tailwind-merge";

export default function Container({children, background}: {children: JSX.Element | JSX.Element[], background?: string}) {
  return (
    <div className={twMerge("p-10px", background)}>
      {children}
    </div>
  );
}