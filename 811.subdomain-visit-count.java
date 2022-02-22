/*
 * @lc app=leetcode id=811 lang=java
 *
 * [811] Subdomain Visit Count
 */

// @lc code=start
class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> m = new HashMap<String, Integer>();

        Stream<String> st = Arrays.stream(cpdomains);
        st.forEach(d -> {
                String[] parts = d.split(" ");
                int count = Integer.parseInt(parts[0]);
                String[] dParts = parts[1].split("\\.");

                String domain = "";
                for (int i = dParts.length - 1; i >= 0; i--) {
                    if (domain.isEmpty()) domain = dParts[i] + domain;
                    else domain = dParts[i] + "." + domain;
                    int c = m.getOrDefault(domain, 0);
                    m.put(domain, c + count);
                }
            });

        List<String> result = new ArrayList<String>();
        for (String key : m.keySet()) {
            result.add(m.get(key) + " " + key);
        }

        return result;
    }
}
// @lc code=end
