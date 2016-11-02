/*
 # ===================================================
 # Intertec
 # ***************************************************
 # Projeto: Intertec Test
 # Programmer: Weverton de Souza Castanho
 # Data: 11.01.2016
 # =================================================== 
 */
package com.intertec.test.persistence;

import com.intertec.test.connection.DbConnection;
import com.intertec.test.model.UserNameTO;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserName {

    private static final Logger logger = Logger.getLogger(UserName.class.getName());

    public String insert(UserNameTO userNameTO) throws SQLException, IOException, ClassNotFoundException {

        DbConnection connection = DbConnection.getInstance();

        String query;
        Statement stmt = connection.getConnection().createStatement();
        logger.info("Loading Database");

        try {
            logger.info("Executing Query");

            query = "insert into USERNAME";
            query += "(ID, USERNAME) ";
            query += "values(" + userNameTO.getId() + ",";
            query += "\'" + userNameTO.getUsername() + "\')";
            logger.log(Level.INFO, "Consulta: {0}", query);
            stmt.executeUpdate(query);

        } catch (SQLException ex) {
            logger.log(Level.WARNING, ex.getMessage());
            return ex.getMessage();
        }
        return "";
    }

    public boolean verifyName(UserNameTO userNameTO) throws SQLException, IOException, ClassNotFoundException {
        DbConnection connection = DbConnection.getInstance();
        String query;
        ResultSet rs = null;
        Statement stmt = null;

        logger.info("Creating Statement");

        try {
            stmt = connection.getConnection().createStatement();
        } catch (SQLException ex) {
            logger.log(Level.WARNING, ex.getMessage());
        }

        logger.info("Executing Query");

        try {
            query = "SELECT USERNAME FROM USERNAME where USERNAME=\"" + userNameTO.getUsername() + "\"";
            rs = stmt.executeQuery(query);

        } catch (SQLException ex) {
            logger.log(Level.WARNING, "Error executing query: {0}", ex.getMessage());
            return false;
        }

        logger.info("Recovering results");
        try {
            while (rs.next()) {
                logger.info("Recovering Dictonary table data");
                if (userNameTO.getUsername().toUpperCase().equals(rs.getString("USERNAME").toUpperCase())) {
                    return true;
                }
            }
        } catch (SQLException ex) {
            logger.log(Level.WARNING, "Error receiving data: {0} ", ex.getMessage());
            return false;
        }

        return false;
    }
}
