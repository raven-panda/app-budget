import ApiUrls from "./ApiUrls";
import IUserDto from "@model/dto/IUserDto";
import Fixture from "./fixture/index";

export default class UserService {
  private user: IUserDto = ApiUrls.FIXTURE_ENABLED && process.env.REACT_APP_FIXTURE_USER_ID ?
    Fixture.getUserById(parseInt(process.env.REACT_APP_FIXTURE_USER_ID))
    : {} as IUserDto;

  private url: string = ApiUrls.USER;

  public getUser(): IUserDto {
    return this.user;
  }
}