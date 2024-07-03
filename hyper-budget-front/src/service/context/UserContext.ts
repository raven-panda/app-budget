import React from "react";
import IUserDto from "src/model/dto/IUserDto";

export const UserContext = React.createContext<IUserDto>({} as IUserDto);