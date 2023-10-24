package a23.sim203.tp2.modele;

import javafx.scene.control.Alert;
import org.mariuszgromada.math.mxparser.*;

import java.util.*;

public class MoteurCalcul {

    // ajoutez les attributs pour stocker les équations et les variables
    Map<String, Constant> variablesHashMap;
    Map<String, Equation> equationMap;

    Equation equation;


    public MoteurCalcul() {
        License.iConfirmNonCommercialUse("Cegep Limoilou");

        variablesHashMap = new HashMap<>();
        equationMap = new HashMap<>();
    }


    private Set<String> determineToutesVariablesRequises() {
        Set<String> stringSet = new HashSet<>();
        for (Equation equation : getToutesLesEquations()) {
            stringSet.addAll(equation.getElementsRequis());
        }
        return stringSet;
    }

    private void ajouteVariable(String variable, double valeur) {
        variablesHashMap.put(variable, new Constant(variable, valeur));
    }

    public void setValeurVariable(String nomVariable, double valeur) {
        variablesHashMap.replace(nomVariable, new Constant(nomVariable, valeur));
    }


    public void ajouteEquation(String nouvelleEquation) {
        int indexEquals = nouvelleEquation.indexOf('=');
        String nomEquation = nouvelleEquation.substring(0, indexEquals);
        String expression = nouvelleEquation.substring(indexEquals + 1);

        try {

            equation = new Equation(nomEquation, expression);

            if (isExpressionValid(equation)) {
                variablesHashMap.remove(nomEquation); //enlever variable du meme nom si elle existe
                equationMap.put(nomEquation, equation);
                for (String element : equation.getElementsRequis()) {
                    addVariableIfNotExistant(element);
                }
                circularDependencyCheck(nomEquation);
            }

        } catch (RuntimeException e) {
            if (Objects.equals(e.getMessage(), "Mauvais nom")) {
                showAlertEquationNonValide();
            } else {
                throw e;
            }
        }
    }

    private void addVariableIfNotExistant(String nomVariable) {
        if (!getToutesLesVariables().contains(nomVariable)) {
            variablesHashMap.put(nomVariable, new Constant(nomVariable, Double.NaN));
        }
    }

    private void circularDependencyCheck(String nomEquation) {
        if (hasCircularDependency(nomEquation)) {
            effaceEquation(nomEquation);
            showAlertEquationNonValide();
        }
    }

    private boolean isExpressionValid(Equation equation) {
        return equation.getElementsRequis().size() != 0;
    }


    public void effaceEquation(String nomEquation) {
        Equation equationToBeDeleted = getEquationFromString(nomEquation);
        if (isEquationReferredTo(nomEquation)) {
            ajouteVariable(nomEquation, calcule(nomEquation));
        }

        Set<String> references = equationToBeDeleted.getElementsRequis();

        equationMap.remove(equationToBeDeleted.getNom());

        //shave off variables non utilisées
        for (String element : references) {
            if (isVariable(element) && !isElementReferredTo(element, null)) {
                variablesHashMap.remove(element);
            }
        }
    }

    /**
     * Itère dans la Map de références pour vérifier si la variable est utilisée par une équation autre que celle indiquée
     *
     * @param element       variable dont on vérifie les références
     * @param ignoredString équation dont on ignore les références
     */
    private boolean isElementReferredTo(String element, String ignoredString) {
        Iterator<String> iterator = equationMap.keySet().iterator();
        String currentEquation;

        while (iterator.hasNext()) {
            currentEquation = iterator.next();
            if (!currentEquation.equals(ignoredString)) {
                if (equationMap.get(currentEquation).getElementsRequis().contains(element))
                    return true;
            }
        }

        return false;
    }

    private boolean isEquationReferredTo(String nomEquation) {
        return isElementReferredTo(nomEquation, nomEquation);
    }

//    private void replaceEquationByVariable(Equation equation) {
//        Iterator<Equation> iterator = referencesMap.keySet().iterator();
//        Equation currentEquation;
//        ajouteVariable(equation.getNom(), calcule(equation));
//        boolean equationWasReplaced = false;
//
//        while (iterator.hasNext()) {
//            currentEquation = iterator.next();
//            if (currentEquation != equation) {
//                if (currentEquation.getElementsRequis().remove(equation.getNom())) {
//                    currentEquation.getElementsRequis().add()
//                    equationWasReplaced = true;
//                }
//            }
//        }
//    }

    public double calcule(String nomEquation) {
        return calcule(getEquationFromString(nomEquation)); // à changer
    }

    public double calcule(Equation equation) {
        Set<String> elementsRequis = equation.getElementsRequis();
        Constant[] tableauConstant = new Constant[elementsRequis.size()];
        int compteur = 0;

        for (String element : elementsRequis) {
            if (isEquation(element)) {
                tableauConstant[compteur++] = new Constant(element, calcule(element));
            } else {
                tableauConstant[compteur++] = variablesHashMap.get(element);
            }
        }
        Expression expression = new Expression(equation.getExpression(), tableauConstant);
        return expression.calculate();

    }

    public Collection<String> getToutesLesVariables() {
        return variablesHashMap.keySet();
    }

    public Set<Equation> getToutesLesEquations() {
        Set<Equation> equationSet = new HashSet<>();
        for (String s :
                equationMap.keySet()) {
            equationSet.add(equationMap.get(s));
        }
        return equationSet;
    }

    private boolean hasCircularDependency(String nomEquation) {
        return hasCircularDependencyInternal(new HashSet<>(), nomEquation);
    }

    private boolean hasCircularDependencyInternal(HashSet<String> parentReferences, String currentElement) {
        if (parentReferences.contains(currentElement)) {
            return true;
        }

        if (isEquation(currentElement)) {
            parentReferences.add(currentElement);
            Set<String> dependencies = getEquationFromString(currentElement).getElementsRequis();

            for (String dependency : dependencies) {
                if (isEquation(dependency) && hasCircularDependencyInternal((HashSet<String>) parentReferences.clone(), dependency)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isEquation(String nomEquation) {
        return equationMap.containsKey(nomEquation);
    }

    private boolean isVariable(String nomVariable) {
        return variablesHashMap.containsKey(nomVariable);
    }


    public Map<String, Constant> getVariableValueMap() {

        return variablesHashMap; // à changer

    }

    public Map<String, Equation> getEquationMap() {

        return equationMap; // à changer

    }

    private void showAlertEquationNonValide() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setContentText("Équation non valide");
        alert.setTitle("Calculateur avancé");
    }

    public static void main(String[] args) {

        // Comment utiliser les expression avec plusieurs variables

        License.iConfirmNonCommercialUse("Cegep Limoilou");

        Constant A0 = new Constant("a0", 3);
        Constant B0 = new Constant("b0", 3);


        Expression e1 = new Expression("3+4+a0+b0", A0, B0);
        Expression e2 = new Expression("3+4+a0+b0", new Constant[]{A0, B0});// alternative avec tableau

        System.out.println("e1=" + e1.calculate());
        System.out.println("e2=" + e2.calculate());

    }

    private Equation getEquationFromString(String nomEquation) {
        return equationMap.get(nomEquation);
    }

    /**
     * @return l'équation
     */
    public Equation getEquation() {
        return equation;
    }


}
