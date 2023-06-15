import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MarsRover {
    private int x;
    private int y;
    private char direction;

    public MarsRover(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public void executeInstructions(String instructions) {
        for (char instruction : instructions.toCharArray()) {
            switch (instruction) {
                case 'L':
                    turnLeft();
                    break;
                case 'R':
                    turnRight();
                    break;
                case 'M':
                    move();
                    break;
            }
        }
    }

    private void turnLeft() {
        switch (direction) {
            case 'N':
                direction = 'W';
                break;
            case 'W':
                direction = 'S';
                break;
            case 'S':
                direction = 'E';
                break;
            case 'E':
                direction = 'N';
                break;
        }
    }

    private void turnRight() {
        switch (direction) {
            case 'N':
                direction = 'E';
                break;
            case 'E':
                direction = 'S';
                break;
            case 'S':
                direction = 'W';
                break;
            case 'W':
                direction = 'N';
                break;
        }
    }

    private void move() {
        switch (direction) {
            case 'N':
                y++;
                break;
            case 'E':
                x++;
                break;
            case 'S':
                y--;
                break;
            case 'W':
                x--;
                break;
        }
    }

    public String getPosition() {
        return x + " " + y + " " + direction;
    }

    public static void main(String[] args) {
        //
        String inputFile = "input.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            String plateauLine = reader.readLine();
            String[] plateauCoords = plateauLine.split(" ");
            int plateauX = Integer.parseInt(plateauCoords[0]);
            int plateauY = Integer.parseInt(plateauCoords[1]);

            while ((line = reader.readLine()) != null) {
                String[] roverCoords = line.split(" ");
                int roverX = Integer.parseInt(roverCoords[0]);
                int roverY = Integer.parseInt(roverCoords[1]);
                char roverDirection = roverCoords[2].charAt(0);

                String instructions = reader.readLine();

                MarsRover rover = new MarsRover(roverX, roverY, roverDirection);
                rover.executeInstructions(instructions);
                System.out.println(rover.getPosition());
            }
        } catch (IOException e) {
            System.out.println("Error reading input.txt file: " + e.getMessage());
        }
    }
}

