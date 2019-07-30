class Card {
  String faceValue;
  Deck.Symbol symbol;

  public Card(String facevalue, Deck.Symbol symbol) {
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
