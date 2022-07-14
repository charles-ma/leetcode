import java.util.*;

public class InterleaveIterator {
    public static void main(String... args) {
        List<List<Integer>> l = new ArrayList<List<Integer>>();

        List<Integer> l1 = Arrays.asList(new Integer[]{1, 2, 3});
        List<Integer> l2 = Arrays.asList(new Integer[]{4, 5});
        List<Integer> l3 = Arrays.asList(new Integer[]{6});

        l.add(l1); l.add(l2); l.add(l3);

        InterleaveIterator iter = new InterleaveIterator(l);
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    private List<List<Integer>> list;
    private List<Integer> indices;
    private int curr = 0;
    
    public InterleaveIterator(List<List<Integer>> list) {
        this.list = list;
        this.indices = new ArrayList<Integer>();
        for (int i = 0; i < this.list.size(); i++) {
            this.indices.add(0);
        }

        while (curr < this.indices.size()) {
            int currIndex = this.indices.get(curr);
            if (currIndex >= this.list.get(curr).size()) curr++;
            else break;
        }

        if (curr == this.indices.size()) curr = -1;
    }

    public boolean hasNext() {
        return curr != -1;
    }

    public int next() {
        int currIndex = indices.get(curr);
        int r = list.get(curr).get(currIndex);

        indices.set(curr, currIndex + 1);
        int i = 1;
        while (i <= indices.size()) {
            int convertedIndex = (i + curr) % indices.size();
            int cIndex = indices.get(convertedIndex);

            if (cIndex < this.list.get(convertedIndex).size()) {
                curr = convertedIndex;
                break;
            }
            i++;
        }

        if (i > indices.size()) curr = -1;
        
        return r;
    }
}
