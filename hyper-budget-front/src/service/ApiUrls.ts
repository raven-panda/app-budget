export default class ApiUrls {
  public static readonly fixtureEnabled = false;
  private static readonly BASE_URL = process.env.API_URL;

  public static readonly USER = `${this.BASE_URL}/user`;
}