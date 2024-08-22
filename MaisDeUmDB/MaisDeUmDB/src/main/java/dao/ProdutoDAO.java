package main.java.dao;

import main.java.dao.generic.GenericDAO1;
import main.java.domain.Produto;

public class ProdutoDAO extends GenericDAO1<Produto,Long> implements IProdutoDAO {

    public ProdutoDAO() {
        super(Produto.class);
        
    }

  

   

}
