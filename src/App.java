
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author derek
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Qhhsodf");
        System.out.println("Bleee bloop blue blue blah");
        System.out.println("I F**king hate this");
        System.out.println("NICK");
        System.out.println("I added all the shit from russell");
        
    }
    
    public static int solution(int[] a) {
        int position = 0;
        int jumps = 0;
        if (a.length == 0) {
            return -1;
        }
        while (position >= 0 && position < a.length) {
            if (a[position] == 0) {
                return -1;
            }
            if (jumps >= 100) {
                return -1;
            }
            position = position + a[position];
            jumps++;
        }
        System.out.println(jumps + "");
        return jumps;
    }

    public static List<Long> sumDigPow(long a, long b) {
        List<Long> filter = new ArrayList<>();

        for (int i = (int) a; i <= (int) b; i++) {

            if (i < 10 && i > -10) {
                filter.add((long) i);
                continue;
            }

            if (i >= 10) {
                String number = "" + i;
                int num = 0;
                for (int j = 0; j < number.length(); j++) {
                    num += Math.pow(Integer.parseInt(number.substring(j, j + 1)), j + 1);
                }

                if (i == num) {
                    filter.add((long) i);
                }
            }
        }

        return (List) filter;
    }

    public static int[] deleteNth(int[] elements, int maxOccurrences) {
        if (maxOccurrences == 0) {
            int[] a = new int[0];
            return a;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> nums = new ArrayList<>();

        for (int i : elements) {
            if (map.containsKey(i)) {
                if (map.get(i) == maxOccurrences) {
                    continue;
                }
                map.replace(i, map.get(i), map.get(i) + 1);
            } else if (!map.containsKey(i)) {
                map.put(i, 1);
            }
        }

        for (int i : elements) {
            if (map.get(i) > 0) {
                map.replace(i, map.get(i), map.get(i) - 1);
                nums.add(i);
            }
        }
        int[] out = new int[nums.size()];

        for (int i = 0; i < nums.size(); i++) {
            out[i] = nums.get(i);
        }

        return out;
    }

    public static int solve(int x, int y) {
        ArrayList<Integer> range = new ArrayList<>();
        ArrayList<Integer> counted = new ArrayList<>(); // delete this later
        int counter = 0;
        for (int i = x; i <= y; i++) {
            range.add(i);
        }
        for (int i : range) {
            if (i == 1 || i == 8 || i == 0) {
                counted.add(i);
                counter++;
                continue;
            }

            String num = "" + i;
            String numReversed = "";
            OUTER:
            for (int j = num.length(); j > 0; j--) {
                switch (Integer.parseInt(num.substring(j - 1, j))) {
                    case 1:
                    case 8:
                    case 0:
                        numReversed += num.substring(j - 1, j);
                        continue;
                    case 6:
                        numReversed += "9";
                        continue;
                    case 9:
                        numReversed += "6";
                        continue;
                    default:
                        break OUTER;
                }
            }
            if (numReversed.length() == num.length() && Integer.parseInt(num) == Integer.parseInt(numReversed)) {

                counted.add(i);
                counter++;
            }
        }
        System.out.println(counted);
        System.out.println(counter);

        return counter;

    }
    
}
