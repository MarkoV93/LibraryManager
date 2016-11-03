/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.impl;


import com.mycompany.util.HibernateUtil;
import java.sql.SQLException;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

/**
 * abstract class which extends all dao classes 
 */
public abstract class AbstractDao {

    protected Session session;
    protected Transaction tx;
    private static final Logger logger = LogManager.getLogger(AbstractDao.class);

    public AbstractDao() {

    }
    //save or update row of table  

    protected boolean saveOrUpdate(Object obj) {
        try {
            startOperation();
            session.saveOrUpdate(obj);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            logger.warn("object didn't create" );
            return false;

        } finally {
            if ((session != null) && (session.isOpen())) {
                try {
                    session.close();
                } catch (HibernateException e) {
                    logger.error("connection doun't clouse" );
                }
            }
        }
    }

    //eturn row of table
    protected boolean delete(Object obj) {
        try {
            startOperation();
            session.delete(obj);
            tx.commit();
            return true;
        } catch (HibernateException e) {
            logger.warn("object doesn't deleted" );
          
            return false;

        } finally {
            if ((session != null) && (session.isOpen())) {
                try {
                    session.close();
                } catch (HibernateException e) {
                    logger.warn("connection doun't clouse" );
                }
            }
        }
    }
    //eturn row of table  which corresponds entity class "clazz" by id
    protected Object get(Class clazz, int id) {
        Object obj = null;
        try {
            startOperation();
            obj = session.get(clazz, id);
            tx.commit();
        } catch (HibernateException e) {
            logger.error("object not found" + e.getCause());
        } finally {
            if ((session != null) && (session.isOpen())) {
                try {
                    session.close();
                } catch (HibernateException e) {
                    logger.warn("connection doun't clouse");
                }
            }
        }
        return obj;
    }
 

   
    //eturn all rows of table  which corresponds entity class "clazz"

    protected List getAll(Class clazz) {
        List objects = null;
        try {
            startOperation();
            Query query = session.createQuery("from " + clazz.getName());
            objects = query.list();
            tx.commit();
        } catch (HibernateException e) {
            logger.error("object not found" );
        } finally {
            if ((session != null) && (session.isOpen())) {
                try {
                    session.close();
                } catch (HibernateException e) {
                    logger.warn("connection doun't clouse" );
                }
            }
        }
        return objects;
    }
    //return  row from table with by criteria

  protected Object getByCriteria(Class clazz, String criteria,String criteriaValue) {
        Object result = null;
        try {
            startOperation();
            Criteria categoryCriteria = session.createCriteria(clazz);
            categoryCriteria.add(Restrictions.eq(criteria, criteriaValue));
            result = categoryCriteria.uniqueResult();
            tx.commit();
        } catch (HibernateException e) {
            logger.error("category not found" );
        } finally {
            if ((session != null) && (session.isOpen())) {
                try {
                    session.close();
                } catch (HibernateException e) {
                    logger.warn("connection doun't clouse");
                }
            }
        }
        return result;
    }

   

    protected void startOperation() {
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
        } catch (HibernateException e) {
            logger.error("session didn't open or transaction didn't begin" + e.getCause());
        }
    }

}
