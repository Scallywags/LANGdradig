package scallywags.langdradig.ide;

import scallywags.langdradig.generate.Type;

/**
 * Created by Jeroen Weener on 20/06/2016.
 */
public class Translator {

    public static String translateType(Type type) {
        return '<' + parseType(type) + '>';
    }

    private static String parseType(Type type) {
        if (type == Type.INTEGER) {
            return "getal";
        } else if (type == Type.BOOLEAN) {
            return "stelling";
        } else if (type instanceof Type.ArrayType) {
            int elemCount = ((Type.ArrayType) type).getElemCount();
            Type elemType = ((Type.ArrayType) type).getElemType();
            return "reeks van " + elemCount + ' ' + (elemCount != 1 ? parseTypeMultiplicities(elemType) : parseType(elemType));
        } else if (type == Type.EMPTY_ARRAY) {
            return "lege reeks";
        } else {
            return "onbekend";
        }
    }

    private static String parseTypeMultiplicities(Type type) {
        if (type == Type.INTEGER) {
            return "getallen";
        } else if (type == Type.BOOLEAN) {
            return "stellingen";
        } else if (type instanceof Type.ArrayType) {
            int elemCount = ((Type.ArrayType) type).getElemCount();
            Type elemType = ((Type.ArrayType) type).getElemType();
            return "reeksen van " + elemCount + ' ' + (elemCount != 1 ? parseTypeMultiplicities(elemType) : parseType(elemType));
        } else if (type == Type.EMPTY_ARRAY) {
            return "lege reeksen";
        } else {
            return "onbekenden";
        }
    }

    public static String translateBoolean(String value) {
        switch (value) {
            case "True":
                return "Waar";
            case "False":
                return "Onwaar";
            default:
                return "ERROR";
        }
    }

    public static String translateString(String string) {
        return string.replace("extraneous input", "foutieve input")
                .replace("expecting", "verwacht")
                .replace("no viable alternative at input", "onverwachte term")
                .replace("<EOF>", "eind van het programma")
                .replace("missing", "ontbreekt")
                .replace(" at", " op")
                .replace("mismatched input", "verkeerde input")
                .replace("IDENTIFIER", "VARIABELE")
                .replace("NUMBER", "GETAL");
    }
}
