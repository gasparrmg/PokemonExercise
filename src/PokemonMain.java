import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class PokemonMain {
    public static final String NEW_POKEMON = "New pokemon found!";
    public static final String[] TEST_EXAMPLES = {
            "E", // Correct output: 2
            "NESO", // Correct output: 4
            "NSNSNSNSNS", // Correct output: 2
            "ENOEONENEOOSS", // Correct output: 9
            "NOESNSEOSNEOSSNOEOON" // Correct output: 9
    };

    public static void main(String[] args) throws Exception {

        // executeTestExamples(new HashMap<>(), new Coordinate(0,0)); // Uncomment to execute example tests

        Scanner s = new Scanner(System.in);
        System.out.print("Escreve uma sequência de movimentos (exemplos: 'E', 'NESO', 'NSNSNSNS'): ");

        String inputMoveSequence = s.nextLine().trim();

        int output = findPokemons(
                inputMoveSequence,
                new HashMap<>(),
                new Coordinate(0, 0) // Initial position
        );

        System.out.println("Captured Pokemons: " + output);
    }

    /**
     * Returns the number of found Pokemons after a given move sequence.
     * @param input
     * @param visitedCoordinates
     * @param currentCoordinate
     * @return
     * @throws Exception
     */
    private static int findPokemons(String input, HashMap<Coordinate, String> visitedCoordinates, Coordinate currentCoordinate) throws Exception {

        visitedCoordinates.put(currentCoordinate, NEW_POKEMON); // Register initial position
        int capturedPokemons = 1;

        for (char movement : input.toCharArray()) { // Iterate through the movements
            if (movement == 'N') {
                currentCoordinate.goNorth();
            } else if (movement == 'S') {
                currentCoordinate.goSouth();
            } else if (movement == 'E') {
                currentCoordinate.goEast();
            } else if (movement == 'O') {
                currentCoordinate.goWest();
            } else {
                throw new Exception("Invalid input!");
            }

            if (visitedCoordinates.get(currentCoordinate) == null) {
                capturedPokemons++;
                visitedCoordinates.put(currentCoordinate, NEW_POKEMON);
            }
        }

        return capturedPokemons;
    }

    /**
     * Executes the examples defined in TEST_EXAMPLES.
     * @param visitedCoordinates
     * @param currentCoordinate
     * @throws Exception
     */
    private static void executeTestExamples(HashMap<Coordinate, String> visitedCoordinates, Coordinate currentCoordinate) throws Exception {
        for (String input : TEST_EXAMPLES) {

            // Output results
            System.out.println("---------- TEST input: " + input + " ----------");
            System.out.println("Captured Pokemons: " + findPokemons(input, visitedCoordinates, currentCoordinate));

            // Clear HashMap and Coordinate
            currentCoordinate.reset();
            visitedCoordinates.clear();
        }
    }

    /**
     * Helper function to generate random move sequences with a given size.
     * @param size
     * @return
     * @throws Exception
     */
    private static String generateRandomMoveSequence(int size) throws Exception {
        if (size <= 0) {
            throw new Exception("Invalid size!");
        }

        char[] legalMovements = new char[] {'N', 'S', 'E', 'O'};

        Random r = new Random();

        String result = "";

        for (int i = 0; i < size; i++) {
            result = result + legalMovements[r.nextInt(legalMovements.length)];
        }

        return result;
    }
}
