import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
  static class Master {
    int callCount;
    String secretWord;

    Master(String secretWord) {
      this.secretWord = secretWord;
    }

    int guess(String word) {
      System.out.println("Master.guess() is called " + ++callCount + " times.");
      return getMatches(secretWord, word);
    }
  }

  private static final int ALL_MATCHED = 6;

  public void findSecretWord(String[] wordlist, Master master) {
    int n = wordlist.length;
    int[][] matchMatrix = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) { // TODO: j = i
        matchMatrix[i][j] = getMatches(wordlist[i], wordlist[j]);
      }
    }
    boolean[] visited = new boolean[n];
    Queue<Integer> possibleSecretIndices = new ArrayDeque<>();
    possibleSecretIndices.offer(0);
    visited[0] = true;
    while (!possibleSecretIndices.isEmpty()) {
      int guessIndex = possibleSecretIndices.poll();
      int matches = master.guess(wordlist[guessIndex]);
      if (matches == ALL_MATCHED) {
        break;
      }
      for (int index : matchMatrix[guessIndex]) {
        if (!visited[index] && getMatches(wordlist[index], wordlist[guessIndex]) == matches) {
          possibleSecretIndices.offer(index);
          visited[index] = true;
        }
      }
    }
  }

  // precondition: w1.length() == w2.length() == 6
  private static int getMatches(String w1, String w2) {
    int total = 0;
    for (int i = 0; i < w1.length(); i++) {
      if (w1.charAt(i) == w2.charAt(i)) {
        total++;
      }
    }
    return total;
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    Master master = new Master("hbaczn");
    String[] wordList = {
      "gaxckt", "trlccr", "jxwhkz", "ycbfps", "peayuf", "yiejjw", "ldzccp", "nqsjoa", "qrjasy",
      "pcldos", "acrtag", "buyeia", "ubmtpj", "drtclz", "zqderp", "snywek", "caoztp", "ibpghw",
      "evtkhl", "bhpfla", "ymqhxk", "qkvipb", "tvmued", "rvbass", "axeasm", "qolsjg", "roswcb",
      "vdjgxx", "bugbyv", "zipjpc", "tamszl", "osdifo", "dvxlxm", "iwmyfb", "wmnwhe", "hslnop",
      "nkrfwn", "puvgve", "rqsqpq", "jwoswl", "tittgf", "evqsqe", "aishiv", "pmwovj", "sorbte",
      "hbaczn", "coifed", "hrctvp", "vkytbw", "dizcxz", "arabol", "uywurk", "ppywdo", "resfls",
      "tmoliy", "etriev", "oanvlx", "wcsnzy", "loufkw", "onnwcy", "novblw", "mtxgwe", "rgrdbt",
      "ckolob", "kxnflb", "phonmg", "egcdab", "cykndr", "lkzobv", "ifwmwp", "jqmbib", "mypnvf",
      "lnrgnj", "clijwa", "kiioqr", "syzebr", "rqsmhg", "sczjmz", "hsdjfp", "mjcgvm", "ajotcx",
      "olgnfv", "mjyjxj", "wzgbmg", "lpcnbj", "yjjlwn", "blrogv", "bdplzs", "oxblph", "twejel",
      "rupapy", "euwrrz", "apiqzu", "ydcroj", "ldvzgq", "zailgu", "xgqpsr", "wxdyho", "alrplq",
      "brklfk"
    };
    solution.findSecretWord(wordList, master);
  }
}
