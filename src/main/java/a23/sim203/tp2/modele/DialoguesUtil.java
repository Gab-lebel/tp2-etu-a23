package a23.sim203.tp2.modele;

import javafx.scene.control.Alert;

public class DialoguesUtil {
    public static void showAPropos() {
        Alert dialog = new Alert(Alert.AlertType.CONFIRMATION);
        dialog.setTitle("Calculateur avancé");
        dialog.setHeaderText("Sim 203");
        dialog.setContentText("Cours de programamtion 203 en SIM" + "\n" + "Cégep Limoilou A23" + "\n" + "par: Gabriel lebel et Alexis Miron");
        dialog.showAndWait();
    }

    public static void showExpressionInvalide() {
        Alert dialog = new Alert(Alert.AlertType.CONFIRMATION);
        dialog.setTitle("Calculateur Avancé");
        dialog.setHeaderText("Expression Invalide");
        dialog.setContentText("L'expression saisie ne peut être calculée");
        dialog.showAndWait();
    }
}
