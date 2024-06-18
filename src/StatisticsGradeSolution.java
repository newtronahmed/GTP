import java.util.Arrays;
import java.util.Scanner;
public class StatisticsGradeSolution {
    public static void main(String[] args){
        int[] scores = readScores();
        int maxGrade = calculateMaxGrade(scores);
        int minGrade = calculateMinGrade(scores);
        double avgGrade = calculateAvgGrade(scores);
        int[] stats = generateGradeDistribution(scores);
        printStats(minGrade, maxGrade,avgGrade);
        printBarGraph(stats);
    }
    public static int[] readScores(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter grades separated by spaces");
        String input = scanner.nextLine();
        String[] gradeStrings = input.split("\\s+");
        int[] scores = new int[gradeStrings.length];
        int count = 0;
        for (String gradeString : gradeStrings) {

            try{
                int score = Integer.parseInt(gradeString);
                if (score >= 0 && score <= 100) {
                    scores[count++] = score;
                } else {
                    System.out.println("Invalid grade: " + score + ". Please enter a value between 0 and 100.");
                }
            }catch (NumberFormatException e){
                System.out.println("Something is wrong with your input format");
            }
        }
        return scores;
    }
    public static int calculateMaxGrade(int[] scores){
        return Arrays.stream(scores).max().orElse(0);
    }

    public static int calculateMinGrade(int[] scores){
        return Arrays.stream(scores).min().orElse(0);
    }
    public static double calculateAvgGrade(int[] scores) {
        int sum = 0;
        for (int score: scores){
            sum+= score;
        }
        return (double) sum/scores.length;
    }
    private static int[] generateGradeDistribution(int[] scores) {
        int[] stats = new int[5];
        for (int score : scores) {
            if (score >= 80) {
                stats[4]++;
            } else if (score >= 60) {
                stats[3]++;
            } else if (score >= 40) {
                stats[2]++;
            } else if (score >= 20) {
                stats[1]++;
            } else {
                stats[0]++;
            }
        }
        return stats;
    }

    private static void printBarGraph(int[] stats) {
        System.out.println("Graph:\n");
        int maxCount = getMaxCount(stats);
        for (int i = maxCount; i > 0; i--) {
            System.out.printf("%2d >", i);
            for (int j = 0; j < stats.length; j++) {
                if (stats[j] >= i) {
                    System.out.print("  ####### ");
                } else {
                    System.out.print("          ");
                }
            }
            System.out.println();
        }
        System.out.println("   +-----------+---------+---------+---------+---------+");
        System.out.println("   I   0-20    I  21-40  I  41-60  I  61-80  I  81-100 I");

    }
    private static int getMaxCount(int[] stats) {

        int maxCount = 0;
        for (int count : stats) {
            if (count > maxCount) {
                maxCount = count;
            }
        }
        return maxCount;
    }
    private static void printStats (int minGrade, int maxGrade, double avgGrade){
        String formattedAvg = String.format("%.6f",avgGrade);
        System.out.println("\nValues:\n\nThe maximum grade is " + maxGrade + "\nThe minimum grade is " + minGrade + "\nThe average grade is " + formattedAvg);
        System.out.println();
        System.out.println();

    }
}