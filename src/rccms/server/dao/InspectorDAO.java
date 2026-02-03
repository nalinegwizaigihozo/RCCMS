package rccms.server.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import rccms.common.domain.Inspector;
import rccms.common.exception.DatabaseException;
import rccms.server.util.JPAUtil;

/**
 *
 * @author IT MODERN LTD
 */
public class InspectorDAO {

    public boolean create(Inspector inspector) throws DatabaseException {
        if (inspector == null) {
            throw new DatabaseException("Inspector object cannot be null");
        }

        EntityManager em = null;
        try {
            em = JPAUtil.getEntityManagerFactory().createEntityManager();
            em.getTransaction().begin();
            em.persist(inspector);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new DatabaseException("Database error while creating inspector: " + e.getMessage(), e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public boolean update(Inspector inspector) throws DatabaseException {
        if (inspector == null) {
            throw new DatabaseException("Inspector object cannot be null");
        }
        if (inspector.getInspectorId() <= 0) {
            throw new DatabaseException("Invalid inspector ID for update");
        }

        EntityManager em = null;
        try {
            em = JPAUtil.getEntityManagerFactory().createEntityManager();
            em.getTransaction().begin();
            em.merge(inspector);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new DatabaseException("Database error while updating inspector: " + e.getMessage(), e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public boolean delete(int inspectorId) throws DatabaseException {
        if (inspectorId <= 0) {
            throw new DatabaseException("Invalid inspector ID for deletion");
        }

        EntityManager em = null;
        try {
            em = JPAUtil.getEntityManagerFactory().createEntityManager();
            em.getTransaction().begin();
            Inspector inspector = em.find(Inspector.class, inspectorId);
            if (inspector != null) {
                em.remove(inspector);
                em.getTransaction().commit();
                return true;
            }
            return false; // Not found
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new DatabaseException("Database error while deleting inspector: " + e.getMessage(), e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Inspector findById(int inspectorId) throws DatabaseException {
        if (inspectorId <= 0) {
            throw new DatabaseException("Invalid inspector ID");
        }

        EntityManager em = null;
        try {
            em = JPAUtil.getEntityManagerFactory().createEntityManager();
            return em.find(Inspector.class, inspectorId);
        } catch (Exception e) {
            throw new DatabaseException("Database error while finding inspector: " + e.getMessage(), e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Inspector> findAll() throws DatabaseException {
        EntityManager em = null;
        try {
            em = JPAUtil.getEntityManagerFactory().createEntityManager();
            TypedQuery<Inspector> query = em.createQuery("SELECT i FROM Inspector i ORDER BY i.lastName, i.firstName", Inspector.class);
            return query.getResultList();
        } catch (Exception e) {
            throw new DatabaseException("Database error while retrieving inspectors: " + e.getMessage(), e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public boolean existsByIdNumber(String idNumber) throws DatabaseException {
        if (idNumber == null || idNumber.trim().isEmpty()) {
            return false;
        }

        EntityManager em = null;
        try {
            em = JPAUtil.getEntityManagerFactory().createEntityManager();
            TypedQuery<Long> query = em.createQuery("SELECT COUNT(i) FROM Inspector i WHERE i.inspectorIdNumber = :idNumber", Long.class);
            query.setParameter("idNumber", idNumber.trim());
            return query.getSingleResult() > 0;
        } catch (Exception e) {
            throw new DatabaseException("Database error while checking inspector ID number: " + e.getMessage(), e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public boolean existsByEmail(String email) throws DatabaseException {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }

        EntityManager em = null;
        try {
            em = JPAUtil.getEntityManagerFactory().createEntityManager();
            TypedQuery<Long> query = em.createQuery("SELECT COUNT(i) FROM Inspector i WHERE i.email = :email", Long.class);
            query.setParameter("email", email.trim());
            return query.getSingleResult() > 0;
        } catch (Exception e) {
            throw new DatabaseException("Database error while checking email: " + e.getMessage(), e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public Inspector findByUserId(int userId) throws DatabaseException {
        if (userId <= 0) {
            throw new DatabaseException("Invalid inspector ID");
        }

        EntityManager em = null;
        try {
            em = JPAUtil.getEntityManagerFactory().createEntityManager();
            TypedQuery<Inspector> query = em.createQuery("SELECT i FROM Inspector i WHERE i.userId = :userId", Inspector.class);
            query.setParameter("userId", userId);
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new DatabaseException("Database error while finding inspector: " + e.getMessage(), e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
