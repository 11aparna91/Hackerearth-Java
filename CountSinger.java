import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class CountSinger {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int number = Integer.parseInt(input);
        Map<Long, Integer> myMap = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        // Read the entire line
        String line = br.readLine();

        // Process space-separated integers
        String[] numbers = line.split(" ");
        for (int i = 0; i < number; i++) {
            Long num = Long.parseLong(numbers[i]);
            if (myMap.containsKey(num)) {
                myMap.put(num, myMap.get(num) + 1);
            } else {
                myMap.put(num, 1);
            }
        }

        int maxVal = getMaxValue(myMap);
        System.out.println(getCountOfMaxValues(myMap, maxVal));
    }

    public static int getMaxValue(Map<Long, Integer> map) {
        int maxValue = Integer.MIN_VALUE;

        for (int value : map.values()) {
            if (value > maxValue) {
                maxValue = value;
            }
        }

        return maxValue;
    }

    public static int getCountOfMaxValues(Map<Long, Integer> map, int maxValue) {
        int count = 0;

        for (int value : map.values()) {
            if (value == maxValue) {
                count++;
            }
        }

        return count;
    }
}
