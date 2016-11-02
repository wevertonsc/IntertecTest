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
import com.intertec.test.model.DictonaryTO;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dictonary {

    private final static byte TRUE = 1;
    private final static byte FALSE = 0;
    private static final Logger logger = Logger.getLogger(Dictonary.class.getName());

    public byte insert(DictonaryTO dictonaryTO) throws SQLException, IOException, ClassNotFoundException {

        DbConnection connection = DbConnection.getInstance();

        String query;
        Statement stmt = connection.getConnection().createStatement();
        logger.info("Loading Database");

        try {
            logger.info("Executing Query");

            query = "insert into DICTONARY";
            query += "(ID, \"WORD\") ";
            query += "values(" + dictonaryTO.getId() + ",";
            query += "\'" + dictonaryTO.getWord() + "\')";
            logger.log(Level.INFO, "Consulta: {0}", query);
            stmt.executeUpdate(query);

        } catch (SQLException ex) {
            logger.log(Level.WARNING, ex.getMessage());
            return FALSE;
        }
        return TRUE;
    }

    public boolean restrictWords(DictonaryTO dictonaryTO) throws SQLException, IOException, ClassNotFoundException {
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
            query = "SELECT WORD FROM DICTONARY where WORD=\"" + dictonaryTO.getWord() + "\"";
            rs = stmt.executeQuery(query);

        } catch (SQLException ex) {
            logger.log(Level.WARNING, "Error executing query: {0}", ex.getMessage());
            return false;
        }

        logger.info("Recovering results");
        try {
            while (rs.next()) {
                logger.info("Recovering Dictonary table data");
                if (dictonaryTO.getWord().toUpperCase().equals(rs.getString("WORD").toUpperCase())) {
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
