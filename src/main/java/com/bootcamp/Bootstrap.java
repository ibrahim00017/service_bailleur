package com.bootcamp;

import com.bootcamp.config.CustomFilter;
import com.wordnik.swagger.config.ConfigFactory;
import com.wordnik.swagger.config.FilterFactory;
import com.wordnik.swagger.config.*;
import javax.servlet.http.HttpServlet;
import com.wordnik.swagger.model.*;
import java.util.ArrayList;
import java.util.List;

public class Bootstrap extends HttpServlet {
  static {
    // do any additional initialization here, such as set your base path programmatically as such:
    // ConfigFactory.config().setBasePath("http://www.foo.com/");

    // add a custom filter
    FilterFactory.setFilter(new CustomFilter());

    ApiInfo info = new ApiInfo(
      "Swagger Sample App",                             /* title */
      "This is a sample server Petstore server.  You can find out more about Swagger " + 
      "at <a href=\"http://swagger.wordnik.com\">http://swagger.wordnik.com</a> or on irc.freenode.net, #swagger.  For this sample, " + 
      "you can use the api key \"special-key\" to test the authorization filters", 
      "http://helloreverb.com/terms/",                  /* TOS URL */
      "hibrahimyya@gmailcom",                            /* Contact */
      "Apache 2.0",                                     /* license */
      "http://www.apache.org/licenses/LICENSE-2.0.html" /* license URL */
    );

    List<AuthorizationScope> scopes = new ArrayList<AuthorizationScope>();
    scopes.add(new AuthorizationScope("email", "Access to your email address"));
    scopes.add(new AuthorizationScope("pets", "Access to your pets"));

    List<GrantType> grantTypes = new ArrayList<GrantType>();

    ImplicitGrant implicitGrant = new ImplicitGrant(
      new LoginEndpoint("http://localhost:9090/oauth/dialog"),
      "access_code");

    grantTypes.add(implicitGrant);

    AuthorizationType oauth = new OAuthBuilder().scopes(scopes).grantTypes(grantTypes).build();

    //ConfigFactory.config().setAuthorizations(oauth);
    ConfigFactory.config().setApiInfo(info);
  }
}
