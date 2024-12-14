//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            // Read values array
            String[] valueInput = br.readLine().trim().split(" ");
            List<Integer> values = new ArrayList<>();
            for (String s : valueInput) {
                values.add(Integer.parseInt(s));
            }

            // Read weights array
            String[] weightInput = br.readLine().trim().split(" ");
            List<Integer> weights = new ArrayList<>();
            for (String s : weightInput) {
                weights.add(Integer.parseInt(s));
            }

            // Read the knapsack capacity
            int w = Integer.parseInt(br.readLine().trim());

            // Call fractionalKnapsack function and print result
            System.out.println(String.format(
                "%.6f", new Solution().fractionalKnapsack(values, weights, w)));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(List<Integer> values, List<Integer> weights, int W) {
        int n = values.size();
        List<Item> items = new ArrayList<>();

        // Creating a list of items (value, weight)
        for (int i = 0; i < n; i++) {
            items.add(new Item(values.get(i), weights.get(i)));
        }

        // Sorting items on the basis of value/weight ratio.
        items.sort(new ItemComparator());

        // Taking variable for current weight in knapsack.
        int curWeight = 0;
        double finalValue = 0.0;

        // Iterating over all the items.
        for (Item item : items) {
            // If current weight + item's weight is less than or equal to W,
            // then add the item's value to final value.
            if (curWeight + item.weight <= W) {
                curWeight += item.weight;
                finalValue += item.value;
            }
            // Otherwise, take the fraction of the item's value
            // based on the remaining weight in the knapsack.
            else {
                int remain = W - curWeight;
                finalValue += item.value * ((double)remain / item.weight);
                break;
            }
        }
        // Returning the final value.
        return finalValue;
    }
}

class Item {
    int value, weight;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }
}

class ItemComparator implements Comparator<Item> {
    // Comparison function to sort items according to value/weight ratio.
    public int compare(Item a, Item b) {
        double r1 = (double)a.value / a.weight;
        double r2 = (double)b.value / b.weight;
        return Double.compare(r2, r1); // Descending order by value/weight ratio
    }
}