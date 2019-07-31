import java.util.*;

class PlayUtil {
  public static int checkWinLooseCondition(int faceValueCount, int aceCount) {
    System.out.println("faceValueCount " + faceValueCount);
    if (faceValueCount > 21 && aceCount > 0) {
      faceValueCount -= aceCount * 10;
      aceCount = 0;
      return PlayUtil.checkWinLooseCondition(faceValueCount, aceCount);
    }
    return faceValueCount;
  }
}
