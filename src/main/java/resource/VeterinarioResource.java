package resource;

import java.sql.Connection;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import exception.ColecaoException;
import exception.ConexaoException;
import model.Veterinario;
import persistence.ColecaoDeVeterinario;
import persistence.ColecaoDeVeterinarioEmBDR;
import persistence.ConexaoSingleton;

@Path("/veterinario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VeterinarioResource {
	
    @GET
    @Path("/")
	public List<Veterinario> todos() throws ConexaoException, ColecaoException {
	 Connection con = ConexaoSingleton.getConexao();
	 ColecaoDeVeterinario cv = new ColecaoDeVeterinarioEmBDR( con);
	 return cv.todos();
	}
    
    @GET
    @Path("/{id:[0-9]+}") // usando expressoes regulares
    public Veterinario porId(@PathParam("id") int id) throws ConexaoException, ColecaoException {
     Connection con = ConexaoSingleton.getConexao();
   	 ColecaoDeVeterinario cv = new ColecaoDeVeterinarioEmBDR( con);
   	 return cv.porId(id);
    }
    
    
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public void inserir (Veterinario v) throws ConexaoException, ColecaoException {
    	Connection con = ConexaoSingleton.getConexao();
      	ColecaoDeVeterinario cv = new ColecaoDeVeterinarioEmBDR( con);
      	cv.inserir(v); 
    }
    
    
    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public void alterar( Veterinario v) throws ConexaoException, ColecaoException { 
    	 Connection con = ConexaoSingleton.getConexao();
      	 ColecaoDeVeterinario cv = new ColecaoDeVeterinarioEmBDR( con);
      	 cv.alterar(v);
    }
    
    @DELETE
    @Path("/{id:[0-9]+}") // usando expressoes regulares
    public void remover (@PathParam("id") int id) throws ConexaoException, ColecaoException {
   	 Connection con = ConexaoSingleton.getConexao();
  	 ColecaoDeVeterinario cv = new ColecaoDeVeterinarioEmBDR( con);
  	 Veterinario v = new Veterinario();
  	 cv.remover(v);
    }
    
}
