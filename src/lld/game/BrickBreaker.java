package lld.game;

import java.util.*;

public class BrickBreaker {
    static final int SIZE = 7;
    static char[][] grid = new char[SIZE][SIZE];
    static int ballRow = 6, ballCol = 3;
    static int lives = 5;
    static Map<String, Integer> brickStrength = new HashMap<>();

    public static void main(String[] args) {
        initGrid();
        Scanner sc = new Scanner(System.in);
        while (true) {
            printGrid();
            System.out.print("Enter command (St / Lt / Rt / Q to quit): ");
            String cmd = sc.nextLine().trim();
            if (cmd.equalsIgnoreCase("Q")) break;
            moveBall(cmd);
        }
        sc.close();
    }

    private static void initGrid() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (i == 0 || j == 0 || i == SIZE - 1 || j == SIZE - 1) grid[i][j] = 'w';
                else grid[i][j] = ' ';
            }
        }
        // place bricks
        int[][] bricks = {{2, 2}, {2, 3}, {2, 4}, {3, 2}, {3, 3}, {3, 4}};
        for (int[] b : bricks) {
            grid[b[0]][b[1]] = '1';
            brickStrength.put(b[0] + "," + b[1], 1);
        }
        // ground
        for (int j = 1; j < SIZE - 1; j++) grid[6][j] = 'g';
        // ball
        grid[ballRow][ballCol] = 'o';
    }

    private static void printGrid() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) System.out.print(grid[i][j] + " ");
            System.out.println();
        }
        System.out.println("Ball count: " + lives);
    }

    private static void moveBall(String cmd) {
        int dr = 0, dc = 0;
        if (cmd.equalsIgnoreCase("St")) { dr = -1; dc = 0; }
        else if (cmd.equalsIgnoreCase("Lt")) { dr = -1; dc = -1; }
        else if (cmd.equalsIgnoreCase("Rt")) { dr = -1; dc = 1; }
        else {
            System.out.println("Invalid command!");
            return;
        }

        int r = ballRow + dr, c = ballCol + dc;
        while (r >= 0 && r < SIZE && c >= 0 && c < SIZE) {
            if (grid[r][c] == 'w') {
                lives--;
                System.out.println("Hit wall! Life -1");
                return;
            }
            if (Character.isDigit(grid[r][c])) {
                String key = r + "," + c;
                int strength = brickStrength.get(key);
                strength--;
                if (strength == 0) {
                    grid[r][c] = ' ';
                    brickStrength.remove(key);
                    grid[ballRow][ballCol] = 'g';
                    ballRow = r; ballCol = c;
                    grid[ballRow][ballCol] = 'o';
                    System.out.println("Brick destroyed!");
                } else {
                    brickStrength.put(key, strength);
                    grid[r][c] = (char) ('0' + strength);
                    System.out.println("Brick hit, strength now: " + strength);
                }
                return;
            }
            r += dr; c += dc;
        }
    }
}
