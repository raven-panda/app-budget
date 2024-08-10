export default class ApiUrls {
  public static readonly FIXTURE_ENABLED = process.env.REACT_APP_FIXTURE_ENABLED && JSON.parse(process.env.REACT_APP_FIXTURE_ENABLED);
  private static readonly BASE_URL = process.env.REACT_APP_API_URL + "/api";

  public static readonly USER = `${this.BASE_URL}/user/{id}`;
  public static readonly LOGIN = `${this.BASE_URL}/auth/login`;
}