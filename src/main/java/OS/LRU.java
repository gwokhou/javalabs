package OS;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Guo-hao Zhang
 */
public class LRU<T> {
    private final int capacity;
    private final LinkedHashMap<String, T> linkedHashMap;

    public LRU(int capacity) {
        this.capacity = capacity;
        this.linkedHashMap = new LinkedHashMap<String, T>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, T> eldest) {
                return size() > capacity;
            }
        };
    }

    public T get(String key) {
        return linkedHashMap.get(key);
    }

    public void set(String key, T value) {
        linkedHashMap.put(key, value);
    }
}
