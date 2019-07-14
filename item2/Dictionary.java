import java.util.*;

public class Dictionary {
  private Map<String, Object> dict = new HashMap<String, Object>();

  private Dictionary(Builder builder) {
    dict = builder.dict;
  }

  @Override
  public String toString() {
    String str = "{\n";
    for (String key : dict.keySet()) {
      String[] valueStrLines = dict.get(key).toString().split("\\r?\\n");
      str += "\t\"" + key + "\" : " + valueStrLines[0] + "\n";
      for (int i = 1; i < valueStrLines.length; i++)
        str += "\t" + valueStrLines[i] + "\n";
    }
    str += ("}");
    return str;
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