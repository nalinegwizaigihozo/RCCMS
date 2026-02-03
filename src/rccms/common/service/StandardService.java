package rccms.common.service;

import java.rmi.RemoteException;
import java.util.List;
import rccms.common.domain.InspectionStandard;
import rccms.client.util.RMIClientUtil;

/**
 *
 * @author IT MODERN LTD
 */
public class StandardService {

    public StandardService() {
    }

    public boolean createStandard(InspectionStandard standard) {
        try {
            InspectionStandardService service = RMIClientUtil.getInspectionStandardService();
            if (service == null) return false;
            
            if (service.existsByCode(standard.getStandardCode())) {
                return false;
            }
            return service.create(standard);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateStandard(InspectionStandard standard) {
        try {
            InspectionStandardService service = RMIClientUtil.getInspectionStandardService();
            if (service == null) return false;
            return service.update(standard);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteStandard(int standardId) {
        try {
            InspectionStandardService service = RMIClientUtil.getInspectionStandardService();
            if (service == null) return false;
            return service.delete(standardId);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    public InspectionStandard getStandardById(int standardId) {
        try {
            InspectionStandardService service = RMIClientUtil.getInspectionStandardService();
            if (service == null) return null;
            return service.findById(standardId);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<InspectionStandard> getAllStandards() {
        try {
            InspectionStandardService service = RMIClientUtil.getInspectionStandardService();
            if (service == null) return null;
            return service.findAll();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<InspectionStandard> getStandardsByCategory(String category) {
        try {
            InspectionStandardService service = RMIClientUtil.getInspectionStandardService();
            if (service == null) return null;
            return service.findByCategory(category);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean standardCodeExists(String code) {
        try {
            InspectionStandardService service = RMIClientUtil.getInspectionStandardService();
            if (service == null) return false;
            return service.existsByCode(code);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }
}

