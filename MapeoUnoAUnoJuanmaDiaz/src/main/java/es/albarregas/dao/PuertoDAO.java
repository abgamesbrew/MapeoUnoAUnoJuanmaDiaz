package es.albarregas.dao;

import es.albarregas.beans.Puerto;
import es.albarregas.persistencia.HibernateUtil;

import java.util.List;

import org.hibernate.Session;


public class PuertoDAO implements IPuertoDAO {

     @Override
    public void add(Puerto puerto) {
        Session sesion = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.save(puerto);
            sesion.getTransaction().commit();
        } catch(org.hibernate.JDBCException jdbce){
            if(sesion != null){
                sesion.getTransaction().rollback();
            }
        } finally {
            if(sesion != null){
                sesion.close();
            }
        }
    }

    @Override
    public List<Puerto> get() {
        List<Puerto> listado = null;
        Session sesion = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            
            //seleccionamos la clase de la que se quiera sacar el listado no la base de datos
            listado = sesion.createQuery(" from Puerto").list();
            sesion.getTransaction().commit();
        } catch(org.hibernate.JDBCException jdbce){
            if(sesion != null){
                sesion.getTransaction().rollback();
            }
        } finally {
            if(sesion != null){
                sesion.close();
            }
        }
        return listado;
    }

    @Override
    public void delete(Puerto puerto) {
        Session sesion = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.delete(puerto);
            sesion.getTransaction().commit();
        } catch(org.hibernate.JDBCException jdbce){
            if(sesion != null){
                sesion.getTransaction().rollback();
            }
        } finally {
            if(sesion != null){
                sesion.close();
            }
        }
    }

    @Override
    public Puerto getOne(long pk) {
        Puerto puerto = new Puerto();
        Session sesion = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            puerto = (Puerto)sesion.get(Puerto.class, pk);
            sesion.getTransaction().commit();
        } catch(org.hibernate.JDBCException jdbce){
            if(sesion != null){
                sesion.getTransaction().rollback();
            }
        } finally {
            if(sesion != null){
                sesion.close();
            }
        }
        return puerto;
    }

    @Override
    public void update(Puerto puerto) {
        Session sesion = null;
        try {
            sesion = HibernateUtil.getSessionFactory().openSession();
            sesion.beginTransaction();
            sesion.update(puerto);
            sesion.getTransaction().commit();
        } catch(org.hibernate.JDBCException jdbce){
            if(sesion != null){
                sesion.getTransaction().rollback();
            }
        } finally {
            if(sesion != null){
                sesion.close();
            }
        }
    }

}
