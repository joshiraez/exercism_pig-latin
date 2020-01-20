public class PigLatinTranslator {

    public String translate(final String toTranslate) {

        if(toTranslate.startsWith("a")) return toTranslate + "ay";

        return null;
    }
}
