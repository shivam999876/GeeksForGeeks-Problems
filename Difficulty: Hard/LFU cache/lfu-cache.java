//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

public class LFUDesign {

    private static List<String> inputLine(Scanner sc) {
        return Arrays.asList(sc.nextLine().split(" "));
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());

        while (t-- > 0) {
            int capacity = Integer.parseInt(sc.nextLine());
            LFUCache cache = new LFUCache(capacity);

            int queries = Integer.parseInt(sc.nextLine());
            while (queries-- > 0) {
                List<String> vec = inputLine(sc);
                if (vec.get(0).equals("PUT")) {
                    int key = Integer.parseInt(vec.get(1));
                    int value = Integer.parseInt(vec.get(2));
                    cache.put(key, value);
                } else {
                    int key = Integer.parseInt(vec.get(1));
                    System.out.print(cache.get(key) + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class LFUCache {

    public Map<Integer, int[]> map = new LinkedHashMap<>();
    int capacity;

    public LFUCache(int cap) {
        capacity = cap;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int[] temp = map.get(key);
            temp[1]++;
            return temp[0];
        } else return -1;
    }

    public void put(int key, int value) 
    {
        if (capacity <= 0) 
        {
            return;
        }

        if (map.containsKey(key)) 
        {
            int[] temp = map.get(key);
            temp[0] = value;
            temp[1]++;
        }
        else 
        {
            if (map.size() >= capacity) 
                removeLeastFrequent();
            
            int[] temp = new int[2];
            temp[0] = value;
            temp[1] = 1;
            map.put(key, temp);
        }
    }

    private void removeLeastFrequent() {
        int minKey = -1;
        int minFrequency = Integer.MAX_VALUE;

        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            int frequency = entry.getValue()[1];
            if (frequency < minFrequency) {
                minFrequency = frequency;
                minKey = entry.getKey();
            }
        }

        if (minKey != -1) {
            map.remove(minKey);
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */