/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jerom
 */
public class DbAgrioteSP2Test {
        
    @Test
    public void testGetConnection() throws Exception {
    System.out.println("getConnection");
    Connection result = DbAgrioteSP2.getConnection();
    assertNotNull(result);
  }
    
}
