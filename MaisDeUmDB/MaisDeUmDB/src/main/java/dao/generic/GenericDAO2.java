package main.java.dao.generic;

import java.io.Serializable;

import main.java.dao.Persistente;

public abstract class GenericDAO2 <T extends Persistente, E extends Serializable> extends GenericDAO<T,E>{

    public GenericDAO2(Class<T> persistenteClass) {
        super(persistenteClass, "JPA2");
        
    }

}
