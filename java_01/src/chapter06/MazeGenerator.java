package chapter06;
import java.util.*;

public class MazeGenerator {
    private final int width;
    private final int height;
    private final int[][] maze;
    private final Random rand = new Random();

    public MazeGenerator(int width, int height) {
        this.width = width % 2 == 0 ? width + 1 : width;     // 홀수로 맞춤
        this.height = height % 2 == 0 ? height + 1 : height;
        this.maze = new int[height][width];
        generateMaze();
    }

    public int[][] getMaze() {
        return maze;
    }

    private void generateMaze() {
        // 벽으로 채우기
        for (int[] row : maze)
            Arrays.fill(row, 1);

        carve(1, 1); // 시작지점

        // 출발/도착 지점
        maze[1][1] = 0;
        maze[height - 2][width - 2] = 2; // 목표
    }

    private void carve(int x, int y) {
        int[] dx = {2, -2, 0, 0};
        int[] dy = {0, 0, 2, -2};
        List<Integer> dirs = Arrays.asList(0, 1, 2, 3);
        Collections.shuffle(dirs, rand);

        for (int dir : dirs) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx > 0 && ny > 0 && nx < width - 1 && ny < height - 1 && maze[ny][nx] == 1) {
                maze[ny][nx] = 0;
                maze[y + dy[dir]/2][x + dx[dir]/2] = 0;
                carve(nx, ny);
            }
        }
    }
}
