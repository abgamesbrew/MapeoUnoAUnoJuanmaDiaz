package es.albarregas.daofactory;

import es.albarregas.dao.IGenericoDAO;
import es.albarregas.dao.IPuertoDAO;

public abstract class DAOFactory {

    

    public abstract IPuertoDAO getPuertoDAO();
    public abstract IGenericoDAO getGenericoDAO();

    public static DAOFactory getDAOFactory() {
        DAOFactory daof = null;

        daof = new MySQLDAOFactory();

        return daof;
    }

}
