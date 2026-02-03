package rccms.common.service;

import java.rmi.RemoteException;
import rccms.common.domain.User;
import rccms.common.exception.DatabaseException;
import rccms.common.exception.ValidationException;
import rccms.client.util.RMIClientUtil;
import rccms.client.util.ValidationUtil;

/**
 *
 * @author IT MODERN LTD
 */
public class AuthService {
    
    private static User currentUser;

    public AuthService() {
    }

    public User login(String username, String password) throws DatabaseException {
        if (username == null || username.trim().isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty");
        }
        if (password == null || password.trim().isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }

        try {
            UserService userService = RMIClientUtil.getUserService();
            if (userService == null) {
                throw new DatabaseException("Could not connect to server");
            }
            User user = userService.authenticate(username.trim(), password);
            if (user != null) {
                currentUser = user;
            }
            return user;
        } catch (RemoteException e) {
            throw new DatabaseException("Server communication error: " + e.getMessage(), e);
        }
    }

    public void register(String username, String password, String confirmPassword, String role)
            throws ValidationException, DatabaseException {
        if (!ValidationUtil.isNotEmpty(username)) {
            throw new ValidationException("Username is required");
        }
        if (!ValidationUtil.isValidLength(username, 3, 50)) {
            throw new ValidationException("Username must be between 3 and 50 characters");
        }

        if (!ValidationUtil.isNotEmpty(password)) {
            throw new ValidationException("Password is required");
        }
        if (!ValidationUtil.isValidLength(password, 6, 100)) {
            throw new ValidationException("Password must be between 6 and 100 characters");
        }

        if (!password.equals(confirmPassword)) {
            throw new ValidationException("Passwords do not match");
        }

        if (!ValidationUtil.isNotEmpty(role)) {
            throw new ValidationException("Role is required");
        }
        if (!role.equals("ADMIN") && !role.equals("INSPECTOR")) {
            throw new ValidationException("Role must be either ADMIN or INSPECTOR");
        }

        try {
            UserService userService = RMIClientUtil.getUserService();
            if (userService == null) {
                throw new DatabaseException("Could not connect to server");
            }

            User existingUser = userService.findByUsername(username.trim());
            if (existingUser != null) {
                throw new ValidationException("Username already exists. Please choose a different username.");
            }

            User newUser = new User(username.trim(), password, role);
            newUser.setActive(true);

            boolean created = userService.createUser(newUser);
            if (!created) {
                throw new DatabaseException("Failed to create user account");
            }
        } catch (RemoteException e) {
            throw new DatabaseException("Server communication error: " + e.getMessage(), e);
        }
    }

    public void logout() {
        currentUser = null;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public boolean isLoggedIn() {
        return currentUser != null;
    }

    public boolean isAdmin() {
        return currentUser != null && "ADMIN".equals(currentUser.getRole());
    }
}
