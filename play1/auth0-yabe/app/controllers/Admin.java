package controllers;
 
import play.*;
import play.mvc.*;
 
import java.util.*;
 
import models.*;
 
@With(Secure.class)
public class Admin extends Controller {
    
    @Before
    static void setConnectedUser() {
        if(Security.isConnected()) {
            // could extract user from jwt to display here
            renderArgs.put("user", "Test");
        }
    }
 
    public static void index() {
        render();
    }
    
}