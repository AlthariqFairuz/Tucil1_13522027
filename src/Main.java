import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;

public class Main {

    static Scanner input = new Scanner(System.in);

    // This class is used to store the sequence and its score
    static class Sequence {
        String[] tokens;
        int score;

        Sequence(String[] tokens, int score) {
            this.tokens = tokens;
            this.score = score;
        }
    }

    // This class is used to store the pair of sequence and its path that satisfies
    // the condition
    static class Pair {
        List<String> sequence;
        List<String> path;

        Pair(List<String> sequence, List<String> path) {
            this.sequence = sequence;
            this.path = path;
        }
    }


    public static void main(String[] args) {
    System.out.println(
                "\n\n  /$$$$$$  /$$     /$$ /$$$$$$$  /$$$$$$$$ /$$$$$$$  /$$$$$$$  /$$   /$$ /$$   /$$ /$$   /$$        /$$$$$$   /$$$$$$  /$$$$$$$$ /$$$$$$$$          \r\n" + //
                                        " /$$__  $$|  $$   /$$/| $$__  $$| $$_____/| $$__  $$| $$__  $$| $$  | $$| $$$ | $$| $$  /$$/       /$$__  $$ /$$$_  $$|_____ $$/|_____ $$/          \r\n" + //
                                        "| $$  \\__/ \\  $$ /$$/ | $$  \\ $$| $$      | $$  \\ $$| $$  \\ $$| $$  | $$| $$$$| $$| $$ /$$/       |__/  \\ $$| $$$$\\ $$     /$$/      /$$/        /$$\r\n" + //
                                        "| $$        \\  $$$$/  | $$$$$$$ | $$$$$   | $$$$$$$/| $$$$$$$/| $$  | $$| $$ $$ $$| $$$$$/          /$$$$$$/| $$ $$ $$    /$$/      /$$/        |__/\r\n" + //
                                        "| $$         \\  $$/   | $$__  $$| $$__/   | $$__  $$| $$____/ | $$  | $$| $$  $$$$| $$  $$         /$$____/ | $$\\ $$$$   /$$/      /$$/             \r\n" + //
                                        "| $$    $$    | $$    | $$  \\ $$| $$      | $$  \\ $$| $$      | $$  | $$| $$\\  $$$| $$\\  $$       | $$      | $$ \\ $$$  /$$/      /$$/           /$$\r\n" + //
                                        "|  $$$$$$/    | $$    | $$$$$$$/| $$$$$$$$| $$  | $$| $$      |  $$$$$$/| $$ \\  $$| $$ \\  $$      | $$$$$$$$|  $$$$$$/ /$$/      /$$/           |__/\r\n" + //
                                        " \\______/     |__/    |_______/ |________/|__/  |__/|__/       \\______/ |__/  \\__/|__/  \\__/      |________/ \\______/ |__/      |__/                \r\n" + //
                                        "                                                                                                                                                    \r\n" + //
                                        "                                                                                                                                                    \r\n" + //
                                        "                                                                                                                                                    \r\n" + //
                                        " /$$$$$$$  /$$$$$$$  /$$$$$$$$  /$$$$$$   /$$$$$$  /$$   /$$       /$$$$$$$  /$$$$$$$   /$$$$$$  /$$$$$$$$ /$$$$$$   /$$$$$$   /$$$$$$  /$$         \r\n" + //
                                        "| $$__  $$| $$__  $$| $$_____/ /$$__  $$ /$$__  $$| $$  | $$      | $$__  $$| $$__  $$ /$$__  $$|__  $$__//$$__  $$ /$$__  $$ /$$__  $$| $$         \r\n" + //
                                        "| $$  \\ $$| $$  \\ $$| $$      | $$  \\ $$| $$  \\__/| $$  | $$      | $$  \\ $$| $$  \\ $$| $$  \\ $$   | $$  | $$  \\ $$| $$  \\__/| $$  \\ $$| $$         \r\n" + //
                                        "| $$$$$$$ | $$$$$$$/| $$$$$   | $$$$$$$$| $$      | $$$$$$$$      | $$$$$$$/| $$$$$$$/| $$  | $$   | $$  | $$  | $$| $$      | $$  | $$| $$         \r\n" + //
                                        "| $$__  $$| $$__  $$| $$__/   | $$__  $$| $$      | $$__  $$      | $$____/ | $$__  $$| $$  | $$   | $$  | $$  | $$| $$      | $$  | $$| $$         \r\n" + //
                                        "| $$  \\ $$| $$  \\ $$| $$      | $$  | $$| $$    $$| $$  | $$      | $$      | $$  \\ $$| $$  | $$   | $$  | $$  | $$| $$    $$| $$  | $$| $$         \r\n" + //
                                        "| $$$$$$$/| $$  | $$| $$$$$$$$| $$  | $$|  $$$$$$/| $$  | $$      | $$      | $$  | $$|  $$$$$$/   | $$  |  $$$$$$/|  $$$$$$/|  $$$$$$/| $$$$$$$$   \r\n" + //
                                        "|_______/ |__/  |__/|________/|__/  |__/ \\______/ |__/  |__/      |__/      |__/  |__/ \\______/    |__/   \\______/  \\______/  \\______/ |________/   \r\n" + //
                                        "                                                                                                                                                    \r\n" + //
                                        "                                                                                                                                                    \r\n" + //
                                        "                                                                                                                                                    ");
        System.out.println("Please choose one input method : ");
        System.out.println("1. Via .txt");
        System.out.println("2. Via CLI");
        System.out.println("3. Exit");
        Integer choice = Integer.parseInt(input.nextLine());
        while (choice != 1 && choice != 2 && choice != 3) {
            System.out.println("Please choose only 1 or 2 or 3 : ");
            choice = Integer.parseInt(input.nextLine());
        }
        while (choice != 3) {
            if (choice == 1) {
                try {
                    // Input file .txt
                    System.out.println("Input filename : ");
                    String location = input.nextLine();
                    File file = new File("../test/" + location + ".txt");
                    input = new Scanner(file);

                    // Read file
                    Integer bufferLength = Integer.parseInt(input.nextLine());
                    if (bufferLength < 1) {
                        System.out.println("Invalid file : Buffer length can't be negative");
                        return;
                    }
                    String[] matrixSize = input.nextLine().split(" ");
                    Integer matrixCol = Integer.parseInt(matrixSize[0]);
                    Integer matrixRow = Integer.parseInt(matrixSize[1]);
                    if (matrixRow < 1 || matrixCol < 1 ) {
                        System.out.println("Invalid file : Matrix size can't be negative");
                    }
                    String[][] matrix = new String[matrixRow][matrixCol];
                    for (int i = 0; i < matrixRow; i++) {
                        String[] matrixTxT = input.nextLine().split(" ");
                        for (int j = 0; j < matrixCol; j++) {
                            matrix[i][j] = matrixTxT[j];
                        }
                    }

                    for (int i = 0; i < matrixRow; i++) {
                        if (!validToken(matrix[i])) {
                            System.out.println("Matrix is invalid, please input another file");
                            return;
                        }
                    }

                    Integer numberOfSequence = Integer.parseInt(input.nextLine());
                    if (numberOfSequence < 1 ){
                        System.out.println("Invalid file : Sequence length, please input another file");
                            return;
                    }
                    List<Sequence> sequences = new ArrayList<Sequence>();
                    while (input.hasNextLine()) {
                        String[] tokens = input.nextLine().split(" ");
                        String score = input.nextLine();
                        sequences.add(new Sequence(tokens, Integer.parseInt(score)));
                    }

                    for (Sequence sequence : sequences) {
                        if (!validToken(sequence.tokens)) {
                            System.out.println("Sequence is invalid, please input another file");
                            return;
                        }
                    }

                    // Brute forcce all possbile combinations
                    long startTime = System.currentTimeMillis(); // Start timer for execution time
                    boolean visited[][] = new boolean[matrix.length][matrix[0].length];
                    List<Pair> result = new ArrayList<Pair>();

                    if (bufferLength > matrix[0].length * matrix.length) {
                        bufferLength = matrix[0].length * matrix.length;
                    }

                    // For each column in the first row of the matrix, find all possible
                    // combinations
                    for (int i = 0; i < matrix[0].length; i++) {
                        bruteForcePossibleCombination(matrix, bufferLength, sequences, result, new ArrayList<>(), 0, i,
                                true,
                                visited, new ArrayList<>());
                    }

                    // Find one combination that has the highest score
                    int maxScore = 0;
                    Pair highestScorePair = null;
                    for (Pair res : result) {
                        int score = 0;
                        for (Sequence sequence : sequences) {
                            if (String.join("", res.sequence).contains(String.join("", sequence.tokens))) {
                                score += sequence.score;
                            }
                        }
                        if (score > maxScore) {
                            maxScore = score;
                            highestScorePair = res;
                        }
                    }

                    if (maxScore == 0) {
                        System.out.println("There is no buffer that satisfies the condition");
                    } else {
                        System.out.println("Highest score : " + maxScore);
                        System.out.println("Buffer : ");
                        for (String s : highestScorePair.sequence) {
                            System.out.print(s + " ");
                        }
                        System.out.println("\nPath : ");
                        for (String p : highestScorePair.path) {
                            System.out.println(p);
                        }
                    }
                    long endTime = System.currentTimeMillis();
                    long timeElapsed = endTime - startTime;
                    System.out.println("Time elapsed : " + timeElapsed + " ms\n");

                    System.out.println("Do you wish to save the output? (Y/N)");
                    input = new Scanner(System.in);
                    String save = input.nextLine();
                    if (save.toLowerCase().equals("y")) {
                        saveFile(maxScore, highestScorePair, timeElapsed);
                    }

                } catch (FileNotFoundException e) {
                    System.out.println("File doesn't exist : " + e.getMessage());
                }
            } else if (choice == 2) {

                System.out.println("Input number of unique tokens : ");
                Integer numberOfUniqueToken = Integer.parseInt(input.nextLine());
                while (numberOfUniqueToken < 2) {
                    System.out.println("Number of unique tokens must be at least 2. Please input again :");
                    numberOfUniqueToken = Integer.parseInt(input.nextLine());
                }
                System.out.println();

                System.out.println("Input token, each of them must be separated with a space : ");
                String tokens = input.nextLine();
                String[] token = tokens.split(" ");
                while (!isUnique(token) || token.length != numberOfUniqueToken || !validToken(token)) {
                    if (!isUnique(token)) {
                        System.out.println("Token must be unique");
                    } else if (token.length != numberOfUniqueToken) {
                        System.out.println("Number of token must be equal to the number of unique token");
                    } else {
                        System.out.println("Each token must consist of 2 characters");
                    }
                    System.out.println("Please input again :");
                    tokens = input.nextLine();
                    token = tokens.split(" ");
                }
                System.out.println();

                System.out.println("Input the length of buffer : ");
                Integer bufferLength = Integer.parseInt(input.nextLine());
                while (bufferLength < 2) {
                    System.out.println("Length of buffer must be at least 2");
                    bufferLength = Integer.parseInt(input.nextLine());
                }
                System.out.println();

                System.out.println(
                        "Input length of column and row of a matrix, each of them must be separated with a space : ");
                String matrixSize = input.nextLine();

                while (matrixSize.split(" ").length != 2 || Integer.parseInt(matrixSize.split(" ")[0]) < 1
                        || Integer.parseInt(matrixSize.split(" ")[1]) < 1) {
                    if (matrixSize.split(" ").length != 2) {
                        System.out.println("Input must be two numbers separated by a space");
                    } else {
                        System.out.println("Input must be higher than 0");
                    }
                    matrixSize = input.nextLine();
                }

                String[] matrixSizeArr = matrixSize.split(" ");
                Integer matrixCol = Integer.parseInt(matrixSizeArr[0]);
                Integer matrixRow = Integer.parseInt(matrixSizeArr[1]);
                System.out.println();

                System.out.println("Input maximum length of a sequence : ");
                Integer maxSequenceLength = Integer.parseInt(input.nextLine());
                while (maxSequenceLength < 2) {
                    System.out.println("Maximum length of a sequence must be at least 2");
                    maxSequenceLength = Integer.parseInt(input.nextLine());
                }

                // Find maximum possible sequence
                int maxPossibleSequence = 0;
                for (int i = 2; i <= maxSequenceLength; i++) {
                    maxPossibleSequence += Math.pow(numberOfUniqueToken, i);
                }

                System.out.println();

                System.out.println("Input number of sequence : ");
                Integer numberOfSequence = Integer.parseInt(input.nextLine());
                while (numberOfSequence < 1 || numberOfSequence > maxPossibleSequence) {
                    if (numberOfSequence < 1) {
                        System.out.println(
                                "Number of sequence must be at least 1. Please input again :");
                    } else {
                        System.out.println("Number of sequence is too high, maximum number of sequence is "
                                + maxPossibleSequence + ". Please input again :");
                    }
                    numberOfSequence = Integer.parseInt(input.nextLine());
                }
                System.out.println();

                // Generate matrix
                String[][] matrix = new String[matrixRow][matrixCol];
                for (int i = 0; i < matrixRow; i++) {
                    for (int j = 0; j < matrixCol; j++) {
                        matrix[i][j] = token[(int) (Math.random() * numberOfUniqueToken)];
                    }
                }

                System.out.println("Here are the generated matrix : ");
                for (String[] row : matrix) {
                    for (String elm : row) {
                        System.out.print(elm + " ");
                    }
                    System.out.println();
                }
                System.out.println();

                // Generate sequences
                Set<String> uniqueSequences = new HashSet<String>();
                List<Sequence> sequences = new ArrayList<Sequence>();

                for (int i = 0; i < numberOfSequence; i++) {
                    int sequenceLength = (int) (Math.random() * maxSequenceLength + 1);
                    while (sequenceLength < 2) {
                        sequenceLength = (int) (Math.random() * maxSequenceLength + 1);
                    }
                    String[] sequence = new String[sequenceLength];
                    for (int j = 0; j < sequence.length; j++) {
                        sequence[j] = token[(int) (Math.random() * numberOfUniqueToken)];
                    }

                    int score = (int) (Math.random() * 100);

                    // Convert sequence to string
                    String sequenceStr = Arrays.toString(sequence);

                    // Cek whether sequence is already in set
                    while (uniqueSequences.contains(sequenceStr)) {
                        sequence = new String[sequenceLength];
                        for (int j = 0; j < sequence.length; j++) {
                            sequence[j] = token[(int) (Math.random() * numberOfUniqueToken)];
                        }
                        // Update sequence string
                        sequenceStr = Arrays.toString(sequence);
                    }

                    // Add sequence to set unique so that there is no duplicate sequence
                    uniqueSequences.add(sequenceStr);

                    // Add sequence to list
                    sequences.add(new Sequence(sequence, score));
                }

                System.out.println(
                        "Here are the generated sequences and their score : ");
                for (Sequence sequence : sequences) {
                    String[] sequenceToken = sequence.tokens;
                    for (int i = 0; i < sequenceToken.length; i++) {
                        System.out.print(sequenceToken[i] + " ");
                    }
                    System.out.println();
                    System.out.println(sequence.score + "\n\n");
                }

                // Brute forcce all combinations
                long startTime = System.currentTimeMillis();
                boolean visited[][] = new boolean[matrix.length][matrix[0].length];
                List<Pair> result = new ArrayList<Pair>();

                if (bufferLength > matrix[0].length * matrix.length) {
                    bufferLength = matrix[0].length * matrix.length;
                }

                for (int i = 0; i < matrix[0].length; i++) {
                    bruteForcePossibleCombination(matrix, bufferLength, sequences, result, new ArrayList<String>(), 0,
                            i,
                            true,
                            visited, new ArrayList<String>());
                }

                // Find one combination that has the highest score
                int maxScore = 0;
                Pair highestScorePair = null;
                for (Pair res : result) {
                    int score = 0;
                    for (Sequence sequence : sequences) {
                        if (String.join("", res.sequence).contains(String.join("", sequence.tokens))) {
                            score += sequence.score;
                        }
                    }
                    if (score > maxScore) {
                        maxScore = score;
                        highestScorePair = res;
                    }
                }

                if (maxScore == 0) {
                    System.out.println("There is no buffer that satisfies the condition");
                } else {
                    System.out.println("Highest score : " + maxScore);
                    System.out.println("Buffer : ");
                    for (String s : highestScorePair.sequence) {
                        System.out.print(s + " ");
                    }
                    System.out.println("\nPath : ");
                    for (String p : highestScorePair.path) {
                        System.out.println(p);
                    }
                }
                long endTime = System.currentTimeMillis();
                long timeElapsed = endTime - startTime;
                System.out.println("Time elapsed : " + timeElapsed + " ms\n");

                System.out.println("Do you wish to save the output? (Y/N)");
                input = new Scanner(System.in);
                String save = input.nextLine();
                if (save.toLowerCase().equals("y")) {
                    saveFile(maxScore, highestScorePair, timeElapsed);
                }
            }
            System.out.println("\nPlease choose one input method : ");
            System.out.println("1. Via .txt");
            System.out.println("2. Via CLI");
            System.out.println("3. Exit");
            choice = Integer.parseInt(input.nextLine());
            while (choice != 1 && choice != 2 && choice != 3) {
                System.out.println("Please choose only 1 or 2 or 3 : ");
                choice = Integer.parseInt(input.nextLine());
            }
        }
        input.close();
    }

    static void bruteForcePossibleCombination(String matrix[][], int bufferLength, List<Sequence> sequences,
            List<Pair> result, List<String> temp, int row, int col, boolean isHorizontal, boolean visited[][],
            List<String> tempPath) {

        // Find all valid coordinates (Not out of bound and haven't been visited yet)
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || visited[row][col]) {
            return;
        }

        // If valid, add token to temporary sequence (temp) and mark the coordinate as
        // visited and add the path to temporary path (tempPath)
        temp.add(matrix[row][col]);
        visited[row][col] = true;
        tempPath.add(Integer.toString(col + 1) + " " + Integer.toString(row + 1));

        // Check whether the sequence contains any of the sequences at each step
        String tempString = String.join("", temp);
        for (Sequence sequence : sequences) {
            if (tempString.contains(String.join("", sequence.tokens))) {
                // If it contains, add the sequence and the path to the result
                result.add(new Pair(new ArrayList<String>(temp), new ArrayList<String>(tempPath)));
                break;
            }
        }

        // If the length of sequence (temp) is less than the buffer length, find all
        // possible combinations recursively based on the direction until the length of
        // sequence (temp) is equal to the buffer length
        if (temp.size() < bufferLength) {
            isHorizontal = !isHorizontal;
            if (isHorizontal) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (j != col && !visited[row][j]) {
                        bruteForcePossibleCombination(matrix, bufferLength, sequences, result, temp, row, j,
                                isHorizontal,
                                visited, tempPath);
                    }
                }
            } else {
                for (int i = 0; i < matrix.length; i++) {
                    if (i != row && !visited[i][col]) {
                        bruteForcePossibleCombination(matrix, bufferLength, sequences, result, temp, i, col,
                                isHorizontal,
                                visited, tempPath);
                    }
                }
            }
        }

        // After the sequence has been checked, remove the last token from the sequence
        // and mark the coordinate as unvisited and remove the last path from the path
        visited[row][col] = false;
        temp.remove(temp.size() - 1);
        tempPath.remove(tempPath.size() - 1);
    }

    static void saveFile(int maxScore, Pair highestScore, long timeElapsed) {
        System.out.println("Input file name: ");
        String saveLocation = input.nextLine();
        File saveFile = new File("../test/" + saveLocation + ".txt");
        while (saveFile.exists()) {
            System.out.println("File already exist, please use another name : ");
            saveLocation = input.nextLine();
            saveFile = new File("../test/" + saveLocation + ".txt");
        }
        try {
            saveFile.createNewFile();
            FileWriter writer = new FileWriter(saveFile);
            writer.write(maxScore + "\n");
            if (highestScore == null) {
                writer.write("There is no buffer that satisfies the condition\n");
            } else {
                for (String s : highestScore.sequence) {
                    writer.write(s + " ");
                }
                writer.write("\n");
                for (String p : highestScore.path) {
                    writer.write(p + "\n");
                }
            }
            writer.write("\n" + timeElapsed + " ms");
            writer.close();
            System.out.println("File has been saved : " + saveFile.getName());

        } catch (Exception e) {
            System.out.println("An error occured :" + e.getMessage());
            e.printStackTrace();
        }
    }

    static boolean isUnique(String[] token) {
        // Check whether a token is unique or not
        Set<String> uniqueTokens = new HashSet<String>(Arrays.asList(token));
        return uniqueTokens.size() == token.length;
    }

    static boolean validToken(String[] tokens) {
        // Check whether a token is valid or not (only consists of 2 characters)
        for (String token : tokens) {
            if (token.length() != 2) {
                return false;
            }
        }
        return true;
    }

}
