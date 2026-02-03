package rccms.server.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import rccms.common.domain.User;
import rccms.common.exception.DatabaseException;
import rccms.server.util.JPAUtil;

/**
 *
 * @author IT MODERN LTD
 */
public class UserDAO {

    public User authenticate(String username, String password) throws DatabaseException {
        if (username == null || username.trim().isEmpty()) {
            throw new DatabaseException("Username cannot be null or empty");
        }
        if (password == null || password.trim().isEmpty()) {
            throw new DatabaseException("Password cannot be null or empty");
        }

        EntityManager em = null;
        try {
            em = JPAUtil.getEntityManagerFactory().createEntityManager();
            String jpql = "SELECT u FROM User u WHERE u.username = :username AND u.password = :password AND u.active = true";
            TypedQuery<User> query = em.createQuery(jpql, User.class);
            query.setParameter("username", username.trim());
            query.setParameter("password", password);

            return query.getSingleResult();
        } catch (NoResultException e) {
            return null; // User not found
        } catch (Exception e) {
            throw new DatabaseException("Database error during authentication: " + e.getMessage(), e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public boolean createUser(User user) throws DatabaseException {
        if (user == null) {
            throw new DatabaseException("User object cannot be null");
        }
        if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
            throw new DatabaseException("Username cannot be null or empty");
        }

        EntityManager em = null;
        try {
            em = JPAUtil.getEntityManagerFactory().createEntityManager();
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new DatabaseException("Database error while creating user: " + e.getMessage(), e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public User findByUsername(String username) throws DatabaseException {
        if (username == null || username.trim().isEmpty()) {
            throw new DatabaseException("Username cannot be null or empty");
        }

        EntityManager em = null;
        try {
            em = JPAUtil.getEntityManagerFactory().createEntityManager();
            String jpql = "SELECT u FROM User u WHERE u.username = :username";
            TypedQuery<User> query = em.createQuery(jpql, User.class);
            query.setParameter("username", username.trim());
            return query.getSingleResult();
        } catch (NoResultException e) {
            return null;
        } catch (Exception e) {
            throw new DatabaseException("Database error while finding user: " + e.getMessage(), e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public boolean delete(int userId) throws DatabaseException {
        if (userId <= 0) {
            throw new DatabaseException("Invalid User ID for deletion");
        }

        EntityManager em = null;
        try {
            em = JPAUtil.getEntityManagerFactory().createEntityManager();
            em.getTransaction().begin();
            User user = em.find(User.class, userId);
            if (user != null) {
                em.remove(user);
                em.getTransaction().commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new DatabaseException("Database error while deleting user: " + e.getMessage(), e);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
