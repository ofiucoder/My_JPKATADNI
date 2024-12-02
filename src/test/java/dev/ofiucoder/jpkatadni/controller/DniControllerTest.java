package dev.ofiucoder.jpkatadni.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import dev.ofiucoder.jpkatadni.models.DniModel;
import dev.ofiucoder.jpkatadni.view.DniView;

public class DniControllerTest {

    @Mock
    private DniModel model;

    @Mock
    private DniView view;

    private DniController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new DniController(model, view);
    }

    @Test
    void testRunWithValidInput() {

        int validDNI = 23571113;
        char expectedVerifyLetter = 'T';

        when(view.getDniInput()).thenReturn(validDNI);
        when(model.calculateVerifyLetter(validDNI)).thenReturn(expectedVerifyLetter);

        controller.run();

        verify(view, times(1)).getDniInput();
        verify(model, times(1)).calculateVerifyLetter(validDNI);
        verify(view, times(1)).displayNumberVL(validDNI, expectedVerifyLetter);
    }

    @Test
    void testInvalidInput() {
        int invalidDNI = -1;
        String errorMessage = "DNI number must have eight (8) digits.";
        int validDNI = 23571113;
        char expectedVerifyLetter = 'T';

        when(view.getDniInput())
                .thenReturn(invalidDNI)
                .thenReturn(validDNI);
        when(model.calculateVerifyLetter(invalidDNI)).thenThrow(new IllegalArgumentException(errorMessage));
        when(model.calculateVerifyLetter(validDNI)).thenReturn(expectedVerifyLetter);

        controller.run();

        verify(view, times(2)).getDniInput();
        verify(model, times(1)).calculateVerifyLetter(invalidDNI);
        verify(view, times(1)).displayError(errorMessage);
        verify(model, times(1)).calculateVerifyLetter(validDNI);
        verify(view, times(1)).displayNumberVL(validDNI, expectedVerifyLetter);
    }
}
