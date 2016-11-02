/*
 # ===================================================
 # Intertec
 # ***************************************************
 # Projeto: Intertec Test
 # Programmer: Weverton de Souza Castanho
 # Data: 11.01.2016
 # =================================================== 
 */
package com.intertec.test.properties;

import com.intertec.test.model.PropertiesTO;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

    private static PropertiesUtil instance;
    private PropertiesTO propertiesTO;

    public static synchronized PropertiesUtil getInstance() throws IOException {
        if (instance == null) {
            instance = new PropertiesUtil();
        }
        return instance;
    }

    public PropertiesUtil() throws IOException {

        PropertiesTO propertiesTO = new PropertiesTO();
        Properties prop = new Properties();
        Constants constantes = new Constants();
        try (InputStream inFile = new FileInputStream(
                (new File(constantes.PROPERTIES_FILE)).getAbsoluteFile())) {
            prop.load(inFile);
        }
        // -- Load properties from file --
        propertiesTO.setDatabaseUrl(prop.getProperty("DatabaseUrl"));
        propertiesTO.setJdbcDriver(prop.getProperty("JdbcDriver"));
        propertiesTO.setDatabaseUser(prop.getProperty("DatabaseUser"));
        propertiesTO.setDatabasePassword(prop.getProperty("DatabasePassword"));

        this.propertiesTO = propertiesTO;
    }

    public PropertiesTO getPropertiesTO() {
        return propertiesTO;
    }

    public void setPropertiesTO(PropertiesTO propertiesTO) {
        this.propertiesTO = propertiesTO;
    }

}
