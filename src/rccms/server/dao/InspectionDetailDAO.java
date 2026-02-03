package rccms.server.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import rccms.common.domain.InspectionDetail;
import rccms.server.util.JPAUtil;

/**
 *
 * @author IT MODERN LTD
 */
public class InspectionDetailDAO {

    public boolean create(InspectionDetail detail) {
        EntityManager em = null;
        try {
            em = JPAUtil.getEntityManagerFactory().createEntityManager();
            em.getTransaction().begin();
            em.persist(detail);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public boolean createBatch(List<InspectionDetail> details) {
        EntityManager em = null;
        try {
            em = JPAUtil.getEntityManagerFactory().createEntityManager();
            em.getTransaction().begin();
            for (InspectionDetail detail : details) {
                em.persist(detail);
            }
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<InspectionDetail> findByInspectionId(int inspectionId) {
        EntityManager em = null;
        try {
            em = JPAUtil.getEntityManagerFactory().createEntityManager();
            TypedQuery<InspectionDetail> query = em.createQuery("SELECT d FROM InspectionDetail d WHERE d.inspectionId = :inspectionId", InspectionDetail.class);
            query.setParameter("inspectionId", inspectionId);
            return query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
