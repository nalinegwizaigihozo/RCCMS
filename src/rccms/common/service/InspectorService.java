package rccms.common.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import rccms.common.domain.Inspector;
import rccms.common.exception.DatabaseException;

/**
 *
 * @author IT MODERN LTD
 */
public interface InspectorService extends Remote {
    boolean create(Inspector inspector) throws RemoteException, DatabaseException;
    boolean update(Inspector inspector) throws RemoteException, DatabaseException;
    boolean delete(int inspectorId) throws RemoteException, DatabaseException;
    Inspector findById(int inspectorId) throws RemoteException, DatabaseException;
    List<Inspector> findAll() throws RemoteException, DatabaseException;
    boolean existsByIdNumber(String idNumber) throws RemoteException, DatabaseException;
    boolean existsByEmail(String email) throws RemoteException, DatabaseException;
    Inspector findByUserId(int userId) throws RemoteException, DatabaseException;
}
