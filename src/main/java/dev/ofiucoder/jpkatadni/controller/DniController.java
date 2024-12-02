package dev.ofiucoder.jpkatadni.controller;

import dev.ofiucoder.jpkatadni.models.DniModel;
import dev.ofiucoder.jpkatadni.view.DniView;

public class DniController {

    private final DniModel model;
    private final DniView view;

    public DniController(DniModel model, DniView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        int dniNumber = -1;

        while (true) {
            dniNumber = view.getDniInput();
            try {
                char verifyLetter = model.calculateVerifyLetter(dniNumber);
                view.displayNumberVL(dniNumber, verifyLetter);
                break;
            } catch (IllegalArgumentException e) {
                view.displayError(e.getMessage());
            }
        }
    }

}
