Feature: Calculadora

    Scenario: Sumar dos numeros positivos
        Given Tengo los numeros 2 y 5
        When Sumando los dos numeros en la calculadora
        Then El resultado es 7

    Scenario: Sumar dos numeros negativos
        Given Tengo los numeros 5 y 2
        When restando los dos numeros en la calculadora
        Then El resultado es -7

    Scenario: Sumar un numero positivo y uno negativo
        Given Tengo los numeros 5 y -2
        When multiplicando los dos numeros en la calculadora
        Then El resultado es 7

    
