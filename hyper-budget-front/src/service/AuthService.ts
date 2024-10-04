import IUserDto from "@model/dto/IUserDto";
import ApiUrls from "./ApiUrls";
import UserService from "./UserService";

export default class AuthService {

  private userService: UserService;

  constructor(userService: UserService) {
    this.userService = userService;
  }

  public async login(email: string, password: string): Promise<{userDto: IUserDto | null, tokenDto: string}> {
    let id: number = -1,
      token: string = "", 
      user: IUserDto = {} as IUserDto;

    const formData = {
      email: email,
      password: password
    };

    return fetch(ApiUrls.LOGIN, {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(formData),
    })
    .then(response => {
      if (!response.ok) {
        throw new Error("Erreur lors de la connexion : " + response.statusText);
      }
      return response.json();
    })
    .then(async data => {
      token = data.token;
      id = data.id;
      user = await this.userService.getApiUser(id, token);

      return {userDto: user, tokenDto: token};
    })
    .catch(error => {
      console.error(error);
      
      return {userDto: user, tokenDto: token};
    });

  }
}