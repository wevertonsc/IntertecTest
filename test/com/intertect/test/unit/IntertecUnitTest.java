/*
 # ===================================================
 # Intertec
 # ***************************************************
 # Projeto: Intertec Test
 # Programmer: Weverton de Souza Castanho
 # Data: 11.01.2016
 # =================================================== 
 */
package com.intertect.test.unit;

import com.intertec.test.main.Intertec;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class IntertecUnitTest {
    
    public IntertecUnitTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // -- This code is correct, but it won't work because main class have -- exit(). -- command --
    // ------------------------ It's just to didatic verification --------------------------------
    // -------------------------------------------------------------------------------------------
    @Test
    public void intertec() {
        
        String[][] args = {{"john"},{"john"},{"john1"},{"john1"}};
        for(int i = 0; i < 4; i++){
            Intertec.main(args[i]);
        }        
    }
}
