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

  public static int getFaceValue(Card c) {
    switch (c.face) {
      case TWO:
        return 2;
      case THREE:
        return 3;
      case FOUR:
        return 4;
      case FIVE:
        return 5;
      case SIX:
        return 6;
      case SEVEN:
        return 7;
      case EIGHT:
        return 8;
      case NINE:
        return 9;
      case TEN:
      case K:
      case Q:
      case J:
        return 10;
      case A:
       return 11;
       default:
        return -1;
    }
  }

  public String toString() {
    return face + " " + symbol;
  }
}
