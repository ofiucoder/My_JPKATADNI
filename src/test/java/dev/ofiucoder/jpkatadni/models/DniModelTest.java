package dev.ofiucoder.jpkatadni.models;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DniModelTest {

    private DniModel model;

    @BeforeEach
    void setup() {
        model = new DniModel();
    }


    @Test
    void testCalculateVerifyLetter() {
        assertThat(model.calculateVerifyLetter(23571113), is('T'));
        assertThat(model.calculateVerifyLetter(12345678), is('Z'));
        assertThat(model.calculateVerifyLetter(99999999), is('R'));        

    }

    @Test
    void testcalculateVerifyLetterNegativeInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> model.calculateVerifyLetter(-1));
        assertThat(exception.getMessage(), is("Invalid input or data missmach. Please enter a valid numeric value."));
    }
}
