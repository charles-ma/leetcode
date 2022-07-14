/*
 * @lc app=leetcode id=1604 lang=java
 *
 * [1604] Alert Using Same Key-Card Three or More Times in a One Hour Period
 */

// @lc code=start
class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        TreeMap<String, List<String>> times = new TreeMap<>();
        for (int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            String time = keyTime[i];
            List<String> l = times.getOrDefault(name, new ArrayList<String>());
            l.add(time);
            times.put(name, l);
        }

        List<String> result = new ArrayList<String>();
        for (String key : times.keySet()) {
            List<String> l = times.get(key);
            Collections.sort(l);
            if (l.size() < 3) continue;

            int p = 0;
            for (int i = 2; i < l.size(); i++) {
                String curr = l.get(i);
                if (withinOneHour(curr, l.get(p))) {
                    result.add(key);
                    break;
                } else {
                    p++;
                }
            }
        }
        
        return result;
    }

    private boolean withinOneHour(String t1, String t2) {
        return toMin(t1) - toMin(t2) <= 60;
    }

    private int toMin(String t) {
        String[] parts = t.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}
// @lc code=end
