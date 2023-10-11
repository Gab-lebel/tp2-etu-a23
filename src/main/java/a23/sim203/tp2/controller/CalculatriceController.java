package a23.sim203.tp2.controller;

import a23.sim203.tp2.modele.MoteurCalcul;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CalculatriceController {

    private MoteurCalcul moteurCalcul = new MoteurCalcul();

    @FXML
    private BorderPane BorderPane;

    @FXML
    private MenuBar MenuBar;

    @FXML
    private MenuItem aProposMenuItem;

    @FXML
    private Button additionnerButton;

    @FXML
    private TextField affichageTextField;

    @FXML
    private Menu aideMenu;

    @FXML
    private Button ajouteButton;

    @FXML
    private Menu assistanceMenu;

    @FXML
    private CheckMenuItem assistanceVisuelle;

    @FXML
    private GridPane calculatricegridPane;

    @FXML
    private Button changementDeSigneButton;

    @FXML
    private Button cinqButton;

    @FXML
    private Button deuxButton;

    @FXML
    private Button diviserButton;

    @FXML
    private Button egalButton;

    @FXML
    private HBox equationHbox;

    @FXML
    private Label equationLabel;

    @FXML
    private ListView<?> equationsListViews;

    @FXML
    private VBox equationsVbox;

    @FXML
    private Button foisButton;

    @FXML
    private Button huitButton;

    @FXML
    private Button lireEtEcrireButton;

    @FXML
    private Button neufButton;

    @FXML
    private Button parentheseDroiteButton;

    @FXML
    private Button parenthèseGaucheButton;

    @FXML
    private Button pointButton;

    @FXML
    private Button quatreButton;

    @FXML
    private Button retierButton;

    @FXML
    private Button retierToutButton;

    @FXML
    private Button septButton;

    @FXML
    private Button sixButton;

    @FXML
    private Button soustractionButton;

    @FXML
    private Button supprimeSelectionButton;

    @FXML
    private Button troisButton;

    @FXML
    private Button unButton;

    @FXML
    private Button variableEtValeurButton;

    @FXML
    private HBox variablesHbox;

    @FXML
    private Label variablesLabel;

    @FXML
    private ListView<?> variablesListViews;

    @FXML
    private VBox variablesVbox;

    @FXML
    private Button zeroButton;

    @FXML
    void ajoutajouterCaracterePlus(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + "+");
    }

    @FXML
    void ajouterCaractere1(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + "1");
    }

    @FXML
    void ajouterCaractere2(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + "2");
    }

    @FXML
    void ajouterCaractere3(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + "3");
    }

    @FXML
    void ajouterCaractere4(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + "4");
    }

    @FXML
    void ajouterCaractere5(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + "5");
    }

    @FXML
    void ajouterCaractere6(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + "6");
    }

    @FXML
    void ajouterCaractere7(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + "7");
    }

    @FXML
    void ajouterCaractere8(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + "8");
    }

    @FXML
    void ajouterCaractere9(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + "9");
    }

    @FXML
    void ajouterCaractereDiviser(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + "/");
    }

    @FXML
    void ajouterCaractereEgal(ActionEvent event) {
        //todo déclencher le dialogue d'erreur
        moteurCalcul.calcule(affichageTextField.getText());
    }

    @FXML
    void ajouterCaractereFois(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + "*");
    }

    @FXML
    void ajouterCaractereMoin(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + "-");
    }

    @FXML
    void ajouterCaractereZero(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + "0");
    }

    @FXML
    void ajouterParentheseDroite(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + "(");
    }

    @FXML
    void ajouterParentheseGauche(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + ")");
    }

    @FXML
    void ajouterUneVirgule(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + ",");
    }

    @FXML
    void changerLeSigne(ActionEvent event) {
        int i;
        String avantEgal = null;
        String apresEgal = null;
        String signeChangher;
        i = affichageTextField.getText().indexOf('=');
        for (int j = 0; j <= i; j++) {
            avantEgal += affichageTextField.getText().charAt(j);
        }
        for (int k = i; k < affichageTextField.getText().length(); k++) {
            apresEgal += affichageTextField.getText().charAt(k);
        }
        if (apresEgal.charAt(0) != '-') {
            apresEgal.substring(0);
            signeChangher = "-" + apresEgal;
        } else {
            apresEgal.substring(0);
            signeChangher = "+" + apresEgal;
        }
        affichageTextField.setText(avantEgal + signeChangher);
    }

    @FXML
    void effacerDernierCaractere(ActionEvent event) {
        affichageTextField.getText().substring(0,affichageTextField.getText().length() -1);
    }

    @FXML
    void effacerToutLesCaractere(ActionEvent event) {
        affichageTextField.setText("");
    }
}


