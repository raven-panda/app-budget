import AuthService from "@service/AuthService";
import UserService from "@service/UserService";
import React, { ReactNode, useEffect, useState } from "react";
import { useCookies } from "react-cookie";
import IUserDto from "src/model/dto/IUserDto";

const authService = new AuthService(new UserService());

const UserContext = React.createContext<[IUserDto, (email: string, password: string) => Promise<void>]>([{} as IUserDto, async () => {}]);
const TokenContext = React.createContext<[string]>([""]);

export const AuthContext = ({children}: {children: ReactNode}) => {
  const [user, setUserState] = useState({} as IUserDto);
  const [token, setTokenState] = useState("");
  const [cookies, setCookie, removeCookie] = useCookies();

  async function setUser(email: string, password: string): Promise<void> {
    const {userDto, tokenDto} = await authService.login(email, password);
    if (userDto && tokenDto) {
      if (cookies?.token) removeCookie("token");
      setUserState(userDto);
      setTokenState(tokenDto);
      setCookie("token", tokenDto, { path: "/", sameSite: "strict" });
    }
  }

  return (
    <UserContext.Provider value={[user, setUser]}>
      <TokenContext.Provider value={[token]}>
        {children}
      </TokenContext.Provider>
    </UserContext.Provider>
  )
}

export const useAuthUser = () => {
  return React.useContext(UserContext);
}

export const useAuthToken = () => {
  return React.useContext(TokenContext);
}