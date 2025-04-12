//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // Number of test cases
        while (T-- > 0) {
            int n = sc.nextInt(); // Number of accounts
            ArrayList<ArrayList<String>> accounts = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt(); // Number of emails + name
                ArrayList<String> temp = new ArrayList<>();
                for (int j = 0; j < x; j++) {
                    temp.add(sc.next()); // Read name/emails
                }
                accounts.add(temp);
            }

            // Calling the accountsMerge function
            Solution obj = new Solution();
            ArrayList<ArrayList<String>> res = obj.accountsMerge(accounts);

            // Sorting individual accounts' emails
            for (int i = 0; i < res.size(); i++) {
                Collections.sort(res.get(i));
            }

            // Sorting the entire list exactly like C++'s sort(res.begin(), res.end());
            Collections.sort(res, new Comparator<ArrayList<String>>() {
                @Override
                public int compare(ArrayList<String> a, ArrayList<String> b) {
                    int al = a.size();
                    int bl = b.size();
                    int min = Math.min(al, bl);
                    for (int i = 0; i < min; i++) {
                        int cmp = a.get(i).compareTo(b.get(i));
                        if (cmp < 0) return -1;
                        if (cmp > 0) return 1;
                    }
                    if (al < bl) return -1;
                    if (al > bl) return 1;
                    return -1; // Exact match with C++ behavior
                }
            });

            // Printing the output in the required format
            System.out.print("[");
            for (int i = 0; i < res.size(); i++) {
                System.out.print("[");
                for (int j = 0; j < res.get(i).size(); j++) {
                    if (j != res.get(i).size() - 1) {
                        System.out.print(res.get(i).get(j) + ", ");
                    } else {
                        System.out.print(res.get(i).get(j));
                    }
                }
                if (i != res.size() - 1) {
                    System.out.println("], ");
                } else {
                    System.out.print("]");
                }
            }
            System.out.println("]");
            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static ArrayList<ArrayList<String>> accountsMerge(ArrayList<ArrayList<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();
        Map<String, String> parent = new HashMap<>();

        for (ArrayList<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                emailToName.put(email, name);
                parent.putIfAbsent(email, email);
                union(parent, account.get(1), email);
            }
        }

        Map<String, TreeSet<String>> unions = new HashMap<>();

        for (String email : parent.keySet()) {
            String root = find(parent, email);
            unions.computeIfAbsent(root, x -> new TreeSet<>()).add(email);
        }

        ArrayList<ArrayList<String>> result = new ArrayList<>();

        for (String root : unions.keySet()) {
            ArrayList<String> merged = new ArrayList<>();
            merged.add(emailToName.get(root));
            merged.addAll(unions.get(root));
            result.add(merged);
        }

        return result;
    }

    static String find(Map<String, String> parent, String email) {
        if (!parent.get(email).equals(email)) {
            parent.put(email, find(parent, parent.get(email)));
        }
        return parent.get(email);
    }

    static void union(Map<String, String> parent, String a, String b) {
        String rootA = find(parent, a);
        String rootB = find(parent, b);
        if (!rootA.equals(rootB)) {
            parent.put(rootB, rootA);
        }
    }
}
