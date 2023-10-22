package a23.sim203.tp2.cell;

import a23.sim203.tp2.modele.Equation;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;

import java.io.IOException;

public class EquationCell extends ListCell<Equation> {


    @FXML
    private TextField affichageTextField;
    private Parent cellRoot;
    public EquationCell() throws IOException {
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("../Calculatrice.fxml"));
        loader.setController(this);
        cellRoot = loader.load();
        this.setEditable(false);
    }

    public void updateItem(Equation equation, boolean empty) {
        super.updateItem(equation,empty);
        if (equation == null || empty){
            setItem(null);
            setGraphic(null);
        }else {

            setGraphic(affichageTextField);

//            a.setText(personne.getNom());
//            prenomTextField.setText(personne.getPrenom());
//            ageTextField.setText(String.valueOf(personne.getAge()));
        }
    }


}
