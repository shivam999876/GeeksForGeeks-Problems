class Solution {

    public List<String> validParenthesis(String s) {

        Set<String> resultSet = new HashSet<>();

        if (s == null || s.length() == 0) {
            resultSet.add("");
            return new ArrayList<>(resultSet);
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.offer(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                String curr = queue.poll();

                if (isValid(curr)) {
                    resultSet.add(curr);
                    found = true;
                }

                // Once valid strings are found at current level,
                // don't generate next level strings
                if (found)
                    continue;

                for (int j = 0; j < curr.length(); j++) {

                    char ch = curr.charAt(j);

                    if (ch != '(' && ch != ')')
                        continue;

                    String next =
                            curr.substring(0, j) +
                            curr.substring(j + 1);

                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }

            // Stop BFS after processing current level
            if (found)
                break;
        }

        List<String> ans = new ArrayList<>(resultSet);

        // Required for GFG expected output order
        Collections.sort(ans);

        return ans;
    }

    private boolean isValid(String s) {

        int count = 0;

        for (char c : s.toCharArray()) {

            if (c == '(') {
                count++;
            } else if (c == ')') {

                count--;

                if (count < 0)
                    return false;
            }
        }

        return count == 0;
    }
}