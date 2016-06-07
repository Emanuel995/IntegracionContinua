/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.swarm.firefly.bean;

import entities.Luciernaga;
import javax.faces.event.ActionEvent;
import java.io.Serializable;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Luciano
 */
@ManagedBean(name="enjambre")
@RequestScoped
public class Enjambre implements Serializable{
    		
        //Entrada del problema		
        private	String operador1;
	private String operador2;
	private String  resultado;

    public String getOperador1() {
        return operador1;
    }
    public void setOperador1(String operador1) {
        this.operador1 = operador1;
    }
    public String getOperador2() {
        return operador2;
    }
    public void setOperador2(String operador2) {
        this.operador2 = operador2;
    }
    public String getResultado() {
        return resultado;
    }
    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

@PostConstruct
    public void init(){
    }
    
    public void procesar(){    
        
        char[] sumando1 = this.operador1.toCharArray();
	char[] sumando2 = this.operador2.toCharArray();
	char[] total = this.resultado.toCharArray();
		
	sumando1 = reverso(sumando1);	//char[]
	sumando2 = reverso(sumando2);	//char[]
	total = reverso(total);         //char[]
				
        //Cantidad de letras distintas que contiene el problema criptoaritmetico
        HashMap<Character, Integer> letras = getLetras(operador1, operador2, resultado);

        //Muestra todos los caracteres distintos ingresados
        //verLetras(letras);
		    		
        //Creación de la poblacion de luciernagas		
	Luciernaga[] swarm = poblacion(50,letras);
		
        //Comparar luciernagas teniendo en cuenta el brillo y el atractivo de cada una
	int iteraciones = 0;
	while(iteraciones <4){
            iteraciones++;
            for (int i=0; i < swarm.length; i++){
		for (int j=0; j < swarm.length; j++){
                    if ((i!=j)&&(swarm[i].intensidad(sumando1, sumando2, total)!=0)){
			//System.out.println("Iteracion: " + iteraciones);
			swarm[i].setIteracion(iteraciones);
			if (swarm[i].atractivo(swarm[j], sumando1, sumando2, total)){
                            //movimiento aleatorio
                            swarm[i].alfaStep();
			}else{
                            //acercar luciernaga i a j
                            swarm[i].desplazamiento(swarm[j]);
                            if(swarm[i].intensidad(sumando1, sumando2, total)!=0){
				swarm[i].alfaStep();
                            }
			}
                    }
		}
            }
	}

        //Mostrar el valor de todas las luciernagas al finalizar todo
        /*		
            for(int z = 0 ; z < swarm.length ; z++){
        	System.out.println(swarm[z].id);
		System.out.println(swarm[z].intensidad(sumando1, sumando2, total));
		verLetras(swarm[z].elementos);
            }
        */		

        resultados(swarm, sumando1, sumando2, total);
    }

//Determinacion del dominio del problema ----> Cantidad de letras distintas que posee el problema criptoaritmetico
    public HashMap<Character, Integer> getLetras(String op1, String op2, String op3){
	op1 = op1 + op2 + op3;
        HashMap<Character, Integer> caracteres = new HashMap<Character, Integer>();
        for ( int i = 0; i < op1.length(); ++i ){
            caracteres.put(op1.charAt(i), i);
        }
        return caracteres;
    }
	
//Mostrar las distintas letras que conforman el problema	
    public void verLetras(HashMap<Character,Integer> caracteres){
        Iterator it = caracteres.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry)it.next();
            System.out.println(e.getKey() + " " + e.getValue());
	}    
    }
	
//Mapeador de Caracteres con Numeros ----> Para generar la aleatoriedad de las luciernagas
    public HashMap<Character,Integer> generador(HashMap<Character, Integer> checkSum){
	HashMap<Character, Integer> mapeador = new HashMap<Character,Integer>();
	Random valor = new Random();
        Iterator it = checkSum.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry e = (Map.Entry)it.next();
            int valorcito = valor.nextInt(10);
            while(mapeador.containsValue(valorcito)){
		valorcito = valor.nextInt(10);
            }
            mapeador.put((char)e.getKey(), valorcito);			
	}
//Solo para ver como se fueron asignador las letras a las posiciones
	    //System.out.println("Esta es una Luciernaga");
	    //verLetras(mapeador);		
	return mapeador; 
    }
	
//Generación de la Población de Luciernagas
    public Luciernaga[] poblacion(int habitantes, HashMap<Character, Integer> letras ){
	Luciernaga[] enjambre = new Luciernaga[habitantes];
	for (int h =0; h < enjambre.length; h++) {
            String nombre = "Luciernaga-" + h;
            Luciernaga unaLuciernaga = new Luciernaga(nombre, generador(letras));
            enjambre[h] = unaLuciernaga;
        }
	return enjambre;
    }

    public char[] reverso(char[] unOperador){
	for (int i = 0; i < unOperador.length / 2; i++) { 
            char temp = unOperador[i];
            unOperador[i] = unOperador[unOperador.length - 1 - i]; 
            unOperador[unOperador.length - 1 - i] = temp; 
        }
	return unOperador;
    }

    public ArrayList<Character> convertidor(char[] unVector){
	ArrayList<Character> resultado = new ArrayList<Character>();
	for (char unChar:unVector){
            resultado.add(unChar);
	}
            return resultado;
    }
	
    public void recorrerida(Luciernaga[] unEnjambre){
	ArrayList<Luciernaga> enjambre = new ArrayList<Luciernaga>();
	for(Luciernaga unaLuciernaga:unEnjambre){
            if(!enjambre.contains(unaLuciernaga.elementos)){
                enjambre.add(unaLuciernaga);
            }
	}
    }
	
    public void resultados(Luciernaga[] unEnjambre, char[] operador1, char[] operador2, char[] resultado){
	int cont = 0;
	for (Luciernaga unaLuciernaga:unEnjambre){
            if ((unaLuciernaga.intensidad(operador1, operador2, resultado) == 0)){
		cont++;
		System.out.println(unaLuciernaga.toString() + " Iteracion: " + unaLuciernaga.getIteracion() + " " + unaLuciernaga.id);
            }
	}
	System.out.println("Luciernagas optimas: " + cont);
    }

}