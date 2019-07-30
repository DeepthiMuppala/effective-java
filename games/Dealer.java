import java.util.*;

class Dealer {
  private Dealer() {
  }

  private int faceValueCount = 0;
  Card card1;
  PlayUtil playUtil;
  public static Dealer getDealerInstance() {
    return new Dealer();
  }

  public void initialize(Deck deck, PlayUtil playUtil) {
    this.playUtil = playUtil;
    System.out.println("Initializing Dealer: ");
    card1 = deck.randomCard();
    Card card2 = deck.randomCard();
    faceValueCount = playUtil.handleCount(card1, faceValueCount);
    faceValueCount = playUtil.handleCount(card2, faceValueCount);
    System.out.println(card2);
  }

  public Integer play(Deck deck) {
    System.out.println("Card 1: " + card1);
    while (faceValueCount < 18) {
      Card card = deck.randomCard();
      System.out.println(card);
      faceValueCount = playUtil.handleCount(card, faceValueCount);
      faceValueCount = playUtil.checkWinLooseCondition(faceValueCount);
    }
    return faceValueCount;
  }
}
