import java.io.*;
import java.util.Scanner;

public class AdventureTime {

    /** This is the main method, and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        int challengeOneAnswer = challengeOne("./inputOneTwo.txt"),
            challengeTwoAnswer = challengeTwo("./inputOneTwo.txt"),
            challengeThreeAnswer = challengeThree("./inputThreeFour.txt"),
            challengeFourAnswer = challengeFour("./inputThreeFour.txt");
        /* Test
        writeFileAllAnswers(
                "AdventureTime.txt",
                challengeOneAnswer,
                challengeTwoAnswer,
                challengeThreeAnswer,
                challengeFourAnswer);
         */
        writeFileAllAnswers(
                "AdventureTime.txt",
                challengeOneAnswer,
                challengeTwoAnswer,
                challengeThreeAnswer,
                challengeFourAnswer);
    }

    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {
        int[] data = readFile(fileName);
        int count = 0;
        for (int i = 0; i < data.length-1; i++) {
            if (data[i+1]>data[i]) count++;
        }
        return count;
    }

    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        int[] data = readFile(fileName), sums = new int[data.length];
        int sumsC = 0, count = 0;
        for (int i  = 0; i < data.length-2; i++) {
            sums[i] = data[i]+data[i+1]+data[i+2];
        }
        for (int i = 0; i < sums.length-1; i++) if (sums[i+1]>sums[i]) count++;
        return count;
    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {
        int vert = 0, hor = 0;
        String[][] arr = readFileTwo(fileName);
        for (String[] j : arr) {
            switch (j[0]) {
                case "forward" -> hor+=Integer.parseInt(j[1]);
                case "down" ->  vert+=Integer.parseInt(j[1]);
                case "up" -> vert-=Integer.parseInt(j[1]);
            }
        }
        return vert*hor;
    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param filename
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String filename) throws FileNotFoundException {
        int aim = 0, depth = 0, horizontal = 0;
        String[][] arr = readFileTwo(filename);;
        for (String[] j : arr) {
            switch (j[0]) {
                case "forward" -> {
                    horizontal += Integer.parseInt(j[1]);
                    depth+= aim * Integer.parseInt(j[1]);
                }
                case "down" ->  aim+=Integer.parseInt(j[1]);
                case "up" -> aim-=Integer.parseInt(j[1]);
            }
        }
        return horizontal*depth;
    }

    private static String[][] readFileTwo(String filename) throws FileNotFoundException {
        File file = new File(filename);
        Scanner scanner = new Scanner(file);
        String[][] arr = new String[countLinesInFile(filename)][2];
        for (int i = 0; i < countLinesInFile(filename); i++) arr[i] = scanner.nextLine().split(" ");
        return arr;
    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

}