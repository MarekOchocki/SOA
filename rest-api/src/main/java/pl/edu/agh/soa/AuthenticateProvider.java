package pl.edu.agh.soa;

import io.jsonwebtoken.Jwts;
import jdk.nashorn.internal.parser.Token;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.security.Key;

@Authenticate
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticateProvider implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        String authorizationHeader = containerRequestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        if(authorizationHeader == null)
            containerRequestContext.abortWith(Response.status((Response.Status.UNAUTHORIZED)).build());

        Key key = TokenGenerator.getKey();
        boolean validToken = Jwts.parser().setSigningKey(key).isSigned(authorizationHeader);

        if(!validToken) {
            containerRequestContext.abortWith(Response.status((Response.Status.UNAUTHORIZED)).build());
        }

    }
}
