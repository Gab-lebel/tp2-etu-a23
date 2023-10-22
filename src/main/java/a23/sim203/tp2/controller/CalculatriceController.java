package a23.sim203.tp2.controller;

import a23.sim203.tp2.cell.EquationListCell;
import a23.sim203.tp2.modele.Equation;
import a23.sim203.tp2.modele.MoteurCalcul;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.fxml.LoadListener;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Class qui permet de controler les composant du fichier Calculatrice.Fxml
 */
public class CalculatriceController implements Initializable {
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
    private ListView<Equation> equationsListViews;
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
    private ListView<Equation> variablesListViews;
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
     *
     * @param event
     */
    @FXML
    void ajoutajouterCaracterePlus(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + "+");
    }

    /**
     * Ajouter le caractère/chiffre '1' a la fin de la String du Textfield
     *
     * @param event
     */
    @FXML
    void ajouterCaractere1(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + "1");
    }

    /**
     * Ajouter le caractère/chiffre '2' a la fin de la String du Textfield
     *
     * @param event
     */
    @FXML
    void ajouterCaractere2(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + "2");
    }

    /**
     * Ajouter le caractère/chiffre '3' a la fin de la String du Textfield
     *
     * @param event
     */
    @FXML
    void ajouterCaractere3(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + "3");
    }

    /**
     * Ajouter le caractère/chiffre '4' a la fin de la String du Textfield
     *
     * @param event
     */
    @FXML
    void ajouterCaractere4(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + "4");
    }

    /**
     * Ajouter le caractère/chiffre '5' a la fin de la String du Textfield
     *
     * @param event
     */
    @FXML
    void ajouterCaractere5(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + "5");
    }

    /**
     * Ajouter le caractère/chiffre '6' a la fin de la String du Textfield
     *
     * @param event
     */
    @FXML
    void ajouterCaractere6(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + "6");
    }

    /**
     * Ajouter le caractère/chiffre '7' a la fin de la String du Textfield
     *
     * @param event
     */
    @FXML
    void ajouterCaractere7(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + "7");
    }

    /**
     * Ajouter le caractère/chiffre '8' a la fin de la String du Textfield
     *
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
     *
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
     *
     * @param event
     */
    @FXML
    void ajouterCaractereEgal(ActionEvent event) {
        double reponseCalcule = moteurCalcul.calcule(affichageTextField.getText());
        if (String.valueOf(reponseCalcule).equals("NaN")) {
            Alert dialog = new Alert(Alert.AlertType.CONFIRMATION);
            dialog.setTitle("Calculateur Avancé");
            dialog.setHeaderText("Expression Invalide");
            dialog.setContentText("L'expression saisie ne peut être calculée");
        } else {
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
     *
     * @param event
     */
    @FXML
    void ajouterCaractereFois(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + "*");
    }

    /**
     * Ajouter le caractère '-' a la fin de la String du Textfield
     *
     * @param event
     */
    @FXML
    void ajouterCaractereMoin(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + "-");
    }

    /**
     * Ajouter le caractère/chiffre '0' a la fin de la String du Textfield
     *
     * @param event
     */
    @FXML
    void ajouterCaractereZero(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + "0");
    }

    /**
     * Ajouter le caractère '(' a la fin de la String du Textfield
     *
     * @param event
     */
    @FXML
    void ajouterParentheseDroite(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + "(");
    }

    /**
     * Ajouter le caractère ')' a la fin de la String du Textfield
     *
     * @param event
     */
    @FXML
    void ajouterParentheseGauche(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + ")");
    }

    /**
     * Ajouter le caractère ',' a la fin de la String du Textfield
     *
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

    /**
     * Efface le dernier caractere de affichageTextFields
     * @param event
     */
    @FXML
    void effacerDernierCaractere(ActionEvent event) {
        if (!affichageTextField.getText().isEmpty())
            affichageTextField.setText(affichageTextField.getText().substring(0, affichageTextField.getText().length() - 1));
    }

    /**
     * Efface tout les caratere de affichageTextFields
     * @param event
     */
    @FXML
    void effacerToutLesCaractere(ActionEvent event) {
        affichageTextField.setText("");
    }

    /**
     * Ajoute l'équation de affichageTextField dans equatioListView en passant par moteurcalcul qui retourne
     * les parametre nécessaire pour une équation
     * la variablesListViews sera refres pour ajouter les varibales nécessaire
     * @param event
     */
    @FXML
    void ajouterUneEquation(ActionEvent event) {
        Equation equation;
        moteurCalcul.ajouteEquation(affichageTextField.getText());
        equation = moteurCalcul.getEquation();

        equationsListViews.getItems().add(equation);
        variablesListViews.refresh();
    }

    private void creerVariableListView() {
//        variablesListViews.setCellFactory(new Callback<ListView<Equation>, ListCell<Equation>>() {
//            @Override
//            public ListCell<Equation> call(ListView<Equation> param) {
//                try {
//                    return new EquationListCell();
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
//        });
    }

    /**
     * Défini ce qui sera dans equationlistView ici une equation
     */
    private void creerEquationListView() {
        equationsListViews.setCellFactory(new Callback<ListView<Equation>, ListCell<Equation>>() {
            @Override
            public ListCell<Equation> call(ListView<Equation> param) {
                try {
                    return new EquationListCell();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

    }

    /**
     * Supprime l'équation selectionner de  equationlistView et ses variables dans varibalesListViews
     * la variablesListViews sera refres pour ajouter les varibales nécessaire
     * @param event
     */
    @FXML
    void supprimerEquationSelectionner(ActionEvent event) {
//        int i;
//        i = equationsListViews.getSelectionModel().getSelectedIndex();
        equationsListViews.getItems().remove(equationsListViews.getSelectionModel().getSelectedItem());

//        equationsListViews.refresh();
        variablesListViews.refresh();
    }

    @FXML
    void LireOuEcrire(ActionEvent event) {

    }

    /**
     *
     * @param event
     */
    @FXML
    void VariableOuValeur(ActionEvent event) {

    }

    /**
     * crée le dialog avec les infos sur les auteurs et le cours
     * @param event
     */
    @FXML
    void actionnerAPropos(ActionEvent event) {
        Alert dialog = new Alert(Alert.AlertType.CONFIRMATION);
        dialog.setTitle("Calculateur avancé");
        dialog.setHeaderText("Sim 203");
        dialog.setContentText("Cours de programamtion 203 en SIM" + "\n" + "Cégep Limoilou A23" + "\n" + "par: Gabriel lebel et Alexis Miron");
        dialog.showAndWait();
    }

    /**
     * Crée les evenement dézoomer et zoomer qui zoom ou dézoome des boutons selon la position de la souris et grace a des
     * EventHandler et la méthode ajouteGestionnaireEvenement
     * @param event
     */
    @FXML
    void actionnerAssitanceVisuelle(ActionEvent event) {
        EventHandler<MouseEvent> zoomer = (MouseEvent e) -> {
            ((Node) e.getTarget()).setScaleX(1.5);
            ((Node) e.getTarget()).setScaleY(1.5);
        };
        EventHandler<MouseEvent> dezoomer = (MouseEvent e) -> {
            ((Node) e.getTarget()).setScaleX(1.0);
            ((Node) e.getTarget()).setScaleY(1.0);
        };
        ajouteGestionnaireEvenement(zoomer,dezoomer ,MouseEvent.MOUSE_ENTERED_TARGET,MouseEvent.MOUSE_EXITED_TARGET,
                unButton, deuxButton, troisButton, quatreButton, cinqButton, sixButton, septButton,
                huitButton, neufButton, changementDeSigneButton, retierButton, retierToutButton, egalButton,
                zeroButton, diviserButton, additionnerButton, soustractionButton, foisButton, pointButton,
                parentheseDroiteButton, parenthèseGaucheButton);


    }

    /**
     *Ajoute les évenement sur des cibles choisi selon le type d'évenement
     * @param handler premier  évenement a faire
     * @param handler2 deuxième évenement a faire
     * @param type premier type d'évenement
     * @param type2 deuxième type d'évenement
     * @param targets élement cibler par les évenement
     */
    private void ajouteGestionnaireEvenement(EventHandler handler,EventHandler handler2 ,EventType type,EventType type2, Button... targets) {
        if (assistanceVisuelle.isSelected()) {
            for (int i = 0; i < targets.length; i++) {
                targets[i].addEventHandler(type, handler);
                targets[i].addEventHandler(type2, handler2);
            }
        } else {
            for (int i = 0; i < targets.length; i++) {
                targets[i].removeEventHandler(type, handler);
                targets[i].addEventHandler(type2, handler2);
            }
        }
    }

    /**
     * Ajoute des donners de base dans les composant lors du lancement de l'application
     * @param location
     * The location used to resolve relative paths for the root object, or
     * {@code null} if the location is not known.
     *
     * @param resources
     * The resources used to localize the root object, or {@code null} if
     * the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //todo enlever commentaire
        creerEquationListView();
        creerVariableListView();
        Equation equation1 = new Equation("sin0","sin(x0)");
        Equation equation2 = new Equation("cos0","cos(x0)");
        Equation equation3 = new Equation("inverse0","1/x0");
        Equation equation4 = new Equation("exp0","x0^e0");
        Equation equation5 = new Equation("linear0","a0*x0+b0");
        equationsListViews.getItems().addAll(equation1,equation2,equation3,equation4,equation5);
        affichageTextField.setText("affichage");
    }
}


