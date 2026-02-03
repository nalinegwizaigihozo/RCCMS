package rccms.common.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import rccms.common.domain.InspectionStandard;

/**
 *
 * @author IT MODERN LTD
 */
public interface InspectionStandardService extends Remote {
    boolean create(InspectionStandard standard) throws RemoteException;
    boolean update(InspectionStandard standard) throws RemoteException;
    boolean delete(int standardId) throws RemoteException;
    InspectionStandard findById(int standardId) throws RemoteException;
    List<InspectionStandard> findAll() throws RemoteException;
    List<InspectionStandard> findByCategory(String category) throws RemoteException;
    boolean existsByCode(String code) throws RemoteException;
}
