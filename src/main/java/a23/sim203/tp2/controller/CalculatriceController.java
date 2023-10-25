package a23.sim203.tp2.controller;

import a23.sim203.tp2.modele.DialoguesUtil;
import a23.sim203.tp2.modele.Equation;
import a23.sim203.tp2.modele.MoteurCalcul;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.Iterator;
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
     * Crée un menu appeler "Assistance visuelle" dans assistanceMenu
     */
    @FXML
    private CheckMenuItem assistanceVisuelle;
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
     * Crée un ListeViews qui contiendra les équation
     */
    @FXML
    private ListView<String> equationsListViews;
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
     * Crée le ToggleButton "lire"/"écrire" dans VariablesHbox
     */
    @FXML
    private ToggleButton lireEtEcrireToggleButton;
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
     * Crée le ToggleButton "Variable"/"Valeur"
     */

    @FXML
    private ToggleButton variableOuValeurToggleButton;

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
    private ListView<String> variablesListViews;
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
     * crée une variable de type DialogueUtil
     */
    DialoguesUtil dialoguesUtil = new DialoguesUtil();

    /**
     * Ajouter le caractère '+' à la fin de la String du Textfield
     *
     * @param event
     */
    @FXML
    void ajoutajouterCaracterePlus(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + "+");
    }

    /**
     * Ajouter le caractère/chiffre '1' à la fin de la String du Textfield
     *
     * @param event
     */
    @FXML
    void ajouterCaractere1(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + "1");
    }

    /**
     * Ajouter le caractère/chiffre '2' à la fin de la String du Textfield
     *
     * @param event
     */
    @FXML
    void ajouterCaractere2(ActionEvent event) {
        affichageTextField.setText(affichageTextField.getText() + "2");
    }

    /**
     * Ajouter le caractère/chiffre '3' à la fin de la String du Textfield
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
    void calculerEquation(ActionEvent event) {
        Equation equation;
        if (affichageTextField.getText().indexOf('=') == -1) {
            ajouterUneEquationIncomplete(affichageTextField.getText());
        }
        moteurCalcul.ajouteEquation(affichageTextField.getText());
        double reponseCalcule = moteurCalcul.calcule(moteurCalcul.getEquation());
        if (String.valueOf(reponseCalcule).equals("NaN")) {
            dialoguesUtil.showExpressionInvalide();
        } else {
            affichageTextField.setText(String.valueOf(reponseCalcule));
        }

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
     *
     * @param event
     */
    @FXML
    void effacerDernierCaractere(ActionEvent event) {
        if (!affichageTextField.getText().isEmpty())
            affichageTextField.setText(affichageTextField.getText().substring(0, affichageTextField.getText().length() - 1));
    }

    /**
     * Efface tout les caratere de affichageTextFields
     *
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
     *
     * @param event
     */
    @FXML
    void ajouterUneEquation(ActionEvent event) {
        Equation equation;
        String variableReferer;
        int indexEgal = affichageTextField.getText().indexOf('=');
        if (indexEgal == -1) {
            dialoguesUtil.showAlertEquationNonValide();
        } else {
            moteurCalcul.ajouteEquation(affichageTextField.getText());
            equation = moteurCalcul.getEquation();

            if (moteurCalcul.isEquationReferredTo(affichageTextField.getText().substring(0, indexEgal))) {
                variableReferer = moteurCalcul.findElementReferredTo(affichageTextField.getText().substring(0, indexEgal),
                        affichageTextField.getText()).substring(1, 3);
                variablesListViews.getItems().remove(variableReferer + "=NaN");
            }
            equationsListViews.getItems().addAll(equation.getNom() + "=" + equation.getExpression() + " élément requis : " + equation.getElementsRequis());

            Iterator<String> iterator = moteurCalcul.getToutesLesVariables().iterator();
            String nomVariable;
            while (iterator.hasNext()) {
                nomVariable = iterator.next();
                variablesListViews.getItems().add(nomVariable + "=" + moteurCalcul.getVariableValueMap().
                        get(nomVariable).getConstantValue());
            }
            variablesListViews.refresh();
        }
    }


    /**
     * Supprime l'équation selectionner de  equationlistView et ses variables dans variablesListViews
     * la variablesListViews sera refresh pour mettre a jour l'affichage
     *
     * @param event
     */
    @FXML
    void supprimerEquationSelectionner(ActionEvent event) {
        String equationSelectionner = equationsListViews.getSelectionModel().getSelectedItem();
        int indexEgal = equationSelectionner.indexOf('=');
        equationsListViews.getItems().remove(equationsListViews.getSelectionModel().getSelectedItem());
        moteurCalcul.effaceEquation(equationSelectionner.substring(0, indexEgal));
        for (int i = 0; i < variablesListViews.getItems().size(); i++) {
            if (!moteurCalcul.isEquationReferredTo(variablesListViews.getItems().get(i).substring(0, 2))) {
                variablesListViews.getItems().remove(i);
                i--;
            }
        }
        variablesListViews.refresh();
    }

    /**
     * crée le dialog avec les infos sur les auteurs et le cours
     *
     * @param event
     */
    @FXML
    void actionnerAPropos(ActionEvent event) {
        dialoguesUtil.showAPropos();
    }

    /**
     * Crée les evenement dézoomer et zoomer qui zoom ou dézoome des boutons selon la position de la souris et grace a des
     * EventHandler et la méthode ajouteGestionnaireEvenement
     *
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
        ajouteGestionnaireEvenementAssistanceVisuelle(zoomer, dezoomer, MouseEvent.MOUSE_ENTERED_TARGET, MouseEvent.MOUSE_EXITED_TARGET,
                unButton, deuxButton, troisButton, quatreButton, cinqButton, sixButton, septButton,
                huitButton, neufButton, changementDeSigneButton, retierButton, retierToutButton, egalButton,
                zeroButton, diviserButton, additionnerButton, soustractionButton, foisButton, pointButton,
                parentheseDroiteButton, parenthèseGaucheButton);


    }

    /**
     * Ajoute les évenement sur des cibles choisi selon le type d'évenement
     *
     * @param handler  premier  évenement a faire
     * @param handler2 deuxième évenement a faire
     * @param type     premier type d'évenement
     * @param type2    deuxième type d'évenement
     * @param targets  élement cibler par les évenement
     */
    private void ajouteGestionnaireEvenementAssistanceVisuelle(EventHandler handler, EventHandler handler2, EventType type, EventType type2, Button... targets) {
        if (assistanceVisuelle.isSelected()) {
            for (int i = 0; i < targets.length; i++) {
                targets[i].addEventHandler(type, handler);
                targets[i].addEventHandler(type2, handler2);
            }
        } else {
            for (int i = 0; i < targets.length; i++) {
                targets[i].removeEventHandler(type, handler);
            }
        }

    }

    /**
     * Gère l'evenement lors du doubleclick sur variableListVIews
     * L'évenement va lire la valeur ou la variable selon l'option choisi
     * Si l'option choisi est d'écrire il définira une valeur a une variable qui vient du TextField
     */
    void ajouterEvenementBoutonsLireEcrireVariableValeur() {
        EventHandler<MouseEvent> event = (MouseEvent e) -> {
            String nomVariable;
            String valeur;
            int indexItemSelectionner = variablesListViews.getSelectionModel().getSelectedIndex();
            int indexCaractereEgal = variablesListViews.getItems().get(indexItemSelectionner).indexOf('=');
            if (e.getClickCount() == 2) {
                ajouterUneEquationIncomplete(affichageTextField.getText());
                valeur = String.valueOf(moteurCalcul.calcule(moteurCalcul.getEquation()));
                nomVariable = variablesListViews.getItems().get(indexItemSelectionner).substring(0, indexCaractereEgal);
                if (lireEtEcrireToggleButton.isSelected()) {
                    variablesListViews.getItems().remove(indexItemSelectionner);
                    variablesListViews.getItems().add(indexItemSelectionner, nomVariable + "=" + valeur);
                } else {
                    if (variableOuValeurToggleButton.isSelected()) {
                        affichageTextField.setText(affichageTextField.getText() +
                                variablesListViews.getItems().get(indexItemSelectionner).substring(indexCaractereEgal + 1));
                    } else {
                        affichageTextField.setText(affichageTextField.getText() + nomVariable);
                    }
                }
            }
        };
        variablesListViews.addEventHandler(MouseEvent.MOUSE_PRESSED, event);
    }

    /**
     * change le nom du bouton selon si il est sélectionner ou pas
     * le nom de base est Lire et l'autre est écrire
     * si écire est activer le bouton variable/valeur est désactiver
     *
     * @param event
     */
    @FXML
    void lireOuEcrire(ActionEvent event) {
        if (lireEtEcrireToggleButton.isSelected()) {
            lireEtEcrireToggleButton.setText("écrire");
            variableOuValeurToggleButton.setDisable(true);
        } else {
            lireEtEcrireToggleButton.setText("lire");
            variableOuValeurToggleButton.setDisable(false);
        }
    }

    /**
     * change le nom du bouton selon s'il est sélectionner ou pas
     * le nom de base est varibale et l'autre est valeur
     *
     * @param event
     */
    @FXML
    void variableOuValeur(ActionEvent event) {
        if (variableOuValeurToggleButton.isSelected()) {
            variableOuValeurToggleButton.setText("valeur");
        } else {
            variableOuValeurToggleButton.setText("variable");
        }
    }

    /**
     * Transforme une String qui n'est pas egal a une variable, la retourne égal a une variable soit une equation
     *
     * @param equationNonFinie la string qui est égal a rien
     * @return une equation de variable z9 créer avec la string en parametre
     */

    private String tansformerUneStringEnEquation(String equationNonFinie) {
        return "z9=" + equationNonFinie;
    }

    /**
     * ajoute la string transformer en equation dans moteurCalcul
     *
     * @param equationNonFinie la string a transformer
     */
    private void ajouterUneEquationIncomplete(String equationNonFinie) {
        moteurCalcul.ajouteEquation(tansformerUneStringEnEquation(equationNonFinie));
    }

    /**
     * Ajoute des donners de base dans les composant lors du lancement de l'application
     *
     * @param location  The location used to resolve relative paths for the root object, or
     *                  {@code null} if the location is not known.
     * @param resources The resources used to localize the root object, or {@code null} if
     *                  the root object was not localized.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ajouterEvenementBoutonsLireEcrireVariableValeur();
        affichageTextField.setAlignment(Pos.CENTER);
        Equation equation1 = new Equation("sin0", "sin(x0)");
        Equation equation2 = new Equation("cos0", "cos(x0)");
        Equation equation3 = new Equation("inverse0", "1/x0");
        Equation equation4 = new Equation("exp0", "x0^e0");
        Equation equation5 = new Equation("linear0", "a0*x0+b0");
        Equation[] equations = {equation1, equation2, equation3, equation4, equation5};
        for (int i = 0; i < equations.length; i++) {
            moteurCalcul.ajouteEquation(equations[i].getNom() + "=" + equations[i].getExpression());
            equationsListViews.getItems().add(equations[i].getNom() + "=" + equations[i].getExpression() +
                    " éléments requis : " + equations[i].getElementsRequis());
        }
        affichageTextField.setText("affichage");
        variablesListViews.getItems().addAll("x0=NaN", "e0=NaN", "a0=NaN", "b0=NaN");
    }
}


