
class Player {

  private Player() {
  }

  public static Player getPlayerInstance() {
    return new Player();
  }

  private int faceValueCount = 0;
  PlayUtil playUtil;

  public void initialize(Deck deck, PlayUtil playUtil) {
    this.playUtil = playUtil;
    System.out.println("Initializing Player: ");
    Card card1 = deck.randomCard();
    Card card2 = deck.randomCard();
    faceValueCount = playUtil.handleCount(card1, faceValueCount);
    faceValueCount = playUtil.handleCount(card2, faceValueCount);
    System.out.println(card1);
    System.out.println(card2);
  }

  public Integer hit(Deck deck) {
    Card card = deck.randomCard();
    System.out.println(card);
    faceValueCount = playUtil.handleCount(card, faceValueCount);
    faceValueCount = playUtil.checkWinLooseCondition(faceValueCount);
    return faceValueCount;
  }
}