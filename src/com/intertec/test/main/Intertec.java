/*
 # ===================================================
 # Intertec
 # ***************************************************
 # Projeto: Intertec Test
 # Programmer: Weverton de Souza Castanho
 # Data: 11.01.2016
 # =================================================== 
 */
package com.intertec.test.main;

import com.intertec.test.model.DictonaryTO;
import com.intertec.test.model.UserNameTO;
import com.intertec.test.persistence.Dictonary;
import com.intertec.test.persistence.UserName;
import com.intertec.test.properties.Constants;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.lang.System.exit;

public class Intertec {

    public static void main(String[] args){
        Constants constants = new Constants();
        String input = args[0];
        String message = "";
        UserName userName = new UserName();
        UserNameTO userNameTO = new UserNameTO();
        Dictonary dictonary = new Dictonary();
        DictonaryTO dictonaryTO = new DictonaryTO();

        // -- Verify command usage --
        // --------------------------
        if (args.length < 1) {
            System.out.println("Usage: java -jar Intertec.jar <argument>");
            exit(1);
        }

        // -- Verify restrict words --
        // ---------------------------
        dictonaryTO.setWord(input);
        try {
            if (dictonary.restrictWords(dictonaryTO)) {
                System.out.println("The word " + input + " is a restrict word, please try again!");
                exit(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Intertec.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Intertec.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Intertec.class.getName()).log(Level.SEVERE, null, ex);
        }

        // -- Verify the word length --
        // ----------------------------
        if (constants.MINIMUM_LENGHT >= input.length()) {
            System.out.println("The length must be equal or higher than " + constants.MINIMUM_LENGHT);
            exit(1);
        }

        // -- Try to insert username --
        // ----------------------------
        userNameTO.setUsername(input);
        try {
            message = userName.insert(userNameTO);
            if (!message.isEmpty()) {
                System.out.print(message.toString());
                nameSugestion(input);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Intertec.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Intertec.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Intertec.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("The username: " + input + " was include in database");
    }

    private static void nameSugestion(String input) {
        UserName userName = new UserName();
        UserNameTO userNameTO = new UserNameTO();

        String concatenatedName = "";
        System.out.println("\nTry this sugested user names: ");
        Random rnd = new Random(); // Initialize number generator
        for (int i = 0; i <= 14; i++) {
            concatenatedName += input; // You did not specify what to do, if the name is shorter than 5 chars
            concatenatedName += Integer.toString(rnd.nextInt(99));
            
            // -- Verify if the sugestion name is being in use --
            // --------------------------------------------------     
            userNameTO.setUsername(concatenatedName);
            try {
                if (userName.verifyName(userNameTO)) {
                    // -- If there is the same name in database the method will try again --
                    // ---------------------------------------------------------------------
                    i--;
                }else
                    System.out.println(concatenatedName);        
            } catch (SQLException ex) {
                Logger.getLogger(Intertec.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(Intertec.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Intertec.class.getName()).log(Level.SEVERE, null, ex);
            }
            concatenatedName = "";
        }
    }
}
