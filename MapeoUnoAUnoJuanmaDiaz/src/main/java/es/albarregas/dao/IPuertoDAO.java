package es.albarregas.dao;

import es.albarregas.beans.Puerto;
import java.util.List;


public interface IPuertoDAO {
    
    public void add(Puerto puerto);
    public List<Puerto> get();
    //deberemos establecer que al coger un registro la pk sea del tipo que sea la pk de la clase
    public Puerto getOne(long pk);
    public void update(Puerto puerto);
    public void delete(Puerto puerto);
   
    
}