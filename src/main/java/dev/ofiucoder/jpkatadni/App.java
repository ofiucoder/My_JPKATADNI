package dev.ofiucoder.jpkatadni;

import dev.ofiucoder.jpkatadni.controller.DniController;
import dev.ofiucoder.jpkatadni.models.DniModel;
import dev.ofiucoder.jpkatadni.view.DniView;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        DniModel model = new DniModel();
        DniView view = new DniView();
        DniController controller = new DniController(model, view);
        controller.run();
                
        }
    }

