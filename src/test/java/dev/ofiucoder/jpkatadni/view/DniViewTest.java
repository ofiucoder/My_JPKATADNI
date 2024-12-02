package dev.ofiucoder.jpkatadni.view;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.InputStream;
import java.io.PrintStream;

public class DniViewTest {
    private DniView view;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        view = new DniView();
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    void testDisplayNumberVL() {
        view.displayNumberVL(23571113, 'T');

        String output = outputStream.toString();
        assertThat(output, containsString("Your DNI is: 23571113-T"));

    }
}
