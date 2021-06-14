package by.itstep.phonebook;

import java.util.Set;

public class Utils {

    public static final String TEXT_PATTERN = "[A-Za-z]+";
    public static final String PHONE_PATTERN =
            "\\+[0-9]{2,3}-[0-9]{2}-[0-9]{7}";

    public static boolean isText(String text) {
        if (text == null) return false;
        return text.matches(TEXT_PATTERN);
    }

    public static boolean isPhones(Set<String> phones){
        return phones.stream().allMatch(phone -> phone.matches(PHONE_PATTERN));
    }
}
