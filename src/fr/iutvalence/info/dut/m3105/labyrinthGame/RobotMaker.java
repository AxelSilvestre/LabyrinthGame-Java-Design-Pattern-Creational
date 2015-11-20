package fr.iutvalence.info.dut.m3105.labyrinthGame;

public class RobotMaker {
	
	private static RobotMaker instance = null;
	
	private RobotMaker() {}
	
	public static RobotMaker getInstance(){
		if(instance == null){
			instance = new RobotMaker();
		}
		
		return instance;
	}
	
	public static RobotArtificialIntelligence makeRobotAI(char arg){
		
		if(arg == '1')
			return new LesserDumbBotArtificialIntelligence();
		return new DumbBotArtificialIntelligence();
		
	}

}
