package OOM;

/**
 * @author Gwok-hou
 */
public class StackOverflowLab1 {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        StackOverflowLab1 lab1 = new StackOverflowLab1();
        try {
            lab1.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length: " + lab1.stackLength);
            throw e;
        }
    }
    // VM Options: -Xss128k
}
