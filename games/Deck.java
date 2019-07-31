import java.util.Set;
import java.util.HashSet;

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
    Card.Symbol symbol = getSymbol();
    String type = Card.values[(int) Math.ceil(Math.random() * Card.values.length)-1];
    String symbolType = symbol + "," + type;
    String deckType = deck + "," + symbolType;
    Card card;
    if (cardSet.contains(deckType)) {
      card = randomCard();
    } else {
      InstanceFactory inst =  InstanceFactory.getFactoryInstance();
      card = inst.getCardInstance(type, symbol);
    }
    cardSet.add(deckType);
    return card;
  }

  public Card.Symbol getSymbol() {
    int i = (int) (Math.random() * (52 / 13));
    return Card.Symbol.values()[i];
  }
}
