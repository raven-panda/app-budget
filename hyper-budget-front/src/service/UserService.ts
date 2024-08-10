import ApiUrls from "./ApiUrls";
import IUserDto from "@model/dto/IUserDto";

export default class UserService {
  constructor() {}
  private user: IUserDto = {} as IUserDto;

  private url: string = ApiUrls.USER;

  public getUser(): IUserDto {
    return this.user;
  }

  public setUser(user: IUserDto): void {
    this.user = user;
  }
}