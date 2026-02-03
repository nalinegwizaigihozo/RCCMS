package rccms.server.service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import rccms.server.dao.InspectionStandardDAO;
import rccms.common.domain.InspectionStandard;
import rccms.common.service.InspectionStandardService;

/**
 *
 * @author IT MODERN LTD
 */
public class InspectionStandardServiceImpl extends UnicastRemoteObject implements InspectionStandardService {

    private final InspectionStandardDAO standardDAO;

    public InspectionStandardServiceImpl() throws RemoteException {
        super();
        this.standardDAO = new InspectionStandardDAO();
    }

    @Override
    public boolean create(InspectionStandard standard) throws RemoteException {
        return standardDAO.create(standard);
    }

    @Override
    public boolean update(InspectionStandard standard) throws RemoteException {
        return standardDAO.update(standard);
    }

    @Override
    public boolean delete(int standardId) throws RemoteException {
        return standardDAO.delete(standardId);
    }

    @Override
    public InspectionStandard findById(int standardId) throws RemoteException {
        return standardDAO.findById(standardId);
    }

    @Override
    public List<InspectionStandard> findAll() throws RemoteException {
        return standardDAO.findAll();
    }

    @Override
    public List<InspectionStandard> findByCategory(String category) throws RemoteException {
        return standardDAO.findByCategory(category);
    }

    @Override
    public boolean existsByCode(String code) throws RemoteException {
        return standardDAO.existsByCode(code);
    }
}
