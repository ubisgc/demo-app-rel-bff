package sgc.dk;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import sgc.dk.model.Account;
import sgc.dk.model.Posting;
import sgc.dk.outbound.AccountService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Set;

@Path("/rel")
public class AccountBFFService {

    @Inject
    @RestClient
    AccountService accountService;

    @GET
    @Path("/bffaccount/{accountNumber}")
    public Account getAccount(@PathParam("accountNumber") String accountNumber) {
        System.out.println("Nu er vi her : " + accountNumber);
        return accountService.getByAccountNumber(accountNumber);
    }

    @GET
    @Path("/bffaccount/postings/{accountNumber}")
    public Set<Posting> getPostings(@PathParam("accountNumber") String accountNumber) {
        System.out.println("Nu er vi her postings : " + accountNumber);
        return accountService.getByAccountPostings(accountNumber);
    }

}
