package fr.iutvalence.info.dut.m3105.labyrinthGame;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LabyrinthFileParser {
	
	public static Labyrinth parse(String fileName) throws IOException{
		LabyrinthBuilder builder = new LabyrinthBuilder();
		
		File file = new File(fileName);
		BufferedReader buffer = new BufferedReader(new FileReader(file));

		int x = 0, y = 0;
		String line;
		while((line = buffer.readLine()) != null){
			y = 0;
			for(char c : line.toCharArray()){
				if(c == '*')
					builder.addForbiddenCell(x, y);
				if(c == 'S')
					builder.exitPosition(x, y);
				x++;
			}
			y++;
		}
		
		buffer.close();
		
		builder.width(x);
		builder.height(y);
	
		return builder.getLabyrinth();
	}

}
