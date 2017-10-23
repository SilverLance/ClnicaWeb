/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.asfecer.dao;

import br.com.asfecer.dao.exceptions.NonexistentEntityException;
import br.com.asfecer.dao.exceptions.RollbackFailureException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import br.com.asfecer.model.Consulta;
import br.com.asfecer.model.Receituario;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.transaction.UserTransaction;

/**
 *
 * @author PToledo
 */
public class ReceituarioDAO implements Serializable {

    public ReceituarioDAO(UserTransaction utx, EntityManagerFactory emf) {
        this.utx = utx;
        this.emf = emf;
    }
    private UserTransaction utx = null;
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Receituario receituario) throws RollbackFailureException, RuntimeException {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Consulta consulta = receituario.getConsulta();
            if (consulta != null) {
                consulta = em.getReference(consulta.getClass(), consulta.getIdConsulta());
                receituario.setConsulta(consulta);
            }
            em.persist(receituario);
            if (consulta != null) {
                consulta.getReceituarioCollection().add(receituario);
                consulta = em.merge(consulta);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            new RuntimeException(ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Receituario receituario) throws NonexistentEntityException, RollbackFailureException, RuntimeException {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Receituario persistentReceituario = em.find(Receituario.class, receituario.getIdReceituario());
            Consulta consultaOld = persistentReceituario.getConsulta();
            Consulta consultaNew = receituario.getConsulta();
            if (consultaNew != null) {
                consultaNew = em.getReference(consultaNew.getClass(), consultaNew.getIdConsulta());
                receituario.setConsulta(consultaNew);
            }
            receituario = em.merge(receituario);
            if (consultaOld != null && !consultaOld.equals(consultaNew)) {
                consultaOld.getReceituarioCollection().remove(receituario);
                consultaOld = em.merge(consultaOld);
            }
            if (consultaNew != null && !consultaNew.equals(consultaOld)) {
                consultaNew.getReceituarioCollection().add(receituario);
                consultaNew = em.merge(consultaNew);
            }
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = receituario.getIdReceituario();
                if (findReceituario(id) == null) {
                    throw new NonexistentEntityException("The receituario with id " + id + " no longer exists.");
                }
            }
            new RuntimeException(ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, RuntimeException {
        EntityManager em = null;
        try {
            utx.begin();
            em = getEntityManager();
            Receituario receituario;
            try {
                receituario = em.getReference(Receituario.class, id);
                receituario.getIdReceituario();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The receituario with id " + id + " no longer exists.", enfe);
            }
            Consulta consulta = receituario.getConsulta();
            if (consulta != null) {
                consulta.getReceituarioCollection().remove(receituario);
                consulta = em.merge(consulta);
            }
            em.remove(receituario);
            utx.commit();
        } catch (Exception ex) {
            try {
                utx.rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            new RuntimeException(ex);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Receituario> findReceituarioEntities() {
        return findReceituarioEntities(true, -1, -1);
    }

    public List<Receituario> findReceituarioEntities(int maxResults, int firstResult) {
        return findReceituarioEntities(false, maxResults, firstResult);
    }

    private List<Receituario> findReceituarioEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Receituario.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Receituario findReceituario(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Receituario.class, id);
        } finally {
            em.close();
        }
    }

    public int getReceituarioCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Receituario> rt = cq.from(Receituario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
