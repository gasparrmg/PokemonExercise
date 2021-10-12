import java.util.HashMap;
import java.util.Random;

public class PokemonMain {
    public static void main(String[] args) throws Exception {
        String[] testingMoveSequences = new String[] {
                "E", // Correct output: 2
                "NESO", // Correct output: 4
                "NSNSNSNSNS", // Correct output: 2
                "ENOEONENEOOSS", // Correct output: 9
                "NOESNSEOSNEOSSNOEOON" // Correct output: 9
        };

        // Init program
        HashMap<Coordinate, String> visitedCoordinates = new HashMap<>();
        Coordinate currentCoordinate = new Coordinate(0, 0);
        visitedCoordinates.put(currentCoordinate, "New pokemon!");

        int capturedPokemons = 1;

        for (String input : testingMoveSequences) { // To iterate through the multiple tests. Just needed for testing.
            for (char movement : input.toCharArray()) {
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
                    visitedCoordinates.put(currentCoordinate, "New pokemon!");
                }
            }

            // Output results
            System.out.println("---------- TEST input: " + input + " ----------");
            System.out.println("Captured Pokemons: " + capturedPokemons);

            // Reset program
            currentCoordinate.reset();
            visitedCoordinates.clear();
            visitedCoordinates.put(currentCoordinate, "New pokemon!");
            capturedPokemons = 1;
        }
    }

    /**
     * Helper function to generate random move sequences with a given size
     * @param size
     * @return
     * @throws Exception
     */
    private static String generateRandomMoveSequenceInput(int size) throws Exception {
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
