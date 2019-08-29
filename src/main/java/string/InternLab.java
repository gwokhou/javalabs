package string;

import java.util.Random;

/**
 * @author Guo-hao Zhang
 */
public class InternLab {
    public static void main(String[] args) {
        int trueCount = 0;
        int falseCount = 0;
        Random rand = new Random(System.currentTimeMillis());
        for (int n = 0; n < 10000; n++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 300; i++) {
                sb.append((char) (rand.nextInt(96) + 32));
            }
            String s = sb.toString().substring(100, 200);
            if (s.intern() == s) {
                trueCount++;
            } else {
                falseCount++;
            }
        }
        System.out.println("trueCount=" + trueCount + "\tfalseCount=" + falseCount);
    }
}
