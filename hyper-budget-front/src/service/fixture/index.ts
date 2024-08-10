import IUserDto from "src/model/dto/IUserDto";
import User1 from "./user1.json";
import UserDao from "@service/dao/UserDao";

export default class Fixture {
  public static getUserById(id: number): IUserDto {
    switch (id) {
      case 1:
        return UserDao.adaptUser(User1);
      default:
        return UserDao.adaptUser(User1);
    }
  }
}