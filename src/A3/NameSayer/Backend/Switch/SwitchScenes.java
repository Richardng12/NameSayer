package A3.NameSayer.Backend.Switch;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SwitchScenes {
    private static SwitchScenes _switchScenes;

    // Here are a all the possible widths and heights the app uses
    public static final int largeWidth = 1336;
    public static final int largeHeight = 768;
    public static final int smallWidth = 700;
    public static final int smallHeight = 340;


    // Putting the singleton in singleton

    private SwitchScenes() {}
    public static SwitchScenes getInstance() {
        if (_switchScenes == null) {
            _switchScenes = new SwitchScenes();
        }

        return _switchScenes;
    }

    /**
     * This method switches scene to the required scene, width and height are required depending if you switch to smaller stage
     * or smaller stage.
     * @param sceneE the enum indicating what scene they want to switch to
     * @param e the action event
     * @param width the width of the next scene
     * @param height the height of the next scene
     * @throws IOException
     */
    public void switchScene(SwitchTo sceneE, ActionEvent e, int width, int height) throws IOException {
        FXMLLoader loader = sceneE.getLoader();
        Parent sParent = loader.load();
        Scene sScene = new Scene(sParent, width, height);
        Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
        window.setScene(sScene);
        window.show();
    }


}
