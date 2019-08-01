
class Player {

  private Player() {
  }

  public static Player getPlayerInstance() {
    return new Player();
  }

  private int faceValueCount = 0;
  private int aceCount = 0;

  public void dealInitialCards(Deck deck) {
    System.out.println("Initializing Player: ");
    Card card1 = deck.randomCard();
    Card card2 = deck.randomCard();
    if(card1.face == Card.Face.A){
      aceCount++;
    }
    if(card2.face == Card.Face.A){
      aceCount++;
    }
    faceValueCount += BlackJackUtil.getFaceValue(card1);
    faceValueCount += BlackJackUtil.getFaceValue(card2);
    System.out.println(card1);
    System.out.println(card2);
  }

  public void hit(Deck deck) {
    Card card = deck.randomCard();
    if(card.face == Card.Face.A){
      aceCount++;
    }
    System.out.println(card);
    faceValueCount += BlackJackUtil.getFaceValue(card);
    faceValueCount = BlackJackUtil.checkWinLooseCondition(faceValueCount, aceCount);
  }

  public int getCurrentCount(){
    return faceValueCount;
  }
}
