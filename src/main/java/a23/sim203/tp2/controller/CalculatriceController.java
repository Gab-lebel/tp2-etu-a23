package a23.sim203.tp2.controller;

import a23.sim203.tp2.modele.MoteurCalcul;
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

}

