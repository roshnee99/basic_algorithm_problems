package coding_assessment;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'deliveryPlan' function below.
     *
     * The function is expected to return a 2D_INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. 2D_INTEGER_ARRAY allLocations
     *  2. INTEGER numDeliveries
     */

    private static final List<Integer> CENTER = Arrays.asList(0, 0);

    public static List<List<Integer>> deliveryPlan(List<List<Integer>> allLocations, int numDeliveries) {
        // Write your code here

        // basic concept is simple -- you sort all the distances in a queue and can retrieve the closest ones each time
        // actually question just says from start, so much simpler than I thought, just use a p queue
        // so can start with a greedy search
        List<List<Integer>> closestDistances = new ArrayList<>();
        Queue<List<Integer>> sortedQueue = new PriorityQueue<>(new DistanceComparator());
        sortedQueue.addAll(allLocations);
        for (int i = 1; i <= numDeliveries; i++) {
            closestDistances.add(sortedQueue.poll());
        }
        return closestDistances;
    }

    private static double getDistance(List<Integer> dest) {
        return Math.sqrt(Math.pow(dest.get(0), 2) + Math.pow(dest.get(1), 2));
    }

    static class DistanceComparator implements Comparator {

        public int compare(Object coor1, Object coor2) {
            // add checks here
            List<Integer> coordinate1 = (List<Integer>) coor1;
            List<Integer> coordinate2 = (List<Integer>) coor2;
            double distance1 = Result.getDistance(coordinate1);
            double distance2 = Result.getDistance(coordinate2);
            if (distance1 > distance2) {
                return 1;
            }
            if (distance1 == distance2) {
                if (coordinate1.get(0) < coordinate2.get(0)) {
                    return 1;
                }
                return -1;
            }
            return -1;
        }
    }

}

class Solution {
    public static void main(String[] args) throws IOException {

        List<List<Integer>> allLocations = Arrays.asList(
                Arrays.asList(1, -3), Arrays.asList(1, 2), Arrays.asList(3, 4)
        );

        List<List<Integer>> sorted = Result.deliveryPlan(allLocations, 2);

        for (List<Integer> coor : sorted) {
            System.out.println(coor.get(0) + ",  " + coor.get(1));
        }

//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int allLocationsRows = Integer.parseInt(bufferedReader.readLine().trim());
//        int allLocationsColumns = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<List<Integer>> allLocations = new ArrayList<>();
//
//        IntStream.range(0, allLocationsRows).forEach(i -> {
//            try {
//                allLocations.add(
//                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                                .map(Integer::parseInt)
//                                .collect(toList())
//                );
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//
//        int numDeliveries = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<List<Integer>> result = Result.deliveryPlan(allLocations, numDeliveries);
//
//        result.stream()
//                .map(
//                        r -> r.stream()
//                                .map(Object::toString)
//                                .collect(joining(" "))
//                )
//                .map(r -> r + "\n")
//                .collect(toList())
//                .forEach(e -> {
//                    try {
//                        bufferedWriter.write(e);
//                    } catch (IOException ex) {
//                        throw new RuntimeException(ex);
//                    }
//                });
//
//        bufferedReader.close();
//        bufferedWriter.close();
    }
}
