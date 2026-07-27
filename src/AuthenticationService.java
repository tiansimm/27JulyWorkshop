import java.util.ArrayList;

public class AuthenticationService implements IAuthenticationService {
    private ArrayList<User> users;

    // Initializes the users list with a default user
    public AuthenticationService() {
        users = new ArrayList<>();
        users.add(new User("admin", "password"));
    }

    @Override
    public User signUp(String username, String password) {
        // Check if username is already taken
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return null;
            }
        }
        // Username is free, create and add the new user
        User newUser = new User(username, password);
        users.add(newUser);
        return newUser;
    }

    @Override
    public User logIn(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}