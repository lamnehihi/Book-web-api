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
import javax.ws.rs.FormParam;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Admin
 */
@Path("/transactions")
@ApplicationPath("api")
public class RestServiceTransaction extends Application {

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
    public ArrayList<Transaction> getAll() {
        return TransactionDB.getAll();
    }
    //@GET

    @Path("/byTID/{Tid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Transaction> getbytID(@PathParam("Tid") String tid) {
        return TransactionDB.getBytID(tid);
    }

    @Path("/byUID/{Uid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Transaction> getbyuID(@PathParam("Uid") String uid) {
        return TransactionDB.getByuID(uid);
    }

    @Path("/byBID/{Bid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Transaction> getbybID(@PathParam("Bid") String bid) {
        return TransactionDB.getBybID(bid);
    }

    @Path("/byVerifiedStatus")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Transaction> getbyVerifiedStatus() {
        return TransactionDB.getByStatus(true);
    }

    @Path("/byUnVerifiedStatus")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Transaction> getbyUnVerifiedStatus() {
        return TransactionDB.getByStatus(false);
    }

    @Path("/byDate/{Date}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Transaction> getbyDate(@PathParam("Date") String Date) {
        return TransactionDB.getByDate(Date);
    }

    @Path("/byYear/{Year}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Transaction> getbyYear(@PathParam("Year") String Year) {
        return TransactionDB.getByYear(Year);
    }

    @Path("/byMonth/{Month}/{Year}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Transaction> getbyYear(@PathParam("Month") String Month, @PathParam("Year") String Year) {
        return TransactionDB.getByMonth(Month, Year);
    }

    @Path("/Verified/{Tid}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public void changeStatus(@PathParam("Tid") String tid) {
        TransactionDB.ChangeStatus(tid);
    }
    /*
    @Path("/NewTransaction")
    @POST
    public void newTransaction(@FormParam("Transaction") Transaction t) {
        TransactionDB.AddnewTransaction(t);
    }
     */

}
