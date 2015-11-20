package fr.iutvalence.info.dut.m3105.labyrinthGame;

import java.util.HashSet;
import java.util.Set;

public class LabyrinthBuilder {
		
	private int width;

	private int height;

	private Position exitPosition;

	private Set<Position> forbiddenCellsPositions;
	
		
	public LabyrinthBuilder(){
		forbiddenCellsPositions = new HashSet<Position>();
		exitPosition = null;
		width = 0;
		height = 0;
	}
		
	public LabyrinthBuilder width(int width) throws InvalidLabyrinth {
		if (width <= 0) throw new InvalidLabyrinth();
		this.width = width;
		return this;
	}
	
	public LabyrinthBuilder height(int height) throws InvalidLabyrinth {
		if (height <= 0) throw new InvalidLabyrinth();
		this.height = height;
		return this;
	}
	
	public LabyrinthBuilder exitPosition(int x, int y) throws InvalidLabyrinth {
		if (x < 0 || y < 0) throw new InvalidLabyrinth();
		this.exitPosition = new Position(x, y);
		return this;
	}
	
	public LabyrinthBuilder addForbiddenCell(int x, int y) throws InvalidLabyrinth {
		if (x < 0 || y < 0) throw new InvalidLabyrinth();
		forbiddenCellsPositions.add(new Position(x, y));
		return this;
	}
	
	
	public Labyrinth getLabyrinth() throws InvalidLabyrinth{
		if (exitPosition.getX() > width || exitPosition.getY() > height) throw new InvalidLabyrinth();
		
//		if (!forbiddenCellsPositions.stream().noneMatch(e ->  {return e.getX() > width && e.getY() > height;} ))
//			return null;

		for(Position pos : forbiddenCellsPositions){
			if (pos.getX() > width || pos.getY() > height) throw new InvalidLabyrinth();
			if (pos.getX() == exitPosition.getX() && pos.getY() == exitPosition.getY()) throw new InvalidLabyrinth();
		}
		return new Labyrinth(width, height, forbiddenCellsPositions, exitPosition);
	}
	
	
	
	

}
