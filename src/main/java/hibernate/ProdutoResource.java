package hibernate;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Transactional
@Path("/produtos")
public class ProdutoResource {

    @Inject EntityManager entityManager;

    @GET
    @Produces(value= MediaType.APPLICATION_JSON)
    public List<Produto> getProdutos(){

        return entityManager.createQuery("select p from Produto p", Produto.class).getResultList();
    }

    @POST
    @Produces(value= MediaType.APPLICATION_JSON)
    @Consumes(value= MediaType.APPLICATION_JSON)
    public void addProduto(Produto produto){
        entityManager.persist(produto);
    }
}
