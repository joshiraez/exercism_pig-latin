import java.util.function.Predicate;
import java.util.regex.Pattern;

import static java.util.Arrays.asList;
import static java.util.stream.Stream.of;

public class PigLatinTranslator {

    private final Predicate<String> STARTS_WITH_VOWEL
            = Pattern.compile("^[aeiou]").asPredicate();
    private final Predicate<String> STARTS_WITH_YT
            = Pattern.compile("^yt").asPredicate();
    private final Predicate<String> STARTS_WITH_XR
            = Pattern.compile("^xr").asPredicate();

    public String translate(final String toTranslate) {

        if (anyOf(
                testNormalisingToLowerCaseThat(toTranslate, STARTS_WITH_VOWEL),
                testNormalisingToLowerCaseThat(toTranslate, STARTS_WITH_YT),
                testNormalisingToLowerCaseThat(toTranslate, STARTS_WITH_XR)
        ))
            return toTranslate + "ay";

        return null;
    }

    private boolean testNormalisingToLowerCaseThat(final String word, final Predicate<String> matcher) {
        return matcher.test(word.toLowerCase());
    }

    private boolean anyOf(Boolean... conditions) {
        return asList(conditions).contains(true);
    }
}
