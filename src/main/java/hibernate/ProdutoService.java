package hibernate;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class ProdutoService {

    @Inject
    EntityManager entityManager;

    public List<Produto> getProdutos(){
        return entityManager.createQuery("select p from Produto p", Produto.class).getResultList();
    }

    public void addProduto(Produto produto){
        entityManager.persist(produto);
    }
}
