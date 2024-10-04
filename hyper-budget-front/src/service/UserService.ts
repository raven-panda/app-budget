import { toast } from "react-toastify";
import ApiUrls from "./ApiUrls";
import IUserDto from "@model/dto/IUserDto";

export default class UserService {

  private user: IUserDto = {} as IUserDto;

  public async getApiUser(id: number, token: string): Promise<IUserDto> {
    return fetch(ApiUrls.USER.replace("{id}", id.toString()), {
      method: "GET",
      headers: {
        "Authorization": "Bearer " + token,
      }
    })
    .then(response => {
      if (!response.ok) {
        throw new Error("Erreur lors de la récupération de l'utilisateur : " + response.statusText);
      }
      return response.json();
    })
    .then(data => {
      this.user = data;
      return data;
    })
    .catch(error => {
      console.error(error);
      toast.error("Erreur lors de la récupération de l'utilisateur");
      return null;
    })
  }
}