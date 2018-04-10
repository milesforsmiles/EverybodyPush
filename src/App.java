
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
        System.out.println("Russell has a great beard");
        
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
    
    public static String toHumanTime(String time) {
        HashMap<Integer, String> minutes = new HashMap<>();
        minutes.put(1, "one");
        minutes.put(2, "two");
        minutes.put(3, "three");
        minutes.put(4, "four");
        minutes.put(5, "five");
        minutes.put(6, "six");
        minutes.put(7, "seven");
        minutes.put(8, "eight");
        minutes.put(9, "nine");
        minutes.put(10, "ten");
        minutes.put(11, "eleven");
        minutes.put(12, "twelve");
        minutes.put(13, "thirteen");
        minutes.put(14, "fourteen");
        minutes.put(15, "fifteen");
        minutes.put(16, "sixteen");
        minutes.put(17, "seventeen");
        minutes.put(18, "eighteen");
        minutes.put(19, "nineteen");
        minutes.put(20, "twenty");
        minutes.put(21, "twenty-one");
        minutes.put(22, "twenty-two");
        minutes.put(23, "twenty-three");
        minutes.put(24, "twenty-four");
        minutes.put(25, "twenty-five");
        minutes.put(26, "twenty-six");
        minutes.put(27, "twenty-seven");
        minutes.put(28, "twenty-eight");
        minutes.put(29, "twenty-nine");
        minutes.put(30, "thirty");  
        minutes.put(59, "one");
        minutes.put(58, "two");
        minutes.put(57, "three");
        minutes.put(56, "four");
        minutes.put(55, "five");
        minutes.put(54, "six");
        minutes.put(53, "seven");
        minutes.put(52, "eight");
        minutes.put(51, "nine");
        minutes.put(50, "ten");
        minutes.put(49, "eleven");
        minutes.put(48, "twelve");
        minutes.put(47, "thirteen");
        minutes.put(46, "fourteen");
        minutes.put(45, "fifteen");
        minutes.put(44, "sixteen");
        minutes.put(43, "seventeen");
        minutes.put(42, "eighteen");
        minutes.put(41, "nineteen");
        minutes.put(40, "twenty");
        minutes.put(39, "twenty-one");
        minutes.put(38, "twenty-two");
        minutes.put(37, "twenty-three");
        minutes.put(36, "twenty-four");
        minutes.put(35, "twenty-five");
        minutes.put(34, "twenty-six");
        minutes.put(33, "twenty-seven");
        minutes.put(32, "twenty-eight");
        minutes.put(31, "twenty-nine");
        minutes.put(30, "thirty");
        
        String delims = "[ apm:]";

        String[] numbers = time.split(delims);
        
        
        if (Integer.parseInt(numbers[0]) == 0 || Integer.parseInt(numbers[0]) == 12) {
            switch (Integer.parseInt(numbers[1])) {
                case 30:
                    return "half past twelve";
                case 0:
                    return "twelve o'clock";
                case 15:
                    return "quarter past twelve";
                case 45:
                    return "quarter to one";
            }
            if (Integer.parseInt(numbers[1]) == 1) {
                return minutes.get(Integer.parseInt(numbers[1])) + " minute past twelve";
            }
            else if (Integer.parseInt(numbers[1]) == 59) {
                return minutes.get(Integer.parseInt(numbers[1])) + " minute to one";
            }
            else if (Integer.parseInt(numbers[1]) < 30) {
                return minutes.get(Integer.parseInt(numbers[1])) + " minutes past twelve";
            } else if (Integer.parseInt(numbers[1]) > 30) {
                return minutes.get(Integer.parseInt(numbers[1])) + " minutes to one";
            }
        } else if (Integer.parseInt(numbers[0]) > 12) {
            switch (Integer.parseInt(numbers[1])) {
                case 30:
                    return "half past " + minutes.get(Integer.parseInt(numbers[0]) - 12);
                    
                case 0:
                    return minutes.get(Integer.parseInt(numbers[0]) - 12) + " o'clock";
                    
                case 15:
                    return "quarter past " + minutes.get(Integer.parseInt(numbers[0]) - 12);
                    
                case 45:
                    return "quarter to " + minutes.get(Integer.parseInt(numbers[0]) - 11);
                  
            }
            if (Integer.parseInt(numbers[1]) == 1) {
                return minutes.get(Integer.parseInt(numbers[1])) + " minute past " + minutes.get(Integer.parseInt(numbers[0]) - 12);
            }
            else if (Integer.parseInt(numbers[1]) == 59) {
                return minutes.get(Integer.parseInt(numbers[1])) + " minute to " + minutes.get(Integer.parseInt(numbers[0]) - 11);
            }
            else if (Integer.parseInt(numbers[1]) < 30) {
                return minutes.get(Integer.parseInt(numbers[1])) + " minutes past " + minutes.get(Integer.parseInt(numbers[0]) - 12);
            } else if (Integer.parseInt(numbers[1]) > 30) {
                return minutes.get(Integer.parseInt(numbers[1])) + " minutes to " + minutes.get(Integer.parseInt(numbers[0]) - 11);
            }

        } else if (Integer.parseInt(numbers[0]) < 12 && Integer.parseInt(numbers[0]) > 0) {
            switch (Integer.parseInt(numbers[1])) {
                case 30:
                    return "half past " + minutes.get(Integer.parseInt(numbers[0]));
                    
                case 0:
                    return minutes.get(Integer.parseInt(numbers[0])) + " o'clock";
                    
                case 15:
                    return "quarter past " + minutes.get(Integer.parseInt(numbers[0]));
                    
                case 45:
                    return "quarter to " + minutes.get(Integer.parseInt(numbers[0]) + 1);
                    
            }
            if (Integer.parseInt(numbers[1]) == 1) {
                return minutes.get(Integer.parseInt(numbers[1])) + " minute past " + minutes.get(Integer.parseInt(numbers[0]));
            }
            else if (Integer.parseInt(numbers[1]) == 59) {
                return minutes.get(Integer.parseInt(numbers[1])) + " minute to " + minutes.get(Integer.parseInt(numbers[0]) + 1);
            }
            else if (Integer.parseInt(numbers[1]) < 30) {
                return minutes.get(Integer.parseInt(numbers[1])) + " minutes past " + minutes.get(Integer.parseInt(numbers[0]));
            } else if (Integer.parseInt(numbers[1]) > 30) {
                return minutes.get(Integer.parseInt(numbers[1])) + " minutes to " + minutes.get(Integer.parseInt(numbers[0]) + 1);
            }
        }
        return "";
    }
    
}
