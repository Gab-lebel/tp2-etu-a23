package a23.sim203.tp2.controller;

import a23.sim203.tp2.modele.MoteurCalcul;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class CalculatriceController {
    /**
     * Instancie une variable de la classe MoteurCalcul
     */
    private MoteurCalcul moteurCalcul = new MoteurCalcul();
    /**
     * Crée la racine du projet dans un BorderPane et GridpPane a gauche, variableVbox a droite,
     * equationVbox en bas et MenuBar en haut
     */
    @FXML
    private BorderPane BorderPane;
    /**
     * Crée une bar de Menu
     */
    @FXML
    private MenuBar MenuBar;
    /**
     * Crée un MenuItem "A propos" dans le menu "Aide"
     */
    @FXML
    private MenuItem aProposMenuItem;
    /**
     * Crée le bouton sur la calculatrice répresentant '+'
     */
    @FXML
    private Button additionnerButton;
    /**
     * Crée le TextField dans la calculatrice
     */
    @FXML
    private TextField affichageTextField;
    /**
     * Crée un menu "Aide" dans Menubar
     */
    @FXML
    private Menu aideMenu;
    /**
     * Crée le bouton "ajoute" dans equationHbox
     */
    @FXML
    private Button ajouteButton;
    /**
     * Crée un menue "Assistance" dans MenuBar
     */
    @FXML
    private Menu assistanceMenu;
    /**
     * Crée un menu appeler "Assistance visuelle" dans assistanceMenu
     */
    @FXML
    private CheckMenuItem assistanceVisuelle;
    /**
     * Crée le GridPane contenant tout les boutons nécessaire a la calculatrice et le TextField
     */
    @FXML
    private GridPane calculatricegridPane;
    /**
     * Crée le bouton sur la calculatrice répresentant '+/-'
     */
    @FXML
    private Button changementDeSigneButton;
    /**
     * Crée le bouton sur la calculatrice répresentant '5'
     */
    @FXML
    private Button cinqButton;
    /**
     * Crée le bouton sur la calculatrice répresentant '3'
     */
    @FXML
    private Button deuxButton;
    /**
     * Crée le bouton sur la calculatrice répresentant '-'
     */
    @FXML
    private Button diviserButton;
    /**
     * Crée le bouton sur la calculatrice répresentant '='
     */
    @FXML
    private Button egalButton;
    /**
     * Crée une Hbox contenant le bouton "ajoute" et "supprimer selection"
     */
    @FXML
    private HBox equationHbox;
    /**
     * Crée un Label contenant "Équations"
     */
    @FXML
    private Label equationLabel;
    /**
     * Crée un ListeViews qui contiendra les équation
     */
    @FXML
    private ListView<?> equationsListViews;
    /**
     * Crée Une Vbox contenant equationLabel equationListViews et equationHbox
     */
    @FXML
    private VBox equationsVbox;
    /**
     * Crée le bouton sur la calculatrice répresentant '*'
     */
    @FXML
    private Button foisButton;
    /**
     * Crée le bouton sur la calculatrice répresentant '9'
     */
    @FXML
    private Button huitButton;
    /**
     * Crée le bouton "lire"/"écrire" dans VariablesHbox
     */
    @FXML
    private Button lireEtEcrireButton;
    /**
     * Crée le bouton sur la calculatrice répresentant '9'
     */
    @FXML
    private Button neufButton;
    /**
     * Crée le bouton sur la calculatrice répresentant ')'
     */
    @FXML
    private Button parentheseDroiteButton;
    /**
     * Crée le bouton sur la calculatrice répresentant '(1)'
     */
    @FXML
    private Button parenthèseGaucheButton;
    /**
     * Crée le bouton sur la calculatrice répresentant ','
     */
    @FXML
    private Button pointButton;
    /**
     * Crée le bouton sur la calculatrice répresentant '4'
     */
    @FXML
    private Button quatreButton;
    /**
     * Crée le bouton sur la calculatrice répresentant '<-'
     */
    @FXML
    private Button retierButton;
    /**
     * Crée le bouton sur la calculatrice répresentant 'X'
     */
    @FXML
    private Button retierToutButton;
    /**
     * Crée le bouton sur la calculatrice répresentant '7'
     */
    @FXML
    private Button septButton;
    /**
     * Crée le bouton sur la calculatrice répresentant '6'
     */
    @FXML
    private Button sixButton;
    /**
     * Crée le bouton sur la calculatrice répresentant '-'
     */
    @FXML
    private Button soustractionButton;
    /**
     * Crée le bouton supprimer selection dans EquationHbox
     */
    @FXML
    private Button supprimeSelectionButton;
    /**
     * Crée le bouton sur la calculatrice répresentant '3'
     */
    @FXML
    private Button troisButton;
    /**
     * Crée le bouton sur la calculatrice répresentant '1'
     */
    @FXML
    private Button unButton;
    /**
     * Crée le bouton "Variable"/"Valeur"
     */

    @FXML
    private Button variableEtValeurButton;
    /**
     * Crée une Hbox contenant les boutons lire/écrire et variable/valeur
     */
    @FXML
    private HBox variablesHbox;
    /**
     * Crée le Label contenant "Variables"
     */
    @FXML
    private Label variablesLabel;
    /**
     * Crée une ListViews contenant les variables
     */
    @FXML
    private ListView<?> variablesListViews;
    /**
     * Crée la Vbox contenant variableLabel, variablesListViews et variablesHbox
     */
    @FXML
    private VBox variablesVbox;
    /**
     * Crée le bouton '0'
     */
    @FXML
    private Button zeroButton;
    /**
     * Ajouter le caractère '+' a la fin de la String du Textfield
     * @param event
     */
    @FXML
    void ajoutajouterCaracterePlus(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + "+");
    }
    /**
     * Ajouter le caractère/chiffre '1' a la fin de la String du Textfield
     * @param event
     */
    @FXML
    void ajouterCaractere1(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + "1");
    }
    /**
     * Ajouter le caractère/chiffre '2' a la fin de la String du Textfield
     * @param event
     */
    @FXML
    void ajouterCaractere2(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + "2");
    }
    /**
     * Ajouter le caractère/chiffre '3' a la fin de la String du Textfield
     * @param event
     */
    @FXML
    void ajouterCaractere3(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + "3");
    }
    /**
     * Ajouter le caractère/chiffre '4' a la fin de la String du Textfield
     * @param event
     */
    @FXML
    void ajouterCaractere4(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + "4");
    }
    /**
     * Ajouter le caractère/chiffre '5' a la fin de la String du Textfield
     * @param event
     */
    @FXML
    void ajouterCaractere5(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + "5");
    }
    /**
     * Ajouter le caractère/chiffre '6' a la fin de la String du Textfield
     * @param event
     */
    @FXML
    void ajouterCaractere6(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + "6");
    }
    /**
     * Ajouter le caractère/chiffre '7' a la fin de la String du Textfield
     * @param event
     */
    @FXML
    void ajouterCaractere7(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + "7");
    }
    /**
     * Ajouter le caractère/chiffre '8' a la fin de la String du Textfield
     * @param event
     */
    @FXML
    void ajouterCaractere8(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + "8");
    }

    @FXML
    void ajouterCaractere9(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + "9");
    }
    /**
     * Ajouter le caractère '/' a la fin de la String du Textfield
     * @param event
     */
    @FXML
    void ajouterCaractereDiviser(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + "/");
    }

    /**
     * Calcule la formule du TextField et toutes ses variables
     * Si le moteur de calcule ne peut pas effectuer le calcul, il retourne "NaN" et la méthode montre un dialog
     * Si le calcule est possible le contenue du TextField est remplacé par la réponse double convertie en String
     * @param event
     */
    @FXML
    void ajouterCaractereEgal(ActionEvent event) {
        double reponseCalcule = moteurCalcul.calcule(affichageTextField.getText());
        //todo ajouter le calcul dans les list
        if(String.valueOf(reponseCalcule).equals("NaN")){
            Alert dialog = new Alert(Alert.AlertType.CONFIRMATION);
            dialog.setTitle("Calculateur Avancé");
            dialog.setHeaderText("Expression Invalide");
            dialog.setContentText("L'expression saisie ne peut être calculée");
        }else{
            affichageTextField.setText(String.valueOf(reponseCalcule));
        }

//test
//        if (affichageTextField.getText().equals("NaN")) {
//            Alert dialog = new Alert(Alert.AlertType.WARNING);
//            dialog.setTitle("Calculateur a vancé");
//            dialog.setHeaderText("Expression Invalide");
//            dialog.setContentText("L'expression saisie ne peut être calculée");
//            dialog.showAndWait();
//        }
    }

    /**
     * Ajouter le caractère '*' a la fin de la String du Textfield
     * @param event
     */
    @FXML
    void ajouterCaractereFois(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + "*");
    }
    /**
     * Ajouter le caractère '-' a la fin de la String du Textfield
     * @param event
     */
    @FXML
    void ajouterCaractereMoin(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + "-");
    }
    /**
     * Ajouter le caractère/chiffre '0' a la fin de la String du Textfield
     * @param event
     */
    @FXML
    void ajouterCaractereZero(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + "0");
    }
    /**
     * Ajouter le caractère '(' a la fin de la String du Textfield
     * @param event
     */
    @FXML
    void ajouterParentheseDroite(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + "(");
    }
    /**
     * Ajouter le caractère ')' a la fin de la String du Textfield
     * @param event
     */
    @FXML
    void ajouterParentheseGauche(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + ")");
    }
    /**
     * Ajouter le caractère ',' a la fin de la String du Textfield
     * @param event
     */
    @FXML
    void ajouterUneVirgule(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + ",");
    }

    /**
     * Change le signe du premier caractère le egal par un moin ou un +, s'il n'y a pas signe la méthode met un -
     * La méthode sépare la string de affichageTextField en deux soit les carcatere avant le egal,inclus, et tout ce qui a apres le égal
     * La string signeChanger est la string apresEgal avec le signe changer
     * Finalement la méthode recrée la string du textField avec avantEgal et signeChanger
     *
     * @param event
     */
    @FXML
    void changerLeSigne(ActionEvent event) {
        int i;
        String avantEgal = "";
        String apresEgal = "";
        String signeChanger;
        i = affichageTextField.getText().indexOf('=');
        for (int j = 0; j <= i; j++) {
            avantEgal += affichageTextField.getText().charAt(j);
        }
        for (int k = i + 1; k < affichageTextField.getText().length(); k++) {
            apresEgal += affichageTextField.getText().charAt(k);
        }
        if (apresEgal.charAt(0) != '-' && apresEgal.charAt(0) != '+') {
            signeChanger = "-" + apresEgal;
        } else if (apresEgal.charAt(0) != '-') {
            apresEgal = apresEgal.substring(1);
            signeChanger = "-" + apresEgal;
        } else {
            apresEgal = apresEgal.substring(1);
            signeChanger = "+" + apresEgal;
        }
        affichageTextField.setText(avantEgal + signeChanger);
    }

    @FXML
    void effacerDernierCaractere(ActionEvent event) {
        if (!affichageTextField.getText().isEmpty())
            affichageTextField.setText(affichageTextField.getText().substring(0, affichageTextField.getText().length() - 1));
    }

    @FXML
    void effacerToutLesCaractere(ActionEvent event) {
        affichageTextField.setText("");
    }
}


