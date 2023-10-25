package a23.sim203.tp2.modele;

import javafx.scene.control.Alert;
import org.mariuszgromada.math.mxparser.*;

import java.util.*;

public class MoteurCalcul {

    // ajoutez les attributs pour stocker les équations et les variables
    /**
     * Crée un map contenat une String en clé et une Constant en valeur
     */
    Map<String, Constant> variablesHashMap;
    /**
     * Crée un map contenat une String en clé et une Equation en valeur
     */
    Map<String, Equation> equationMap;
    /**
     * Crée un variable de type Equation
     */
    Equation equation;
    /**
     * Crée une viable de type DialogueUtil
     */
    DialoguesUtil dialoguesUtil = new DialoguesUtil();

    /**
     * Constructeur de la classe MoteurCalcul
     */
    public MoteurCalcul() {
        License.iConfirmNonCommercialUse("Cegep Limoilou");

        variablesHashMap = new HashMap<>();
        equationMap = new HashMap<>();
    }

    /**
     * Ajoute une variable au moteur de calcul
     * @param variable nom de la variable
     * @param valeur valeur de la variable
     */
    private void ajouteVariable(String variable, double valeur) {
        variablesHashMap.put(variable, new Constant(variable, valeur));
    }

    /**
     * Assigne une valeur à une variable dans le moteur de calcul.
     * @param nomVariable nom de la variable à réassigner
     * @param valeur valeur à assigner
     */
    public void setValeurVariable(String nomVariable, double valeur) {
        variablesHashMap.replace(nomVariable, new Constant(nomVariable, valeur));
    }

    /**
     * Ajoute une équation au moteur de calcul. Affiche une erreur si elle ne réfère à rien ou se réfère à elle-même.
     * @param nouvelleEquation équation à ajouter au moteur
     */
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
                    addVariableIfNonExistent(element);
                }
                circularDependencyCheck(nomEquation);
            }

        } catch (RuntimeException e) {
            if (Objects.equals(e.getMessage(), "Mauvais nom")) {
                dialoguesUtil.showAlertEquationNonValide();
            } else {
                throw e;
            }
        }
    }

    /**
     * Ajoute une variable dans la Map appropriée si une variable avec le nom reçu en argument n'existe pas
     * @param nomVariable nom de la variable à ajouter
     */
    private void addVariableIfNonExistent(String nomVariable) {
        if (!getToutesLesVariables().contains(nomVariable)) {
            variablesHashMap.put(nomVariable, new Constant(nomVariable, Double.NaN));
        }
    }

    /**
     * Efface l'équation et affiche une alerte si elle a une dépendance circulaire
     * @param nomEquation nom de l'équation à vérifier
     */
    private void circularDependencyCheck(String nomEquation) {
        if (hasCircularDependency(nomEquation)) {
            effaceEquation(nomEquation);
            dialoguesUtil.showAlertEquationNonValide();
        }
    }

    /**
     * Vérifie si une expression est valide, c-à-d qu'elle requiert au moins un élément
     * @param equation équation dont l'expression est à vérifier
     * @return true si l'expression est valide
     */
    private boolean isExpressionValid(Equation equation) {
        return equation.getElementsRequis().size() != 0;
    }

    /**
     * Efface une équation du moteur de calcul
     * @param nomEquation nom de l'équation à effacer
     */
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
     * Itère dans la Map de références pour vérifier si la variable est utilisée par une équation autre que celle en argument
     *
     * @param element       variable dont on vérifie les références
     * @param ignoredString équation dont on ignore les références
     */
    public boolean isElementReferredTo(String element, String ignoredString) {
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

    /**
     * Itère dans la Map de références pour vérifier si la variable est utilisée par une équation autre que celle en argument
     * @param element       variable dont on vérifie les références
     * @param ignoredString équation dont on ignore les références
     * @return l'élement qui est recherché
     */
    public String findElementReferredTo(String element, String ignoredString) {
        Iterator<String> iterator = equationMap.keySet().iterator();
        String currentEquation;

        while (iterator.hasNext()) {
            currentEquation = iterator.next();
            if (!currentEquation.equals(ignoredString)) {
                if (equationMap.get(currentEquation).getElementsRequis().contains(element))
                    return String.valueOf(equationMap.get(currentEquation).getElementsRequis());
            }
        }
        return null;
    }

    /**
     * Itère dans la Map de références pour vérifier si la variable est utilisée par une équation autre que celle en argument
     *
     * @param nomEquation équation dont on vérifie les références
     */
    public boolean isEquationReferredTo(String nomEquation) {
        return isElementReferredTo(nomEquation, nomEquation);
    }

    /**
     * Calcule la valeur de l'équation
     * @param nomEquation nom de l'équation à calculer
     * @return valeur de l'équation
     */
    public double calcule(String nomEquation) {
        return calcule(getEquationFromString(nomEquation));
    }

    /**
     * Calcule la valeur de l'équation
     * @param equation équation à calculer
     * @return valeur de l'équation
     */
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

    /**
     * Retourne un set avec toutes les variables
     * @return set avec les variables
     */
    public Set<String> getToutesLesVariables() {
        return variablesHashMap.keySet();
    }

    /**
     * Retourne toutes les équations dans un set
     * @return set avec toutes les équations
     */
    public Set<Equation> getToutesLesEquations() {
        Set<Equation> equationSet = new HashSet<>();
        for (String s :
                equationMap.keySet()) {
            equationSet.add(equationMap.get(s));
        }
        return equationSet;
    }

    /**
     * Vérifie si l'équation en argument a une dépendance circulaire
     * @param nomEquation nom de l'équation à vérifier
     * @return true si l'équation se réfère à elle même
     */
    private boolean hasCircularDependency(String nomEquation) {
        return hasCircularDependencyInternal(new HashSet<>(), nomEquation);
    }

    /**
     * Vérifie si l'équation en argument a une dépendance circulaire
     * @param parentReferences parents dans l'arbre des références
     * @return true si l'élément se réfère à lui-même
     */
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

    /**
     * Vérifie si le nom en argument réfère à une équation dans le moteur
     * @param nomEquation nom à vérifier
     * @return true si l'équation existe dans le moteur
     */
    private boolean isEquation(String nomEquation) {
        return equationMap.containsKey(nomEquation);
    }

    /**
     * Vérifie si le nom en argument réfère à une variable dans le moteur
     * @param nomVariable nom à vérifier
     * @return true si l'équation existe dans le moteur
     */
    private boolean isVariable(String nomVariable) {
        return variablesHashMap.containsKey(nomVariable);
    }

    /**
     * Retourne la map de variables
     * @return map de variables
     */
    public Map<String, Constant> getVariableValueMap() {
        return variablesHashMap;
    }

    /**
     * Retourne la map d'équations
     * @return map d'équations
     */
    public Map<String, Equation> getEquationMap() {
        return equationMap;
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

    /**
     * Trouve l'équation associée au nom en argument
     * @param nomEquation nom de l'équation
     * @return équation
     */
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
