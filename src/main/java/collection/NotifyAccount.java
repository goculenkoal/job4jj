package collection;

import java.util.HashSet;
import java.util.List;

public class NotifyAccount {
    public static HashSet<Account> sent(List<Account> accounts) {
        HashSet<Account> rsl = new HashSet<>();
        for (Account data: accounts) {
            rsl.add(data);
        }
        /* for-each accounts to HashSet; */
        return rsl;
    }
}