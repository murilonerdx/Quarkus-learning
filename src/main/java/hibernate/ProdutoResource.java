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

    @Inject ProdutoService produtoService;

    @GET
    @Produces(value= MediaType.APPLICATION_JSON)
    public List<Produto> getProdutos(){
        return produtoService.getProdutos();
    }

    @POST
    @Produces(value= MediaType.APPLICATION_JSON)
    @Consumes(value= MediaType.APPLICATION_JSON)
    public void addProduto(Produto produto){
        produtoService.addProduto(produto);
    }
}
