/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.java.se.thinkcode.itake;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.java.se.thinkcode.itake.Calculadora;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Luciano
 */
public class StepDefinitions {

    private Calculadora calculadora;
    private int num1;
    private int num2;

        @Given("^Tengo los numeros (\\d+) y (\\d+)$")
        public void tengo_los_numeros_y(int numero1,int numero2) throws Throwable {
            num1 = numero1;
            num2 = numero2;
        }

        @When("^Sumando los dos numeros en la calculadora$")
        public void sumando_los_dos_numeros_en_la_calculadora() throws Throwable {
            calculadora = new Calculadora();
        }

        @Then("^El resultado es (\\d+)$")
        public void el_resultado_es(int resultado) throws Throwable {
            
            assertEquals(resultado, calculadora.sumar(num1, num2));
        }    
    
}
