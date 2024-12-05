package io.emanmacario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class DecemberOnePartTwo {
    public static void main(String[] args) {
        String filePath = "src\\io\\emanmacario\\nums.txt";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            List<Integer> left = new ArrayList<>();
            Map<Integer, Integer> counts = new HashMap<>();

            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" {3}");
                int firstInt = Integer.parseInt(parts[0]);
                left.add(firstInt);

                int secondInt = Integer.parseInt(parts[1]);
                if (!counts.containsKey(secondInt)) {
                    counts.put(secondInt, 1);
                } else {
                    Integer currentCount = counts.get(secondInt);
                    counts.put(secondInt, currentCount + 1);
                }
            }

            Integer total = 0;
            for (Integer n: left) {
                System.out.println("Left: " + n + " Count: " + counts.get(n));
                total += n * counts.getOrDefault(n, 0);
            }
            System.out.println("Total: " + total);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
