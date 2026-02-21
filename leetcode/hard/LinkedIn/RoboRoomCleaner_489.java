package leetcode.hard.LinkedIn;

import java.util.HashSet;
import java.util.Set;

public class RoboRoomCleaner_489 {
 // This is the robot's control interface.
  // You should not implement it, or speculate about its implementation
  interface Robot {
      // Returns true if the cell in front is open and robot moves into the cell.
      // Returns false if the cell in front is blocked and robot stays in the current cell.
      public boolean move();
      // Robot will stay in the same cell after calling turnLeft/turnRight.
      // Each turn will be 90 degrees.
      public void turnLeft();
      public void turnRight();
      // Clean the current cell.
      public void clean();
  }

class Solution {
    int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    Set<String> visited = new HashSet<>();
    Robot robot;

    void back() {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }

    void traverse(int row, int col, int d) {
        String target = row+"-"+col;
        visited.add(target);
        robot.clean();
        for (int i = 0; i < 4; i++) {
            int dr = (d + i) % 4;
            int x = row + directions[dr][0];
            int y = col + directions[dr][1];
            if (!visited.contains(x+"-"+y) && robot.move()) {
                traverse(x, y, dr);
                back();
            }
            robot.turnRight();
        }
    }

    public void cleanRoom(Robot robot) {
        this.robot = robot;
        traverse(0, 0, 0);
    }
}
}
