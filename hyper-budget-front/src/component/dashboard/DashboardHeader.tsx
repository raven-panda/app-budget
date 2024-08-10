import Container from '@component/container/Container';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome'
import { faBell, faUser } from '@fortawesome/free-solid-svg-icons'

interface DashboardHeaderProps {
  username: string;
  children?: React.ReactNode;
}
export default function DashboardHeader({ children, username }: DashboardHeaderProps) {
  const notifications = 0;

  return (
    <header>
      <Container background="bg-secondary">
        <div className="flex items-center">
          <div className="flex p-10px rounded-full bg-primary">
            <FontAwesomeIcon icon={faUser} className="px-[2px] text-3xl" color="white"/>
          </div>
          <div className="ml-10px">
            <h1 className="text-base font-regular">Bonjour, {username} !</h1>
              <p className="hidden xs:block text-xs">
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
        </div>
        <div className="mt-10px">
          {children}
        </div>
      </Container>
    </header>
  );
}