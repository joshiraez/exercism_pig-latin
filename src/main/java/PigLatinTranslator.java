public class PigLatinTranslator {

    public String translate(final String toTranslate) {

        if(toTranslate.startsWith("a")) return toTranslate + "ay";
        if(toTranslate.startsWith("e")) return toTranslate + "ay";

        return null;
    }
}
