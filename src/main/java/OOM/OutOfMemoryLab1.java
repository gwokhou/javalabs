package OOM;


import java.util.ArrayList;
import java.util.List;

/**
 * @author Gwok-hou
 */
public class OutOfMemoryLab1 {
    static class OOMObject {
    }
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
        }
    }
    // VM Options: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
    // （设置Java堆的最小值和最大值都为20MB，设置内存溢出异常时Dump当前内存堆转储快照）
    // java.lang.OutOfMemoryError: Java heap space
    // Dumping heap to java_pid1752.hprof ...
    // Heap dump file created [28130961 bytes in 0.110 secs]
    // Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
}
