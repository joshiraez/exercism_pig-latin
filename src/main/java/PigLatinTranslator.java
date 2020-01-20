import java.util.function.Predicate;
import java.util.regex.Pattern;

import static java.util.Arrays.asList;

public class PigLatinTranslator {

    private final Predicate<String> STARTS_WITH_VOWEL
            = Pattern.compile("^[aeiouAEIOU]").asPredicate();
    private final Predicate<String> STARTS_WITH_YT
            = Pattern.compile("^[yY][tT]").asPredicate();
    private final Predicate<String> STARTS_WITH_XR
            = Pattern.compile("^[xX][rR]").asPredicate();

    public String translate(final String toTranslate) {

        if (anyOf(
                testThat(toTranslate, STARTS_WITH_VOWEL),
                testThat(toTranslate, STARTS_WITH_YT),
                testThat(toTranslate, STARTS_WITH_XR)
        ))
            return toTranslate + "ay";


        return null;
    }

    private boolean testThat(final String word, final Predicate<String> matcher) {
        return matcher.test(word);
    }

    private boolean anyOf(Boolean... conditions) {
        return asList(conditions).contains(true);
    }

}
