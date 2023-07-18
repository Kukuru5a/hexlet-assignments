package exercise;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;

// BEGIN
public class PairedTag extends Tag{
    String body;
    Map<String, String> attributes;
    List<Tag> inheritedTags;

    public PairedTag(String tagName, Map<String, String> attributes, String body, List<Tag> inheritedTags) {
        super(tagName);
        this.body = body;
        this.attributes = attributes;
        this.inheritedTags = inheritedTags;
    }

    public String getBody() {
        return body;
    }

    public List<Tag> getInheritedTags() {
        return inheritedTags;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setInheritedTags(ArrayList<Tag> inheritedTags) {
        this.inheritedTags = inheritedTags;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("<");
        builder.append(tagName);
        for (Map.Entry<String, String> kk : attributes.entrySet()) {
            builder.append(" " + kk.getKey() + "=\"" + kk.getValue() + "\"");
        }
        builder.append(">");
        for (Tag tag : inheritedTags) {
            builder.append(tag.toString());
        }
        builder.append(body).append("</" + tagName + ">");

        return builder.toString();
    }
}
// END
