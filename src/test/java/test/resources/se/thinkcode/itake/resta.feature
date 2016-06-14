Feature: Restar dos numeros

    Scenario: Restar dos numeros positivos
        Given Tengo los numeros 5 y 2
        When multiplicando los dos numeros en la calculadora
        Then El resultado es 10

    Scenario: Restar dos numeros negativos
        Given Tengo los numeros -5 y -2
        When multiplicando los dos numeros en la calculadora
        Then El resultado es -7

    Scenario: Restar un numero positivo y un numero negativo
        Given Tengo los numeros 5 y -2
        When multiplicando los dos numeros en la calculadora
        Then El resultado es 7
