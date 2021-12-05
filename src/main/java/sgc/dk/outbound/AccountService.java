package sgc.dk.outbound;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.jboss.resteasy.annotations.jaxrs.QueryParam;
import sgc.dk.model.Account;
import sgc.dk.model.Posting;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.Set;


@Path("/account")
@RegisterRestClient
public interface AccountService {
    @GET
    @Path("/account/{accountNumber}")
    Account getByAccountNumber(@PathParam("accountNumber") String accountNumber);
    @GET
    @Path("/postings/{accountNumber}")
    Set<Posting> getByAccountPostings(@PathParam("accountNumber") String accountNumber);
}