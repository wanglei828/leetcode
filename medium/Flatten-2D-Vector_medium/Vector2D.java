/*
Implement an iterator to flatten a 2d vector.

For example,
Given 2d vector =

[
  [1,2],
  [3],
  [4,5,6]
]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].
*/

public class Vector2D implements Iterator<Integer> {

    List<List<Integer>> list = new ArrayList<List<Integer>>();
    int row = 0;
    int col = 0;
    public Vector2D(List<List<Integer>> vec2d) {
        for(List<Integer> sublist : vec2d) {
            list.add(sublist);
        }
    }

    @Override
    public Integer next() {
        return list.get(row).get(col++);
    }

    @Override
    public boolean hasNext() {
        if(list.isEmpty()) return false;
        if(col < list.get(row).size()) {
            return true;
        } else {
            col = 0;
            row++;
            while(row < list.size()) {
                if(!list.get(row).isEmpty()) {
                    return true;
                }
                row++;
            }
            return false;
        }
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
