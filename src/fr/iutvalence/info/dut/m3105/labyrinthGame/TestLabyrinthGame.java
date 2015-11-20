package fr.iutvalence.info.dut.m3105.labyrinthGame;

import java.io.IOException;

/**
 * Test application for labyrinth game
 * 
 */
public class TestLabyrinthGame
{
	/**
	 * Application's main
	 * 
	 * @param args
	 *            command-line arguments (none expected here)
	 */
	public static void main(String[] args)
	{

		Labyrinth labyrinth = new LabyrinthBuilder().width(4)
											  		.height(4)
											  		.exitPosition(3, 1)
											  		.addForbiddenCell(2, 0)
											  		.addForbiddenCell(3, 0)
											  		.addForbiddenCell(0, 1)
											  		.addForbiddenCell(0, 2)
											  		.addForbiddenCell(1, 2)
											  		.addForbiddenCell(3, 2)
											  		.addForbiddenCell(3, 3)
											  		.getLabyrinth();

		System.out.println("Please choose a robot:");
		System.out.println("1 - Lesser Dumb");
		System.out.println("Any - Dumb");
		
		char arg = 0;
		try {
			arg = (char) System.in.read();
		} catch (IOException e) {e.printStackTrace(); return;}

		
		RobotArtificialIntelligence robot = RobotMaker.makeRobotAI(arg);
		
		new LabyrinthGame(labyrinth, robot).play();
	}
}