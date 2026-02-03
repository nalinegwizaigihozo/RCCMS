package rccms.server.service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import rccms.server.dao.InspectorDAO;
import rccms.common.domain.Inspector;
import rccms.common.exception.DatabaseException;
import rccms.common.service.InspectorService;

/**
 *
 * @author IT MODERN LTD
 */
public class InspectorServiceImpl extends UnicastRemoteObject implements InspectorService {

    private final InspectorDAO inspectorDAO;

    public InspectorServiceImpl() throws RemoteException {
        super();
        this.inspectorDAO = new InspectorDAO();
    }

    @Override
    public boolean create(Inspector inspector) throws RemoteException, DatabaseException {
        return inspectorDAO.create(inspector);
    }

    @Override
    public boolean update(Inspector inspector) throws RemoteException, DatabaseException {
        return inspectorDAO.update(inspector);
    }

    @Override
    public boolean delete(int inspectorId) throws RemoteException, DatabaseException {
        return inspectorDAO.delete(inspectorId);
    }

    @Override
    public Inspector findById(int inspectorId) throws RemoteException, DatabaseException {
        return inspectorDAO.findById(inspectorId);
    }

    @Override
    public List<Inspector> findAll() throws RemoteException, DatabaseException {
        return inspectorDAO.findAll();
    }

    @Override
    public boolean existsByIdNumber(String idNumber) throws RemoteException, DatabaseException {
        return inspectorDAO.existsByIdNumber(idNumber);
    }

    @Override
    public boolean existsByEmail(String email) throws RemoteException, DatabaseException {
        return inspectorDAO.existsByEmail(email);
    }

    @Override
    public Inspector findByUserId(int userId) throws RemoteException, DatabaseException {
        return inspectorDAO.findByUserId(userId);
    }
}
