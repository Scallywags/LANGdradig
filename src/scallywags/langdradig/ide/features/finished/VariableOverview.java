package scallywags.langdradig.ide.features.finished;

import scallywags.langdradig.ide.Translator;
import scallywags.langdradig.generate.Variable;

import java.util.List;

/**
 * Created by Jeroen Weener on 22/06/2016.
 */
public class VariableOverview {

    public static String printScopes(List<Variable> variableList) {
        StringBuilder sb = new StringBuilder();
        for (Variable v : variableList) {
            for (int i = 0; i < v.getScope(); i++) {
                sb.append("\t");
            }
            sb.append(v.getVariable()).append(" - ").append(Translator.translateType(v.getType())).append("\n");
        }
        return sb.toString();
    }
}
