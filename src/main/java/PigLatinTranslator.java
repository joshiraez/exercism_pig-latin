import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.Arrays.asList;

public class PigLatinTranslator {

    private final Pattern STARTS_WITH_VOWEL
            = Pattern.compile("^[aeiouAEIOU]");
    private final Pattern STARTS_WITH_YT
            = Pattern.compile("^[yY][tT]");
    private final Pattern STARTS_WITH_XR
            = Pattern.compile("^[xX][rR]");

    private final Pattern FIRST_VOWEL
            = Pattern.compile("[aeiouAEIOU]");

    public String translate(final String toTranslate) {

        if (anyOf(
                testThat(toTranslate, STARTS_WITH_VOWEL),
                testThat(toTranslate, STARTS_WITH_YT),
                testThat(toTranslate, STARTS_WITH_XR)
        ))
            return toTranslate + "ay";

        else
            return moveConsonantsToEnd(toTranslate) + "ay";
    }

    private boolean testThat(final String word, final Pattern matcher) {
        return matcher.matcher(word).find();
    }

    private boolean anyOf(Boolean... conditions) {
        return asList(conditions).contains(true);
    }

    private String moveConsonantsToEnd(final String toTransform) {

        final Matcher vowelMatcher = FIRST_VOWEL.matcher(toTransform);

        if (vowelMatcher.find())
            return toTransform.substring(vowelMatcher.start()) + toTransform.substring(0, vowelMatcher.start());
        else
            return toTransform;
    }

}
