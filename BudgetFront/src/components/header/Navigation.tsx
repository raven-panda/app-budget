import { faBars } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

export default function Navigation() {
  return (
    <nav>
      <FontAwesomeIcon
        icon={faBars}
        size="2x"
        className="text-lime-dark"
      />
    </nav>
  )
}