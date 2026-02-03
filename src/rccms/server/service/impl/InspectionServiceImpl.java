package rccms.server.service.impl;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import rccms.server.dao.InspectionDAO;
import rccms.server.dao.InspectionDetailDAO;
import rccms.common.domain.Inspection;
import rccms.common.domain.InspectionDetail;
import rccms.common.service.InspectionService;

/**
 *
 * @author IT MODERN LTD
 */
public class InspectionServiceImpl extends UnicastRemoteObject implements InspectionService {

    private final InspectionDAO inspectionDAO;
    private final InspectionDetailDAO inspectionDetailDAO;

    public InspectionServiceImpl() throws RemoteException {
        super();
        this.inspectionDAO = new InspectionDAO();
        this.inspectionDetailDAO = new InspectionDetailDAO();
    }

    @Override
    public boolean create(Inspection inspection) throws RemoteException {
        return inspectionDAO.create(inspection);
    }

    @Override
    public int createAndGetId(Inspection inspection) throws RemoteException {
        return inspectionDAO.createAndGetId(inspection);
    }

    @Override
    public Inspection findById(int inspectionId) throws RemoteException {
        return inspectionDAO.findById(inspectionId);
    }

    @Override
    public List<Inspection> findAll() throws RemoteException {
        return inspectionDAO.findAll();
    }

    @Override
    public List<Inspection> findByChurchId(int churchId) throws RemoteException {
        return inspectionDAO.findByChurchId(churchId);
    }

    @Override
    public List<Inspection> findByInspectorId(int inspectorId) throws RemoteException {
        return inspectionDAO.findByInspectorId(inspectorId);
    }

    @Override
    public boolean createDetail(InspectionDetail detail) throws RemoteException {
        return inspectionDetailDAO.create(detail);
    }

    @Override
    public boolean createDetailsBatch(List<InspectionDetail> details) throws RemoteException {
        return inspectionDetailDAO.createBatch(details);
    }

    @Override
    public List<InspectionDetail> findDetailsByInspectionId(int inspectionId) throws RemoteException {
        return inspectionDetailDAO.findByInspectionId(inspectionId);
    }
}
