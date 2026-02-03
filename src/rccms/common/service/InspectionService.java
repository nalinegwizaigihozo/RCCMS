package rccms.common.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import rccms.common.domain.Inspection;
import rccms.common.domain.InspectionDetail;

/**
 *
 * @author IT MODERN LTD
 */
public interface InspectionService extends Remote {
    boolean create(Inspection inspection) throws RemoteException;
    int createAndGetId(Inspection inspection) throws RemoteException;
    Inspection findById(int inspectionId) throws RemoteException;
    List<Inspection> findAll() throws RemoteException;
    List<Inspection> findByChurchId(int churchId) throws RemoteException;
    List<Inspection> findByInspectorId(int inspectorId) throws RemoteException;
    
    // Inspection Detail methods
    boolean createDetail(InspectionDetail detail) throws RemoteException;
    boolean createDetailsBatch(List<InspectionDetail> details) throws RemoteException;
    List<InspectionDetail> findDetailsByInspectionId(int inspectionId) throws RemoteException;
}
