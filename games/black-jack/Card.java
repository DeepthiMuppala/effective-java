class Card {
  Face face;
  Symbol symbol;
 
  public enum Symbol {
    DIAMOND, HEART, SPADE, CLUB;
  }

  public enum Face {
    TWO,
    THREE,
    FOUR,
    FIVE,
    SIX,
    SEVEN,
    EIGHT,
    NINE,
    TEN,
    K,
    Q,
    J,
    A;
  }

  public Card(Face face, Symbol symbol) {
    this.face = face;
    this.symbol = symbol;
  }

  public String toString() {
    return face + " " + symbol;
  }
}
