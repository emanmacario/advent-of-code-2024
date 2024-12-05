package io.emanmacario;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.PriorityQueue;

public class DecemberOnePartOne {

    public static void main(String[] args) {
        String filePath = "src\\io\\emanmacario\\nums.txt";

        PriorityQueue<Integer> p1 = new PriorityQueue<>();
        PriorityQueue<Integer> p2 = new PriorityQueue<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" {3}");
                int firstInt = Integer.parseInt(parts[0]);
                p1.add(firstInt);

                int secondInt = Integer.parseInt(parts[1]);
                p2.add(secondInt);
            }

            Integer total = 0;
            while (!p1.isEmpty() && !p2.isEmpty()) {
                Integer p1Min  = p1.poll();
                Integer p2Min  = p2.poll();

                Integer absDiff = Math.abs(p1Min - p2Min);
                total += absDiff;
            }
            System.out.println("Total: " + total);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
