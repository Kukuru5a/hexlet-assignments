package exercise;

import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
public class Tag {
    String tagName;
    final String keys = "class";
    final String ids = "id";
    final String lang = "lang";

    public Tag(String tagName) {
        this.tagName = tagName;
    }

    public String getKey() {
        return keys;
    }

    public String getIds() {
        return ids;
    }

    public String getLang() {
        return lang;
    }
}
// END
