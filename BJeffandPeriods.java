
import java.util.*;

public class BJeffandPeriods {
    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();

    public static void main(String[] args) {
        Set<Integer> notValid = new HashSet<>(n);
        Map<Integer, Element> nums = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int inp = sc.nextInt();
            if (!notValid.contains(inp)) {
                Element existedElement = nums.get(inp);
                if (existedElement == null) {
                    Element element = new Element(inp);
                    element.addPos(i);
                    nums.put(inp, element);
                } else {
                    existedElement.addPos(i);
                    if (existedElement.positions.size() == 2) {
                        existedElement.diff = existedElement.positions.get(1) - existedElement.positions.get(0);
                    } else if (existedElement.positions.size() > 2) {
                        if (existedElement.diff
                                != existedElement.positions.get(existedElement.positions.size() - 1)
                                - existedElement.positions.get(existedElement.positions.size() - 2)) {
                            notValid.add(existedElement.num);
                            nums.remove(existedElement.num);
                        }
                    } else {
                        existedElement.diff = 0;
                        existedElement.num = inp;

                    }

                }
            }

        }


        System.out.println(nums.size());
        StringBuilder s = new StringBuilder("");
        nums.values().forEach(e -> s.append(e.num).append(" ").append(e.diff).append("\n"));
        System.out.println(s);
    }

    static class Element {
        public Element(int num) {
            this.num = num;
            positions = new ArrayList<>(n);
        }

        public Element(int num, int diff) {
            this.num = num;
            this.diff = diff;
            positions = new ArrayList<>(n);
        }

        int num;
        int diff;
        List<Integer> positions;

        public void addPos(Integer i) {
            positions.add(i);
        }

    }
}
