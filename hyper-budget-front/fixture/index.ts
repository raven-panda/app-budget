import IUserDto from "@service/model/IUserDto";
import User1 from "./user1.json";

export default class Fixture {
  public static getUserById(id: number): IUserDto {
    switch (id) {
      case 1:
        return User1;
      default:
        return User1;
    }
  }
}