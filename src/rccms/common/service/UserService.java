package rccms.common.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import rccms.common.domain.User;
import rccms.common.exception.DatabaseException;

/**
 *
 * @author IT MODERN LTD
 */
public interface UserService extends Remote {
    User authenticate(String username, String password) throws RemoteException, DatabaseException;
    boolean createUser(User user) throws RemoteException, DatabaseException;
    User findByUsername(String username) throws RemoteException, DatabaseException;
    boolean delete(int userId) throws RemoteException, DatabaseException;
}
