package customizedException;
class InvalidUserNameException extends RuntimeException{
	public InvalidUserNameException(String message) {
		super(message);
	}
}
class InvalidPasswordException extends RuntimeException{
	public InvalidPasswordException(String message) {
		super(message);
	}
}
class LoginDetails {
    private String username;
    private String password;

    public LoginDetails(String username, String password)throws RuntimeException{
        this.setUsername(username);
        this.setPassword(password);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) throws InvalidUserNameException {
    	if(username.isEmpty()||username.equals(null)) {
    		throw new InvalidUserNameException("Username cannot be empty");
    	}
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password)throws InvalidPasswordException  {
    	if(password.isEmpty()||password.equals(null)) {
    		throw new InvalidPasswordException("Password cannot be empty");
    	}
        this.password = password;
    }

    @Override
    public String toString() {
        return "CustomizedDemo1{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
public class CustomizedDemo1{
	public static void main(String[] args) {
		try {
            LoginDetails login = new LoginDetails("user123", "pass123");
            System.out.println(login);

            login.setUsername("newUser");
            login.setPassword("newPass");
            System.out.println(login);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            LoginDetails invalidLogin = new LoginDetails("", "password");
        } catch (InvalidUserNameException | InvalidPasswordException e) {
            System.out.println(e.getMessage());
        }

        try {
            LoginDetails invalidLogin = new LoginDetails("username", "");
        } catch (InvalidUserNameException | InvalidPasswordException e) {
            System.out.println(e.getMessage());
        }
	}
}
