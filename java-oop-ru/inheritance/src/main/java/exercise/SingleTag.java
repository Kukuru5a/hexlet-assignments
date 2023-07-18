package exercise;

import java.util.Map;

// BEGIN
public class SingleTag extends Tag{
    Map<String,String> attributes;
    public SingleTag(String tagName, Map<String, String> attributes) {
        super(tagName);
        this.attributes = attributes;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("<");
        builder.append(tagName);
        for (Map.Entry<String, String> kk : attributes.entrySet()) {
            builder.append(" " + kk.getKey())
                    .append("=\"" + kk.getValue() + "\"");
        }
        builder.append(">");
        return builder.toString();
    }
    }

// END
