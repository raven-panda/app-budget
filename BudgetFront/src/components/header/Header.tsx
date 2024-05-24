import { faCoins } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";
import Navigation from "./Navigation";

export function Header() {  
  return (
    <header className="bg-lime-light p-4 flex flex-row justify-between items-center fixed w-screen">
      <FontAwesomeIcon
        icon={faCoins}
        size="2x"
        className="text-lime-dark"
      />
      <Navigation></Navigation>
    </header>
  )
}