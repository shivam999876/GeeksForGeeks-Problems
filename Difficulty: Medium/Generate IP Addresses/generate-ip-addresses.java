class Solution {
    private boolean isValid(String s) {
        int n = s.length();
        if (n == 1) return true;
        int val = Integer.parseInt(s);
        return s.charAt(0) != '0' && val <= 255;
    }
    private void generateIpRec(String s, int index, String curr, int cnt, ArrayList<String> res) {
        String temp = "";
        if (index >= s.length()) return;
        if (cnt == 3) {
            temp = s.substring(index);
            if (temp.length() <= 3 && isValid(temp)) {
                res.add(curr + temp);
            }
            return;
        }
        for (int i = index; i < Math.min(index + 3, s.length()); i++) {
            temp += s.charAt(i);
            if (isValid(temp)) {
                generateIpRec(s, i + 1, curr + temp + ".", cnt + 1, res);
            }
        }
    }
    public ArrayList<String> generateIp(String s) {
        ArrayList<String> res = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) return res;
        generateIpRec(s, 0, "", 0, res);
        return res;
    }
}