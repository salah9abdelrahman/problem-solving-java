package graphs;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/***
 * link: https://onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=1393
 */
public class Marcus {
    static int testCasesNum;
    static final char START = '@';
    static final char END = '#';
    static String haven = "IEHOVA#";
    static char[][] grid;
    static int[] moves1 = new int[]{0, -1, 0};
    static int[] moves2 = new int[]{-1, 0, 1};

    static boolean validIndex(int i, int down, int j, int right) {
        return i >= 0 && j >= 0 && i < down && j < right;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        testCasesNum = sc.nextInt();
        for (int test = 0; test < testCasesNum; test++) {
            int down = sc.nextInt();
            int right = sc.nextInt();
            grid = new char[down][right];

            //init grid
            for (int i = 0; i < down; i++) {
                String s = sc.next();
                for (int j = 0; j < right; j++) {
                    grid[i][j] = s.charAt(j);
                }
            }


            for (int i = 0; i < right; i++) {
                //get the start position @
                if (grid[down - 1][i] == START) {
                    dfs( down - 1, i,  down, right);
                    break;
                }
            }

        }
    }

    static void dfs(int downIndex, int rightIndex, int down, int right) {
        String tempHaven = haven;

        char curr = grid[downIndex][rightIndex];
        ArrayList<String> steps = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        stack.add(curr);
        while (!stack.isEmpty()) {
            curr = stack.pop();
            // left -> top -> right
            for (int k = 0; k < 3; k++) {
                int xi = moves1[k] + downIndex;
                int ji = moves2[k] + rightIndex;
                if (validIndex(xi, down, ji, right)
                        && tempHaven.contains(String.valueOf(grid[xi][ji]))) {
                    char next = grid[xi][ji];

                    stack.add(next);
                    tempHaven = tempHaven.replace(String.valueOf(next), "");
                    //left or right
                    if (downIndex == xi) {
                        if (rightIndex > ji) {
                            steps.add("left");
                        } else {
                            steps.add("right");
                        }
                    }
                    //forward
                    else {
                        steps.add("forth");
                    }
                    downIndex = xi;
                    rightIndex = ji;
                    break;
                }

            }

        }



        for (String step:steps
             ) {
            System.out.print(step + " ");
        }
        System.out.println();

    }
}
