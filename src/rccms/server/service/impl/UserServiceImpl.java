package rccms.server.service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import rccms.server.dao.UserDAO;
import rccms.common.domain.User;
import rccms.common.exception.DatabaseException;
import rccms.common.service.UserService;

/**
 *
 * @author IT MODERN LTD
 */
public class UserServiceImpl extends UnicastRemoteObject implements UserService {
    
    private final UserDAO userDAO;

    public UserServiceImpl() throws RemoteException {
        super();
        this.userDAO = new UserDAO();
    }

    @Override
    public User authenticate(String username, String password) throws RemoteException, DatabaseException {
        return userDAO.authenticate(username, password);
    }

    @Override
    public boolean createUser(User user) throws RemoteException, DatabaseException {
        return userDAO.createUser(user);
    }

    @Override
    public User findByUsername(String username) throws RemoteException, DatabaseException {
        return userDAO.findByUsername(username);
    }

    @Override
    public boolean delete(int userId) throws RemoteException, DatabaseException {
        return userDAO.delete(userId);
    }
}
