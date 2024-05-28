package fr.formation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatriceTest {
    private Calculatrice calc;

    @BeforeEach
    public void beforeEach() {
        this.calc = new Calculatrice();
    }

    @Test
    void shouldAdditionReturn10When4And6() {
        // given
        int a = 4;
        int b = 6;

        // when
        int result = this.calc.addition(a, b);

        // then
        Assertions.assertEquals(10, result);
    }

    @Test
    void shouldAdditionReturn25When10And15() {
        // given
        int a = 10;
        int b = 15;

        // when
        int result = this.calc.addition(a, b);

        // then
        Assertions.assertEquals(25, result);
    }

    @ParameterizedTest
    @CsvSource({ "10,5,15", "8,1,9", "-5,5,0", "7,-7,0" })
    void shouldAdditionReturnsGoodResults(int a, int b, int expected) {
        // given

        // when
        int result = this.calc.addition(a, b);

        // then
        Assertions.assertEquals(expected, result);
    }
}
