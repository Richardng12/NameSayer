package A3.NameSayer;

import A3.NameSayer.Backend.Databases.Database;
import A3.NameSayer.Backend.Databases.UserDatabase;
import A3.NameSayer.Backend.RatingSystem.TextFileRW;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    public static long startTime = System.nanoTime();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load database and textfiles
        TextFileRW.getInstance();
        Database.getInstance();
        UserDatabase.getInstance().openMap();
        TextFileRW.getInstance().makeTimeFile();
        TextFileRW.getInstance().makeTempFolders();

        // Load fonts
        Font.loadFont(getClass().getResourceAsStream("/A3/NameSayer/Frontend/Resources/Fonts/yugothil.ttf"), 65);
        Font.loadFont(getClass().getResourceAsStream("/A3/NameSayer/Frontend/Resources/Fonts/Cambria.ttf"), 72);

        // Set main stage
        Parent root = FXMLLoader.load(getClass().getResource("Frontend/FXML/MainMenu.fxml"));
        primaryStage.setTitle("Name Sayer");
        primaryStage.setResizable(false);
        primaryStage.sizeToScene();
        primaryStage.setScene(new Scene(root, 1336, 768));
        primaryStage.setOnCloseRequest(e -> {
            e.consume();
            UserDatabase.getInstance().saveMap();
            TextFileRW.getInstance().saveTime();
            System.exit(0);
        });
        primaryStage.show();
    }
}
