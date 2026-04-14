class Solution {
    String removeSpaces(String s) {
        String res = "";
        for(int i = 0;i < s.length();i++){
            char a = s.charAt(i);
            if(a != ' ')
                res += a;
        }
        return res;
    }
}