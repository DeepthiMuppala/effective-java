class Card {
  String faceValue;
  Symbol symbol;

  public enum Symbol {
    DIAMOND, HEART, SPADE, CLUB;
  }

  public static String[] values = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "K", "Q", "J", "A" };
  public Card(String facevalue, Symbol symbol) {
    this.faceValue = facevalue;
    this.symbol = symbol;
  }

  public String getFaceValue() {
    return this.faceValue;
  }

  public String toString() {
    return faceValue + " " + symbol;
  }
}
