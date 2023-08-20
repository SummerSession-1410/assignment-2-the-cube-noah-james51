import java.util.Scanner;

public class RubicsCube {

    public static void main(String[] args) {
        char[][][] cube = createRubiksCube();
        displayCube(cube);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter a move (u, d, r, l, f, b or q to quit): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("q")) {
                break;
            }

            performMove(cube, input);
            displayCube(cube);
        }

        System.out.println("Cube simulation terminated.");
        scanner.close();
    }

    public static char[][][] createRubiksCube() {
        char[][][] cube = new char[6][3][3];
        char[] colors = {'r', 'b', 'o', 'g', 'y', 'w'};

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    cube[i][j][k] = colors[i];
                }
            }
        }

        return cube;
    }
        public static void performMove(char[][][] cube, String move) {
            int faceIndex = -1;
            boolean prime = false;
    
            switch (move) {
                case "u":
                    faceIndex = 0;
                    break;
                case "u'":
                    faceIndex = 0;
                    prime = true;
                    break;
                case "d":
                    faceIndex = 1;
                    break;
                case "d'":
                    faceIndex = 1;
                    prime = true;
                    break;
                case "r":
                    faceIndex = 2;
                    break;
                case "r'":
                    faceIndex = 2;
                    prime = true;
                    break;
                case "l":
                    faceIndex = 3;
                    break;
                case "l'":
                    faceIndex = 3;
                    prime = true;
                    break;
                case "f":
                    faceIndex = 4;
                    break;
                case "f'":
                    faceIndex = 4;
                    prime = true;
                    break;
                case "b":
                    faceIndex = 5;
                    break;
                case "b'":
                    faceIndex = 5;
                    prime = true;
                    break;
                default:
                    System.out.println("Invalid move: " + move);
                    return;
            }
    
            rotateFace(cube, faceIndex, prime);
        }

        public static void printCube(char[][][] cube) {
            for (int row = 0; row < 3; row++) {
                for (int face = 0; face < 6; face++) {
                    for (int col = 0; col < 3; col++) {
                        System.out.print(cube[face][row][col]);
                        if (col < 2) {
                            System.out.print("|");
                        }
                    }
                    if (face < 5) {
                        System.out.print("   ");
                    }
                }
                System.out.println();
            }
        }
    
        public static void rotateFace(char[][][] cube, int faceIndex, boolean prime) {
            char[][] face = cube[faceIndex];
            char[][] temp = new char[3][3];
    
            for (int i = 0; i < 3; i++) {
                System.arraycopy(face[i], 0, temp[i], 0, 3);
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (!prime) {
                        face[i][j] = temp[2 - j][i];
                    } else {
                        face[i][j] = temp[j][2 - i];
                    }
                }
            }
        }
    
        public static char getColorFromFace(int face) {
            switch (face) {
                case 0: return 'r'; // Red
                case 1: return 'd'; // Blue (for demonstration purposes)
                case 2: return 'g'; // Green
                case 3: return 'o'; // Orange (for demonstration purposes)
                case 4: return 'b'; // Blue
                case 5: return 'y'; // Yellow
                default: return ' '; // Empty
            }
        }
    }

