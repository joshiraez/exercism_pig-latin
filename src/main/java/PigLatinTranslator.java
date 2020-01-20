import java.util.regex.Pattern;

public class PigLatinTranslator {

    public String translate(final String toTranslate) {

        if (wordBeginsWithAnyVowel(toTranslate)
                || wordBeginsWithYt(toTranslate)
                || wordBeginsWithXr(toTranslate))
            return toTranslate + "ay";

        return null;
    }

    private boolean wordBeginsWithAnyVowel(String toTest) {
        return Pattern.compile("^[aeiou]")
                .asPredicate()
                .test(toTest.toLowerCase());
    }

    private boolean wordBeginsWithYt(final String toTest) {
        return Pattern.compile("^[yt]")
                .asPredicate()
                .test(toTest.toLowerCase());
    }

    private boolean wordBeginsWithXr(final String toTest) {
        return Pattern.compile("^[xr]")
                .asPredicate()
                .test(toTest.toLowerCase());
    }
}
