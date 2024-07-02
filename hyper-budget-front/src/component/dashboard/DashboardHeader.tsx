import Container from "../container/Container";
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faBell, faUser } from '@fortawesome/free-solid-svg-icons'

export default function DashboardHeader() {
  const username = "John Doe";
  const notifications = 688;

  return (
    <header>
      <Container background="flex items-center bg-secondary">
        <div className="flex p-10px rounded-full bg-primary">
          <FontAwesomeIcon icon={faUser} className="px-[2px] text-3xl" color="white"/>
        </div>
        <div className="ml-10px">
          <h1 className="text-lg font-bold">Bonjour, {username} !</h1>
          <p className="text-xs">
            <span className="text-primary-faded">
              { notifications > 0 ? 
                <>
                  Vous avez <span className="text-red-600">{notifications}</span> notification{notifications > 1 ? "s": ""} en attente
                </> : "Vous n’avez aucune nouvelle notification"
              }
            </span>
          </p>
        </div>
        <div className="flex ml-auto p-10px rounded-full">
          <FontAwesomeIcon icon={faBell} className="px-[2px] text-3xl" color="black"/>
        </div>
      </Container>
    </header>
  );
}