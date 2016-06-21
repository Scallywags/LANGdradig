package scallywags.langdradig;

import scallywags.langdradig.generate.Type;

/**
 * Created by Jeroen Weener on 20/06/2016.
 */
public class Translator {

    public static String translateType(Type type) {
        if (type == null) {
            return "<onbekend>";
        } else if (type.equals(Type.INTEGER)) {
            return "<getal>";
        } else if (type.equals(Type.BOOLEAN)) {
            return "<stelling>";
        } else {
            return "<onbekend>";
        }
    }
}
