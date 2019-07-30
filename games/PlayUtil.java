import java.util.*;

class PlayUtil {
  private int aceCount = 0;
  String[] highCards = { "K", "J", "Q", "A" };
  Set<String> set = new HashSet<>(Arrays.asList(highCards));

  public int handleCount(Card card, int faceValueCount) {
    int value;
    if (set.contains(card.getFaceValue())) {
      if (card.getFaceValue().equals("A")) {
        aceCount++;
      }
      faceValueCount += 10;
    } else {
      value = Integer.parseInt(card.getFaceValue());
      faceValueCount += value;
    }
    return faceValueCount;
  }

  public int checkWinLooseCondition(int faceValueCount) {
    System.out.println("faceValueCount " + faceValueCount);
    if (faceValueCount > 21 && aceCount > 0) {
      faceValueCount -= ((aceCount * 10) + aceCount);
      aceCount = 0;
      return checkWinLooseCondition(faceValueCount);
    }
    return faceValueCount;
  }
}
