package AgendaClubeGames.Helpers;

import java.text.Normalizer;

public class StringHelper {
    public static String removeDiacritics(String s) {
        s = Normalizer.normalize(s, Normalizer.Form.NFD);
        s = s.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");

        return s;
    }
}