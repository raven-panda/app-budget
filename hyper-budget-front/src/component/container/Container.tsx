export default function Container({children}: {children: JSX.Element | JSX.Element[]}) {
  return (
    <div className="p-24px">
      {children}
    </div>
  );
}