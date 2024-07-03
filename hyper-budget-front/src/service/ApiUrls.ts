export default class ApiUrls {
  public static readonly FIXTURE_ENABLED = process.env.REACT_APP_FIXTURE_ENABLED && JSON.parse(process.env.REACT_APP_FIXTURE_ENABLED);
  private static readonly BASE_URL = process.env.API_URL;

  public static readonly USER = `${this.BASE_URL}/user`;
}