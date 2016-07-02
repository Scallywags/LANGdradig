package scallywags.langdradig.ide.features.finished;

import scallywags.langdradig.generate.ForkTable;
import scallywags.langdradig.ide.Translator;
import scallywags.langdradig.generate.Variable;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.util.Map;

/**
 * Created by Jeroen Weener on 22/06/2016.
 */
public class ProgramStructureOverview {

    public static String printScopes(ForkTable forkTable) {
        StringBuilder sb = new StringBuilder();
        for (ForkTable.ProcessScope scope : forkTable.getScopeList()) {
            for (int i = 0; i < scope.getDepth(); i++) {
                sb.append("\t");
            }
            sb.append(scope).append(" - <Draad>\n");
            for (Variable v : scope.getSymbolTable().getVariables()) {
                for (int i = 0; i < scope.getDepth() + v.getScope(); i++) {
                    sb.append("\t");
                }
                sb.append(v.getVariable()).append(" - ").append(Translator.translateType(v.getType())).append(v.isShared() ? " (gedeeld)" : "").append("\n");
            }
        }
        return sb.toString();
    }
}
