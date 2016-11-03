/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dao.impl;

import com.mycompany.dao.BookDao;
import com.mycompany.model.Book;
import com.mycompany.model.Genre;
import com.mycompany.util.HibernateUtil;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Marko
 */
public class BookDaoImpl extends AbstractDao implements BookDao{

      private static final Logger logger = LogManager.getLogger(AbstractDao.class);
    
    @Override
    public boolean saveOrUpdate(Book book) {
       return super.saveOrUpdate(book);
    }

    @Override
    public boolean delete(Book book) {
       return super.delete(book);
    }

    @Override
    public Book get(int id) {
       return (Book)super.get(Book.class, id);
    }

    @Override
    public List<Book> getAll() {
       return super.getAll(Book.class);
     
    }
    
    //return books by title
      @Override
    public List<Book> getBooksByTitle(String title) {
        List<Book> result = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Criteria productCriteria = session.createCriteria(Book.class);   
                productCriteria.add(Restrictions.eq("title", title));
            result = productCriteria.list();
        } catch (HibernateException e) {
            logger.error("book not found not found" + e.getCause());
        } finally {
            if ((session != null) && (session.isOpen())) {
                try {
                    session.close();
                } catch (HibernateException e) {
                    logger.warn("connection dount clouse" + e.getCause());
                }
            }
        }
        return result;

    }
    
    //return books by part of title of by genre
       @Override
 public List<Book> getBooksByCriterias(String title, Genre genre) {
        List<Book> result = null;
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            Criteria productCriteria = session.createCriteria(Book.class);   
            if(title!=null){
                productCriteria.add(Restrictions.like("title", "%" + title + "%").ignoreCase());
            }
            if(genre!=null){
                 productCriteria.add(Restrictions.eq("genre", genre));
            }
            result = productCriteria.list();
        } catch (HibernateException e) {
           logger.warn("books not found" );
        } finally {
            if ((session != null) && (session.isOpen())) {
                try {
                    session.close();
                } catch (HibernateException e) {
                    logger.warn("connection dount clouse" + e.getCause());
                }
            }
        }
        return result;

    }
}
