package a23.sim203.tp2.cell;

import a23.sim203.tp2.controller.CalculatriceController;
import a23.sim203.tp2.modele.Equation;
import a23.sim203.tp2.modele.MoteurCalcul;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * Crée un enfant de ListCell<> de la classe Equation pour pouvoir
 * ajouter des équations dans une ListViews
 */
public class EquationListCell extends ListCell<Equation> {

    public EquationListCell() throws IOException {

    }

    /**
     * Met a jour le nouveau item dans une cellule d'équationlistView, ici une equation
     * @param equation The new item for the cell.
     * @param empty whether or not this cell represents data from the list. If it
     *        is empty, then it does not represent any domain data, but is a cell
     *        being used to render an "empty" row.
     */
    public void updateItem(Equation equation, boolean empty) {
        super.updateItem(equation,empty);
        if (equation == null || empty){
            setItem(null);
            setGraphic(null);
        }else {

          setText(String.valueOf(equation));
            setGraphic(null);
        }
    }


}
