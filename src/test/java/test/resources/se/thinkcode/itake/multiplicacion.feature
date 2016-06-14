Feature: Multiplicar dos numeros

    Scenario: Multiplicar dos numeros positivos
        Given Tengo los numeros 5 y 2
        When multiplicando los dos numeros en la calculadora
        Then El resultado es 10

    Scenario: Multiplicar dos numeros negativos
        Given Tengo los numeros -5 y -2
        When multiplicando los dos numeros en la calculadora
        Then El resultado es 10

    Scenario: Multiplicar un numero positivo y un numero negativo
        Given Tengo los numeros 5 y -2
        When multiplicando los dos numeros en la calculadora
        Then El resultado es -10