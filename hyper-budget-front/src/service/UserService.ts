import ApiUrls from "./ApiUrls";
import IUserDto from "@model/dto/IUserDto";
import Fixture from "./fixture/index";

export default class UserService {
  constructor() {}
  private user: IUserDto = {} as IUserDto;

  private url: string = ApiUrls.USER;

  public getUser(id: number): IUserDto {
    fetch(this.url.replace('{id}', id.toString()), {
      method: 'GET',
      headers: {
        "Content-Type": "application/json",
      }
    })
      .then(response => {
        if (!response.ok || response.status !== 200) {
          throw new Error(`Network response was not ok : ${response.status}`);
        }

        return response.json();
      })
      .then(data => {
        this.user = data;
        console.log(this.user);
      })
      .catch(error => console.error(error))
    return this.user;
  }
}