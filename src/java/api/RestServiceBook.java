/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Application;
import Model.*;
import Controller.*;
import java.util.ArrayList;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Admin
 */
@Path("/api")
@ApplicationPath("/books")
public class RestServiceBook extends Application{
    
    // http://localhost:8080/BookWebApi/resources/api/sayHello
    @GET
    @Path("/sayHello")
    public String getHelloMsg() {
        return "hello worldddd";
    }
    
    // http://localhost:8080/BookWebApi/resources/api/book
    @GET
    @Path("/book")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Book> getAll() {
        ArrayList<Book> ls = new ArrayList<>();
        ls = BookDB.getAll();
        return ls;
    }
}
