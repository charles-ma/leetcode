import java.util.*;

public class Combination {
    private List<String> result = new ArrayList<String>();
    
    public static void main(String... args) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("a", 3);
        map.put("b", 1);
            
        List<String> result = new Combination().solve(map);
        for (String r : result) System.out.println(r);
    }

    private List<String> solve(Map<String, Integer> map) {
        helper(map, "");
        return result;
    }

    private void helper(Map<String, Integer> map, String curr) {
        if (isEmpty(map)) {
            result.add(curr);
            return;
        }

        for (String k : map.keySet()) {
            int v = map.get(k);
            if (v == 0) continue;

            map.put(k, v - 1);
            helper(map, curr + k);
            map.put(k, v);
        }
    }

    private boolean isEmpty(Map<String, Integer> map) {
        for (String k : map.keySet()) {
            if (map.get(k) != 0) return false; 
        }
        return true;
    }
}
