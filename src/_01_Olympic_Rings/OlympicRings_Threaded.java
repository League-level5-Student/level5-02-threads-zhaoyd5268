package _01_Olympic_Rings;

import java.awt.Color;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One
	// robot should draw one ring simultaneously with the other 4 robots.

	public static void main(String[] args) {
		Robot ring1 = new Robot();
		Robot ring2 = new Robot();
		Robot ring3 = new Robot();
		Robot ring4 = new Robot();
		Robot ring5 = new Robot();

		ring1.setSpeed(8);
		ring2.setSpeed(8);
		ring3.setSpeed(8);
		ring4.setSpeed(8);
		ring5.setSpeed(8);

		ring1.setX(200);
		ring1.setY(400);
		ring2.setX(400);
		ring2.setY(400);
		ring3.setX(600);
		ring3.setY(400);
		ring4.setX(300);
		ring4.setY(500);
		ring5.setX(500);
		ring5.setY(500);
		
		Thread r1 = new Thread(() -> {
			for(int i = 0; i < 360; i++) {
			ring1.setPenColor(Color.BLUE);
			ring1.penDown();
			ring1.turn(1);
			ring1.move(2);
			}
			ring1.hide();
		});
		Thread r2 = new Thread(() -> {
			for(int i = 0; i < 360; i++) {
			ring2.setPenColor(Color.BLACK);
			ring2.penDown();
			ring2.turn(1);
			ring2.move(2);
			}
			ring2.hide();
		});
		Thread r3 = new Thread(() -> {
			for(int i = 0; i < 360; i++) {
			ring3.setPenColor(Color.RED);
			ring3.penDown();
			ring3.turn(1);
			ring3.move(2);
			}
			ring3.hide();
		});
		Thread r4 = new Thread(() -> {
			for(int i = 0; i < 360; i++) {
			ring4.setPenColor(Color.YELLOW);
			ring4.penDown();
			ring4.turn(1);
			ring4.move(2);
			}
			ring4.hide();
		});
		Thread r5 = new Thread(() -> {
			for(int i = 0; i < 360; i++) {
			ring5.setPenColor(Color.GREEN);
			ring5.penDown();
			ring5.turn(1);
			ring5.move(2);
			}
			ring5.hide();
		});

		r1.start();
		r2.start();
		r3.start();
		r4.start();
		r5.start();

	}
}
