package rccms.server.service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.List;
import rccms.server.dao.ChurchDAO;
import rccms.common.domain.Church;
import rccms.common.service.ChurchService;

/**
 *
 * @author IT MODERN LTD
 */
public class ChurchServiceImpl extends UnicastRemoteObject implements ChurchService {

    private final ChurchDAO churchDAO;

    public ChurchServiceImpl() throws RemoteException {
        super();
        this.churchDAO = new ChurchDAO();
    }

    @Override
    public boolean create(Church church) throws RemoteException {
        return churchDAO.create(church);
    }

    @Override
    public boolean update(Church church) throws RemoteException {
        return churchDAO.update(church);
    }

    @Override
    public boolean delete(int churchId) throws RemoteException {
        return churchDAO.delete(churchId);
    }

    @Override
    public Church findById(int churchId) throws RemoteException {
        return churchDAO.findById(churchId);
    }

    @Override
    public List<Church> findAll() throws RemoteException {
        return churchDAO.findAll();
    }

    @Override
    public List<Church> findByDistrict(String district) throws RemoteException {
        return churchDAO.findByDistrict(district);
    }

    @Override
    public boolean existsByRegistrationNumber(String regNumber) throws RemoteException {
        return churchDAO.existsByRegistrationNumber(regNumber);
    }

    @Override
    public boolean updateComplianceStatus(int churchId, String status) throws RemoteException {
        return churchDAO.updateComplianceStatus(churchId, status);
    }

    @Override
    public boolean updateLastInspectionDate(int churchId, Date date) throws RemoteException {
        return churchDAO.updateLastInspectionDate(churchId, date);
    }
}
