/*
 * @lc app=leetcode id=273 lang=java
 *
 * [273] Integer to English Words
 */

// @lc code=start
class Solution {

    private String[] singles = new String[]{"Zero", "One", "Two", "Three", "Four", "Five",
                                            "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
                                            "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen",
                                            "Seventeen", "Eighteen", "Nineteen"};
    private String[] doubles = new String[]{"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy",
                                            "Eighty", "Ninety"};
    private String[] units = new String[]{"Thousand", "Million", "Billion"};
     
    public String numberToWords(int num) {
        String result = "";

        if (num < 1000) return convertNum(num);

        int c = -1;
        while (num != 0) {
            int v = num % 1000;
            if (v != 0) {
                if (!result.equals("")) result = " " + result;
                if (c >= 0) result = convertNum(v) + " " + units[c] + result;
                else result = convertNum(v) + result;
            }
            num = num / 1000;
            c++;
        }
        
        return result;
    }

    public String convertNum(int num) {
        if (num == 0) return "Zero";

        String result = "";
        if (num >= 100) {
            int h = num / 100;
            result = singles[h] + " Hundred";
            num = num % 100;
            if (num == 0) return result;
        }

        String addition = "";
        if (num >= 20) {
            int d = num / 10;
            addition = result.equals("") ? doubles[d - 2] : (" " + doubles[d - 2]);
            num = num % 10;
            if (num != 0) addition += (" " + singles[num]);
        } else {
            addition = result.equals("") ? singles[num] : (" " + singles[num]);
        }
        result += addition;

        return result;
    }
}
// @lc code=end
