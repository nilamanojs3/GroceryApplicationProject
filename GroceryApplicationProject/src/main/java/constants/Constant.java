package constants;

public class Constant {

	public static final String testDataFile = System.getProperty("user.dir") + "\\src\\test\\resources\\Testdata.xlsx";
	public static final String configFile = System.getProperty("user.dir")
			+ "\\src\\main\\resources\\config.properties";//to get path of application URL saved in config.properties file

	// Assertion error Message
	// Login Test
	public static final String validCredentialError = "User was able to login with valid credentials";
	public static final String invalidUsernameError = "User was unable to login with invalid Username";
	public static final String invalidPasswordError = "User was unable to login with invalid Password";
	public static final String invalidCredentialError = "User was unable to login with invalid credentials";

	// Home Test
	public static final String unsuccessfulLogoutError = "User was unable to login";

	// AdminUser Test
	public static final String newUserEntryError = "New user entry has failed";
	public static final String searchEntryError = "User search on Admin page failed";
	public static final String resetError = "Reset functionality on Admin Page failed";

	// Manage News Test
	public static final String newsEntryError = "News entry failed";
	public static final String newsSearchError = "User search on Manage News page failed";
	public static final String newsResetError = "Reset functionality on Manage News Page failed";
}
