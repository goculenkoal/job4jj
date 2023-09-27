package collection;

import java.util.HashSet;

public class UniqueText {
    public boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        for (String textCh : origin) {
            check.add(textCh);
        }
        for (String chText : text) {
            if (!(check.contains(chText))) {
                rsl = false;
                break;
            }
        }
        return rsl;
    }
}