// https://leetcode.com/problems/two-city-scheduling/description/
package greedy;

import java.util.PriorityQueue;

/**
 * @time O(n log n)
 * @space O(log n)
 */

 /*
        instead of using heap, we can use sort arrays by a-costs[i] - b-a-costs[i]
         Arrays.sort(costs, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0] - o1[1] - (o2[0] - o2[1]);
      }
    });

    int total = 0;
    int n = costs.length / 2;
    for (int i = 0; i < n; ++i) total += costs[i][0] + costs[i + n][1];
    return total;

         */
class TwoCitySchedulingSolution {
    public int twoCitySchedCost(int[][] costs) {
        int aNum = 0;
        int bNum = 0;
        int result = 0;
        int n = costs.length;


        PriorityQueue<Element> heap = new PriorityQueue<>(n);

        for (int i = 0; i < n; i++) {
            heap.add(new Element(costs[i][0], costs[i][1]));
        }

        while (!heap.isEmpty()) {
            Element e = heap.poll();
            if (e.isATheMin()) {
                if (aNum < n / 2) {
                    aNum++;
                    result += e.a;
                } else {
                    bNum++;
                    result += e.b;

                }
            } else {
                if (bNum < n / 2) {
                    bNum++;
                    result += e.b;
                } else {
                    aNum++;
                    result += e.a;

                }
            }
        }
        return result;
    }
}

class Element implements Comparable<Element> {
    int a;
    int b;
    int cost;

    Element(int a, int b) {
        this.a = a;
        this.b = b;
        this.cost = Math.max(a, b) - Math.min(a, b);
    }

    public boolean isATheMin() {
        return a < b;
    }

    @Override
    public int compareTo(Element e) {
        return e.cost - this.cost;
    }
}


public class TwoCityScheduling {
    public static void main(String[] args) {
        System.out.println(new TwoCitySchedulingSolution().twoCitySchedCost(
                new int[][]{
                        {259, 770}, {448, 54}, {926, 667}, {184, 139}, {840, 118}, {577, 469}
                }
        ));
    }
}

