package com.example.guichetautomatique;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    GestionnaireGuichet unGestionnaireGuichet = new GestionnaireGuichet();

    @FXML
    private ImageView sceneRetour;
    @FXML
    private Button sceneDepot;

    @FXML
    private Button scenePayerFacture;

    @FXML
    private ImageView sceneQuitter;

    @FXML
    private Button sceneRetrait;

    @FXML
    private Button sceneTransfert;

    @FXML
    private Button sceneConnecter;
    @FXML
    private TextField idCodeClient;

    @FXML
    private TextField idNIP;
    @FXML
    private Button sceneCreerClient;

    @FXML
    private TextField intCodeClient;

    @FXML
    private TextField textCourriel;

    @FXML
    private TextField intNIP;

    @FXML
    private TextField textNom;

    @FXML
    private TextField textPrenom;

    @FXML
    private TextField textTelephone;

    @FXML
    void creerClientClick(ActionEvent event) {
        if (textNom.getText().trim() != "" && textPrenom.getText().trim() != "" && textTelephone.getText().trim() != "" && intCodeClient.getText().trim() != "" && textCourriel.getText().trim() != "" && intNIP.getText().trim() != ""){
            try {
                int codeClient = Integer.parseInt(intCodeClient.getText().trim());
                String nom = textNom.getText().trim();
                String prenom = textPrenom.getText().trim();
                String telephone = textTelephone.getText().trim();
                String courriel = textCourriel.getText().trim();
                int nip = Integer.parseInt(intNIP.getText().trim());


            } catch (NumberFormatException e){
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Mauvais format!");
                alert.setHeaderText(null);
                alert.setContentText("Votre NIP ou votre code client doit être un entier.");
                alert.showAndWait();
            }

        }
    }
    @FXML
    void connecterClick(ActionEvent event) throws IOException {
        Scene first = null;
        Parent root = null;
        int codeClient = Integer.parseInt(idCodeClient.getText());
        int nip = Integer.parseInt(idNIP.getText());
        if (codeClient  == 1234 && nip == 22400){
            root = FXMLLoader.load(getClass().getResource("pageClient.fxml"));
            first = sceneConnecter.getScene();
            first.setRoot(root);
            ((Stage)first.getWindow()).setTitle("Accès Client");
        }
        else if (codeClient  == 0000 && nip == 0000){
            root = FXMLLoader.load(getClass().getResource("pageAdmin.fxml"));
            first = sceneConnecter.getScene();
            first.setRoot(root);
            ((Stage)first.getWindow()).setTitle("Accès Administrateur");
        }
        else{
            System.out.println(idCodeClient.getText() + " " + idNIP.getText());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Mauvaise authentification!");
            alert.setHeaderText(null);
            alert.setContentText("Votre NIP ou votre code client ne correspond pas.");
            alert.showAndWait();
        }
    }

    @FXML
    void quitterClick(MouseEvent event) throws IOException {
        Scene first = null;
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource("pageLogin.fxml"));
        first = sceneQuitter.getScene();
        first.setRoot(root);
        ((Stage)first.getWindow()).setTitle("Guichet Automatique");
    }

    @FXML
    void depotClick(ActionEvent event) throws IOException {
        Scene first = null;
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource("pageDepot.fxml"));
        first = sceneDepot.getScene();
        first.setRoot(root);
        ((Stage)first.getWindow()).setTitle("Dépot");
    }

    @FXML
    void retourClick(MouseEvent event) throws IOException {
        Scene first = null;
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource("pageClient.fxml"));
        first = sceneRetour.getScene();
        first.setRoot(root);
        ((Stage)first.getWindow()).setTitle("Accès Client");
    }

    @FXML
    void payerFactureClick(ActionEvent event) throws IOException {
        Scene first = null;
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource("pagePayerFacture.fxml"));
        first = scenePayerFacture.getScene();
        first.setRoot(root);
        ((Stage)first.getWindow()).setTitle("Paiement de facture");
    }

    @FXML
    void retraitClick(ActionEvent event) throws IOException {
        Scene first = null;
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource("pageRetrait.fxml"));
        first = sceneRetrait.getScene();
        first.setRoot(root);
        ((Stage)first.getWindow()).setTitle("Retrait");
    }

    @FXML
    void transfertClick(ActionEvent event) throws IOException {
        Scene first = null;
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource("pageTransfert.fxml"));
        first = sceneTransfert.getScene();
        first.setRoot(root);
        ((Stage)first.getWindow()).setTitle("Transfert");
    }

    @Override
    public void initialize(URL location, ResourceBundle resourceBundle) {

    }
}