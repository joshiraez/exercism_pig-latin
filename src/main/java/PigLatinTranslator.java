import java.util.regex.Pattern;

public class PigLatinTranslator {

    public String translate(final String toTranslate) {

        if (wordBeginsWithAnyVowel(toTranslate)) return toTranslate + "ay";

        return null;
    }

    private boolean wordBeginsWithAnyVowel(String toTest) {
        return Pattern.compile("^[aeiou]")
                .asPredicate()
                .test(toTest.toLowerCase());
    }
}
