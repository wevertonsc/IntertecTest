/*
 # ===================================================
 # Intertec
 # ***************************************************
 # Projeto: Intertec Test
 # Programmer: Weverton de Souza Castanho
 # Data: 11.01.2016
 # =================================================== 
 */
package com.intertec.test.connection;


import com.intertec.test.model.PropertiesTO;
import com.intertec.test.properties.PropertiesUtil;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author weverton
 */
public class DbConnection {

    private static final Logger logger = Logger.getLogger(DbConnection.class.getName());
    private static DbConnection instance;
    private Connection connection;
        
    public static synchronized DbConnection getInstance() throws IOException, ClassNotFoundException {
        if (instance == null) {
            instance = new DbConnection();
        }
        return instance;
    }
       
    public DbConnection() throws ClassNotFoundException, IOException {

        PropertiesTO props = PropertiesUtil.getInstance().getPropertiesTO();
        this.connection = null;

        try {
            Class.forName(props.getJdbcDriver());
            this.connection = DriverManager.getConnection(props.getDatabaseUrl(),
                    props.getDatabaseUser(),
                    props.getDatabasePassword());
        } catch (ClassNotFoundException | SQLException cnf) {
            logger.log(Level.SEVERE, cnf.getMessage());
        }
        
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
