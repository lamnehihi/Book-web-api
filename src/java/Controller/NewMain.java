/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Transaction;
import java.util.ArrayList;

/**
 *
 * @author tran phu phat
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<Transaction> ls = TransactionDB.getAll();
        for (Transaction l : ls) {
            System.out.println(l);
            
        }
    }
    
}
