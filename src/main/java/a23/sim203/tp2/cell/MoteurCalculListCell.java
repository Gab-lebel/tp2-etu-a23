package a23.sim203.tp2.cell;

import a23.sim203.tp2.modele.Equation;
import a23.sim203.tp2.modele.MoteurCalcul;
import javafx.scene.control.ListCell;

public class MoteurCalculListCell extends ListCell<MoteurCalcul> {

    public MoteurCalculListCell() {

    }

    public void updateItem(MoteurCalcul moteurCalcul, boolean empty) {
        super.updateItem(moteurCalcul,empty);
        if (moteurCalcul == null || empty){
            setItem(null);
            setGraphic(null);
        }else {

            setText(String.valueOf(moteurCalcul));
            setGraphic(null);
        }
    }
}
