package rccms.server.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import rccms.common.domain.Inspection;
import rccms.server.util.JPAUtil;

/**
 *
 * @author IT MODERN LTD
 */
public class InspectionDAO {

    public boolean create(Inspection inspection) {
        EntityManager em = null;
        try {
            em = JPAUtil.getEntityManagerFactory().createEntityManager();
            em.getTransaction().begin();
            em.persist(inspection);
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

    public int createAndGetId(Inspection inspection) {
        EntityManager em = null;
        try {
            em = JPAUtil.getEntityManagerFactory().createEntityManager();
            em.getTransaction().begin();
            em.persist(inspection);
            em.getTransaction().commit();
            return inspection.getInspectionId();
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
            return -1;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Inspection findById(int inspectionId) {
        EntityManager em = null;
        try {
            em = JPAUtil.getEntityManagerFactory().createEntityManager();
            return em.find(Inspection.class, inspectionId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Inspection> findAll() {
        EntityManager em = null;
        try {
            em = JPAUtil.getEntityManagerFactory().createEntityManager();
            TypedQuery<Inspection> query = em.createQuery("SELECT i FROM Inspection i ORDER BY i.inspectionDate DESC", Inspection.class);
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

    public List<Inspection> findByChurchId(int churchId) {
        EntityManager em = null;
        try {
            em = JPAUtil.getEntityManagerFactory().createEntityManager();
            TypedQuery<Inspection> query = em.createQuery("SELECT i FROM Inspection i WHERE i.churchId = :churchId ORDER BY i.inspectionDate DESC", Inspection.class);
            query.setParameter("churchId", churchId);
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

    public List<Inspection> findByInspectorId(int inspectorId) {
        EntityManager em = null;
        try {
            em = JPAUtil.getEntityManagerFactory().createEntityManager();
            TypedQuery<Inspection> query = em.createQuery("SELECT i FROM Inspection i WHERE i.inspectorId = :inspectorId ORDER BY i.inspectionDate DESC", Inspection.class);
            query.setParameter("inspectorId", inspectorId);
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
