import java.util.*;

class BlackJackUtil {
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

  public static int checkWinLooseCondition(int faceValueCount, int aceCount) {
    System.out.println("faceValueCount " + faceValueCount);
    if (faceValueCount > 21 && aceCount > 0) {
      faceValueCount -= aceCount * 10;
      aceCount = 0;
      return BlackJackUtil.checkWinLooseCondition(faceValueCount, aceCount);
    }
    return faceValueCount;
  }
}
