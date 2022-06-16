package fr.m2i.loupgarou.api;

import fr.m2i.loupgarou.entities.Annuaire;
import fr.m2i.loupgarou.entities.Villageois;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Optional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/villageois")
public class AnnuaireAPI {

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public ArrayList<Villageois> getAll(@Context HttpServletRequest request) {
        Annuaire annuaire = (Annuaire) request.getSession().getAttribute("annuaire");
        if (annuaire == null) {
            annuaire = new Annuaire();
        }

        return annuaire.getListOfVillageois();

    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Response getVillageoisById(@Context HttpServletRequest request, @PathParam("id") long id) {
        Annuaire annuaire = (Annuaire) request.getSession().getAttribute("annuaire");
        if (annuaire == null) {
            annuaire = new Annuaire();
        }

        Optional<Villageois> villageois = annuaire.getVillageoisById(id);

        if (villageois.isPresent()) {
            return Response.ok(villageois.get()).build();
        }

        return Response.status(404).entity("Aucun villageois ne correspond à cet id").build();

    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response createVillageois(@Context HttpServletRequest request, Villageois villageois) {
        Annuaire annuaire = (Annuaire) request.getSession().getAttribute("annuaire");
        if (annuaire == null) {
            annuaire = new Annuaire();
        }

        annuaire.addVillageois(villageois);

        request.getSession().setAttribute("annuaire", annuaire);

        return Response.ok().entity("Ajout effectué").build();

    }

    @PUT
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public Response updateVillageois(@Context HttpServletRequest request, Villageois villageois) {
        Annuaire annuaire = (Annuaire) request.getSession().getAttribute("annuaire");
        if (annuaire == null) {
            annuaire = new Annuaire();
        }

        if (annuaire.getVillageoisById(villageois.getId()).isPresent()) {

            annuaire.updateVillageois(villageois);

            request.getSession().setAttribute("annuaire", annuaire);

            return Response.ok().entity("Mise à jour effectué").build();
        }

        return Response.status(404).entity("Ce villageois n'existe pas").build();

    }

    @DELETE
    @Path("/{id}")
    public Response deleteVillageoisById(@Context HttpServletRequest request, @PathParam("id") long id) {
        Annuaire annuaire = (Annuaire) request.getSession().getAttribute("annuaire");
        if (annuaire == null) {
            annuaire = new Annuaire();
        }

        if (annuaire.getVillageoisById(id).isPresent()) {

            annuaire.deleteVillageoisById(id);

            return Response.ok().entity("Suppression effectué").build();

        }

        return Response.status(404).entity("Ce villageois n'existe pas").build();

    }

}
