import java.util.*;

class Dealer {
  private Dealer() {
  }

  private int faceValueCount = 0;
  Card card1;
  private int aceCount = 0;
  public static Dealer getDealerInstance() {
    return new Dealer();
  }

  public void initialize(Deck deck) {
    System.out.println("Initializing Dealer: ");
    card1 = deck.randomCard();
    Card card2 = deck.randomCard();
    
    if(card1.face == Card.Face.A){
      aceCount++;
    }
    if(card2.face == Card.Face.A){
      aceCount++;
    }
    faceValueCount += Card.getFaceValue(card1);
    faceValueCount += Card.getFaceValue(card2);
    System.out.println(card2);
  }

  public void play(Deck deck) {
    System.out.println("Card 1: " + card1);
    while (faceValueCount < 18) {
      Card card = deck.randomCard();
      if(card.face == Card.Face.A){
        aceCount++;
      }
      System.out.println(card);
      faceValueCount += Card.getFaceValue(card);
      faceValueCount = PlayUtil.checkWinLooseCondition(faceValueCount, aceCount);
    }
  }

  public int getCurrentCount(){
    return faceValueCount;
  }
}
