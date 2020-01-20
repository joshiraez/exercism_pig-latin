import java.util.regex.Pattern;

public class PigLatinTranslator {

    public String translate(final String toTranslate) {

        if (wordBeginsWithAorEorI(toTranslate)) return toTranslate + "ay";

        return null;
    }

    private boolean wordBeginsWithAorEorI(String toTest) {
        return Pattern.compile("^[aei]")
                .asPredicate()
                .test(toTest);
    }
}
