package _02_Advanced_Robot_Race;

import java.util.Random;

import org.jointheleague.graphical.robot.Robot;

public class AdvancedRobotRace {
	static Random ran = new Random();
	static boolean touchTop = false;
	// Re-do the robot race recipe from level 3 module 0.
	// This time, use threads to make all of the robots go at the same time.

	// 1. make a main method
	public static void main(String[] args) {
		Robot[] robot = new Robot[5];
		for (int i = 0; i < 4; i++) {
			robot[i] = new Robot();
			robot[i].setY(900);
			robot[i].setX(200 * i + 400);
			robot[i].setSpeed(50);
		}

		// 2. create an array of 5 robots.

		// 3. use a for loop to initialize the robots.

		// 4. make each robot start at the bottom of the screen, side by side, facing up

		// 5. use another for loop to iterate through the array and make each robot move
		// a random amount less than 50.

		Thread racer1 = new Thread(() -> {
			move(robot[0]);
		});
		Thread racer2 = new Thread(() -> {
			move(robot[1]);
		});
		Thread racer3 = new Thread(() -> {
			move(robot[2]);
		});
		Thread racer4 = new Thread(() -> {
			move(robot[3]);
		});

		racer1.start();
		racer2.start();
		racer3.start();
		racer4.start();

	}
	// 6. use a while loop to repeat step 5 until a robot has reached the top of the
	// screen.

	// 7. declare that robot the winner and throw it a party!

	// 8. try different races with different amounts of robots.

	// 9. make the robots race around a circular track.

	public static void move(Robot r) {
		r.penDown();
		while (touchTop == false) {
			r.move(ran.nextInt(10));
			if (r.getY() < 200) {
				touchTop = true;
				System.out.println("A Robot has WON!!!");
				System.out.println("party thrown");

				break;
			}
		}
	}
}
