package a23.sim203.tp2.modele;

import javafx.scene.control.Alert;

/**
 * Crée un classe qui contient les méthodes pour différent dialogue
 */
public class DialoguesUtil {
    /**
     * Affiche un dialogue confirmation sur les informations des auteurs
     */
    public  void showAPropos() {
        Alert dialog = new Alert(Alert.AlertType.CONFIRMATION);
        dialog.setTitle("Calculateur avancé");
        dialog.setHeaderText("Sim 203");
        dialog.setContentText("Cours de programamtion 203 en SIM" + "\n" + "Cégep Limoilou A23" + "\n" + "par: Gabriel lebel et Alexis Miron");
        dialog.showAndWait();
    }
    /**
     * Affiche un dialogue confirmation qui indique que l'expression est invalide
     */
    public  void showExpressionInvalide() {
        Alert dialog = new Alert(Alert.AlertType.CONFIRMATION);
        dialog.setTitle("Calculateur Avancé");
        dialog.setHeaderText("Expression Invalide");
        dialog.setContentText("L'expression saisie ne peut être calculée");
        dialog.showAndWait();
    }

    /**
     * Affiche une alerte qui indique que l'équation entrée est invalide
     */
    public void showAlertEquationNonValide() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText("Équation non valide");
        alert.setTitle("Calculateur avancé");
        alert.showAndWait();
    }

}
