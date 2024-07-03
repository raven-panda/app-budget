import ApiUrls from "./ApiUrls";
import IUserDto from "./model/IUserDto";
import Fixture from "@fixture/index";

export default class UserService {
  private static user: IUserDto = ApiUrls.fixtureEnabled && process.env.FIXTURE_USER_ID ?
    Fixture.getUserById(parseInt(process.env.FIXTURE_USER_ID))
    : {} as IUserDto;

  private static url: string = ApiUrls.USER;

  public static getUser(): IUserDto {
    return this.user;
  }
}