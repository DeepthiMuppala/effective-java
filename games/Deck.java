import java.util.*;

class Deck {
  // public enum Symbol {
  //   DIAMOND, HEART, SPADE, CLUB;
  // }

  // private String[] values = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "K", "Q", "J", "A" };

  private int num;

  private Deck(int num) {
    this.num = num;
  }

  Set<String> cardSet = new HashSet<String>();

  public static Deck getDeckInstance(int num) {
    return new Deck(num);
  }

  public String randomDeck() {
    return Integer.toString((int) Math.ceil(Math.random() * num));
  }

  public Card randomCard() {
    String deck = randomDeck();
    Card.Symbol symbol = getRandomSymbol();
    Card.Face face = getRandomFace();
    String symbolType = symbol + "," + face;
    String deckType = deck + "," + symbolType;
    Card card;
    if (cardSet.contains(deckType)) {
      card = randomCard();
    } else {
      InstanceFactory inst =  InstanceFactory.getFactoryInstance();
      card = inst.getCardInstance(face, symbol);
    }
    cardSet.add(deckType);
    return card;
  }

  public Card.Face getRandomFace() {
    int randomIndex = (int) Math.ceil((Math.random() * Card.Face.values().length)-1);
    return Card.Face.values()[randomIndex];
  }

  public Card.Symbol getRandomSymbol() {
    int i = (int) (Math.random() * (52 / 13));
    return Card.Symbol.values()[i];
  }
}
