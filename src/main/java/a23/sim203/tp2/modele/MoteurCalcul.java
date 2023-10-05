package a23.sim203.tp2.modele;

import javafx.scene.control.Alert;
import org.mariuszgromada.math.mxparser.*;

import java.util.*;

public class MoteurCalcul {

    // ajoutez les attributs pour stocker les équations et les variables
    Set<Equation> equationsHashSet;
    Map<String, Double> variablesHashMap;




    public MoteurCalcul() {
        License.iConfirmNonCommercialUse("Cegep Limoilou");

        equationsHashSet = new HashSet<>();
        variablesHashMap = new HashMap<>();
    }


    private Set<String> determineToutesVariablesRequises() {

        return null;
    }

    private void ajouteVariable(String variable, double valeur) {

    }

    public void setValeurVariable(String nomVariable, double valeur) {
        variablesHashMap.replace(nomVariable, valeur);
    }


    public void ajouteEquation(String nouvelleEquation) {
        int indexEquals = nouvelleEquation.indexOf('=');
        String nomEquation = nouvelleEquation.substring(0, indexEquals);
        String expression = nouvelleEquation.substring(indexEquals + 1);
        try {
            Equation equation = new Equation(nomEquation, expression);
        } catch (RuntimeException e) {
            if (Objects.equals(e.getMessage(), "Mauvais nom")) {
                showAlertEquationNonValide();
            } else {
                throw e;
            }
        }
    }


    public void effaceEquation(String nomEquation) {


    }

    public double calcule(String nomEquation) {

        return 0; // à changer
    }

    public double calcule(Equation equation) {

        return 0; // à changer

    }

    public Collection<String> getToutesLesVariables() {


        return null; // à changer
    }

    public Equation getToutesLesEquations() {

        return null; // à changer

    }





    public Map<Object, Object> getVariableValueMap() {

        return null; // à changer

    }

    public Map<Object, Object> getEquationMap() {

        return null; // à changer

    }

    private void showAlertEquationNonValide() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText("Équation non valide");
        alert.setTitle("Calculateur avancé");
    }

    public static void main(String[] args) {

        // Comment utiliser les expression avec plusieurs variables

        License.iConfirmNonCommercialUse("Cegep Limoilou");

        Constant A0 = new Constant("a0",3);
        Constant B0 = new Constant("b0",3);


        Expression e1 = new Expression("3+4+a0+b0", A0, B0);
        Expression e2 = new Expression("3+4+a0+b0", new Constant[]{A0,B0});// alternative avec tableau

        System.out.println("e1="+e1.calculate());
        System.out.println("e2="+e2.calculate());

    }
}
