import java.util.*;
import java.util.stream.Collectors;

public class Dictionary {
  private Map<String, Object> elements = new HashMap<String, Object>();

  private Dictionary(Builder builder) {
    elements =  builder.dict.entrySet()
    .stream()
    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
  }

  @Override
  public String toString() {
    StringBuilder str = new StringBuilder("{\n");
    for (String key : elements.keySet()) {
      String[] valueStrLines = elements.get(key).toString().split("\\r?\\n");
      str.append("\t\"" + key + "\" : " + valueStrLines[0] + "\n");
      for (int i = 1; i < valueStrLines.length; i++)
        str.append("\t" + valueStrLines[i] + "\n");
    }
    str.append("}");
    return str.toString();
  }

  public static Builder createObjectBuilder() {
    return new Builder();
  }

  public void printDictionary() {
    System.out.println(this);
  }

  public static class Builder {
    private Map<String, Object> dict = new HashMap<String, Object>();

    public Builder addString(String key, String value) {
      dict.put(key, value);
      return this;
    }

    public Builder addInteger(String key, Integer value) {
      dict.put(key, value);
      return this;
    }

    public Builder addDictionary(String key, Dictionary value) {
      dict.put(key, value);
      return this;
    }

    public Dictionary build() {
      return new Dictionary(this);
    }
  }
}
