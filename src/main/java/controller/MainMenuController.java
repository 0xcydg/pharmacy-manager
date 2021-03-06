package controller;

import entity.Produit;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.ProduitDAO;

import java.io.IOException;
import java.net.URL;
import java.util.*;

public class MainMenuController {
    public AnchorPane parent;
    public Button stockButton;
    public Button fournisseursButton;
    public Button clientsButton;
    public Button cmdsButton;
    public Button ventesButton;
    public Button aboutButton;
    public Button menuButton;

    public void showStockView() throws IOException {
        setSelectedButtonEffect("stock");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/stock_view.fxml"));
        Parent node = loader.load();
        parent.getChildren().setAll(node);
    }

    public void showFournisseursView() throws IOException {
        setSelectedButtonEffect("fournisseurs");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fournisseurs_view.fxml"));
        Parent node = loader.load();
        parent.getChildren().setAll(node);
    }

    public void showClientsView() throws IOException {
        setSelectedButtonEffect("clients");
        menuButton.setStyle("-fx-background-color: white");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/clients_view.fxml"));
        Parent node = loader.load();
        parent.getChildren().setAll(node);
    }

    public void showCmdsView() throws IOException {
        setSelectedButtonEffect("cmds");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/commandes_view.fxml"));
        Parent node = loader.load();
        parent.getChildren().setAll(node);
    }

    public void showVentesView() throws IOException {
        setSelectedButtonEffect("ventes");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ventes_view.fxml"));
        Parent node = loader.load();
        parent.getChildren().setAll(node);
    }

    public void showAboutView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/about_view.fxml"));
        Parent node = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(node));
        stage.setTitle("A propos de l'application");
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.showAndWait();
    }

    public void setSelectedButtonEffect(String menuName) {
        List<Button> menuButtons = Arrays.asList(stockButton, fournisseursButton, clientsButton, cmdsButton, ventesButton, aboutButton, menuButton);
        menuButtons.forEach(button -> {
            if(button.getId().equals(menuName + "Button")) {
                button.setStyle("-fx-background-color: #6db8c2");
            } else {
                button.setStyle("-fx-background-color: white");
            }
        });
    }

}
