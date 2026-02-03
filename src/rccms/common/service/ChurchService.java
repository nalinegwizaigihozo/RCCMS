package rccms.common.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import rccms.common.domain.Church;

/**
 *
 * @author IT MODERN LTD
 */
public interface ChurchService extends Remote {
    boolean create(Church church) throws RemoteException;
    boolean update(Church church) throws RemoteException;
    boolean delete(int churchId) throws RemoteException;
    Church findById(int churchId) throws RemoteException;
    List<Church> findAll() throws RemoteException;
    List<Church> findByDistrict(String district) throws RemoteException;
    boolean existsByRegistrationNumber(String regNumber) throws RemoteException;
    boolean updateComplianceStatus(int churchId, String status) throws RemoteException;
    boolean updateLastInspectionDate(int churchId, java.util.Date date) throws RemoteException;
}
