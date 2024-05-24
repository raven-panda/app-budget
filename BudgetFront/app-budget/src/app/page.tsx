import Image from "next/image";

export default function App() {
  return (
    <>
      <Image 
        src="/images/site-logo.svg"
        alt="site logo"
        width={236}
        height={0}
      />
      <h1>L&apos;application pour gérer votre budget !</h1>
    </>
  );
}
