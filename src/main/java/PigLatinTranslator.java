import java.util.regex.Pattern;

public class PigLatinTranslator {

    public String translate(final String toTranslate) {

        if (wordBeginsWithAorEorIorO(toTranslate)) return toTranslate + "ay";

        return null;
    }

    private boolean wordBeginsWithAorEorIorO(String toTest) {
        return Pattern.compile("^[aeio]")
                .asPredicate()
                .test(toTest);
    }
}
