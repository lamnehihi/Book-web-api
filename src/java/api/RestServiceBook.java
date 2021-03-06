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
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Admin
 */
@Path("/books")
@ApplicationPath("api")
public class RestServiceBook extends Application{
    //Test
    // http://localhost:8080/BookWebApi/api/sayHello
    @GET
    @Path("/sayHello")
    public String getHelloMsg() {
        return "hello worldddd";
    }
    
    //get all books
    // http://localhost:8080/BookWebApi/api/books
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Book> getAll() {
        ArrayList<Book> ls = new ArrayList<>();
        ls = BookDB.getAll();
        return ls;
    }
    
    //get book by Id
    // http://localhost:8080/BookWebApi/api/books/id?id=???
    @GET
    @Path("/id")
    @Produces(MediaType.APPLICATION_JSON)
    public Book getById(@QueryParam("id") String Bid) {
        Book b = new Book();
        b = BookDB.getById(Bid);
        return b;
    }
    
    //get books by keyword
    // http://localhost:8080/BookWebApi/api/books/keyword?value=???
    @GET
    @Path("/keyword")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Book> getByKeyWord(@QueryParam("value") String value) {
        ArrayList<Book> ls = new ArrayList<>();
        ls = BookDB.getByKeyWord(value);
        return ls;
    }
    
    //get books by category
    // http://localhost:8080/BookWebApi/api/books/category?value=???
    @GET
    @Path("/category")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Book> getByCategory(@QueryParam("value") String value) {
        ArrayList<Book> ls = new ArrayList<>();
        ls = BookDB.getByCategoryID(value);
        return ls;
    }
    
    //get books by price
    // http://localhost:8080/BookWebApi/api/books/price?from=20000&to=
    @GET
    @Path("/price")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Book> getByPrice(@QueryParam("from") int from, @QueryParam("to") int to) {
        ArrayList<Book> ls = new ArrayList<>();
        ls = BookDB.getByPrice(from, to);
        return ls;
    }
    
    //get books by author
    // http://localhost:8080/BookWebApi/api/books/author
    @GET
    @Path("/author")
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Book> getByPrice(@QueryParam("value") String value) {
        ArrayList<Book> ls = new ArrayList<>();
        ls = BookDB.getByAuthor(value);
        return ls;
    }
    
    //add new book
    // http://localhost:8080/BookWebApi/api/books/add
    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addNewBook(Book b) {
        boolean done = BookDBAdmin.addNewBook(b);
        if(done) {
            return "success!";
        }else return "fail!";
    }
}
