/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import entities.Luciernaga;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Luciano
 */
public class AlfaStep {
    
    public AlfaStep() {
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
    
    @Test
    public void probar(){
    
        HashMap<Character, Integer> comida = new HashMap<Character, Integer>();
        comida.put('S', 3 );
        comida.put('E', 7 );
        comida.put('N', 1 );
        comida.put('D', 2 );
        comida.put('M', 0 );
        comida.put('O', 4 );
        comida.put('R', 6 );
        comida.put('Y', 9 );

        Luciernaga prueba = new Luciernaga("Luciernaga 1", comida);
        
        //prueba.alfaStep(1, 1,{'S','E','N','D'},{'M','O','R','E'},{'M','O','N','E','Y'});
        
        assertEquals("Luciernaga",prueba.id);
        

    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
