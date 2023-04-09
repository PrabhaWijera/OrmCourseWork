package lk.ijse.prabhash.orm;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lk.ijse.prabhash.orm.entity.Student;
import lk.ijse.prabhash.orm.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.awt.*;
import java.io.IOException;

public class Appinitializer extends Application {
    public static void main(String[] args) {
        launch(args);


    }
    @Override
    public void start (Stage primaryStage) throws IOException {
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("view/DashBoardForm.fxml"))));
        primaryStage.setTitle("HostalManageMentSystem");
        primaryStage.show();
    }
}
