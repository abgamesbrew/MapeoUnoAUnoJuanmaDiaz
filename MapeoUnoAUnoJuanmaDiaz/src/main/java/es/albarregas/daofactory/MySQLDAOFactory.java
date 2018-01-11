package es.albarregas.daofactory;

import es.albarregas.dao.GenericoDAO;
import es.albarregas.dao.IGenericoDAO;
import es.albarregas.dao.PuertoDAO;
import es.albarregas.dao.IPuertoDAO;


public class MySQLDAOFactory extends DAOFactory{

    @Override
    public IPuertoDAO getPuertoDAO() {
        return new PuertoDAO();
    }

    @Override
    public IGenericoDAO getGenericoDAO() {
        return new GenericoDAO();
    }

    

    
    
}
