package hibernate;

import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Gauge;
import org.eclipse.microprofile.metrics.annotation.Timed;

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
    @Counted(name="getProdutos contator")
    @Timed(name="Duração busca produtos")
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

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/memoria")
    @Gauge(name="Quantidade de memoria",unit= MetricUnits.BYTES)
    public long quantidadeMemoria(){
        return Runtime.getRuntime().freeMemory();
    }
}
