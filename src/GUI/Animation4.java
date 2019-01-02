package GUI;

import java.util.ArrayList;
import java.util.Iterator;
import GIS.Pacman;
import GIS_project4.Ghost;

public class Animation4 implements Runnable {

	public Animation4(Window4 w4) {
		this.w4=w4;
	};
	
	
	@Override 	
	public void run() {
		String map_data = w4.play.getBoundingBox();	
		System.out.println(map_data);
		System.out.println();
		w4.play.setInitLocation(w4.player.getLat(),w4.player.getLon()); //the starting position of the player
		w4.timeLeft=100000;  //the maximum play time in ms.
		w4.play.start();  //starts the game
		w4.info = w4.play.getStatistics();  //the game current statistics.
		System.out.println(w4.info);
		while(w4.mainFruitsList.getSize()>0 && w4.timeLeft>0) {  //runs as long as there are fruits left in the game or the time isn't over
			w4.play.rotate(w4.angle);  //the angle in which the player is moving to
			w4.splitedInfo=w4.info.split(",");
			w4.timeLeft=Double.parseDouble(w4.splitedInfo[3].substring(11)); //the current time left
			w4.player.setScore(Double.parseDouble(w4.splitedInfo[2].substring(6)));  //the current player's score
			w4.board = w4.play.getBoard(); //the current game board situation
			w4.repaint();
			updateBoard(w4.board); //updates the game board.
			w4.info = w4.play.getStatistics();  //the game current statistics.
			System.out.println(w4.info);
			try {
				Thread.sleep(70); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		w4.play.rotate(w4.angle);  //the angle in which the player is moving to
		w4.info = w4.play.getStatistics();  //the game current statistics.
		w4.splitedInfo=w4.info.split(",");
		w4.player.setScore(Double.parseDouble(w4.splitedInfo[2].substring(6)));
		System.out.println(w4.info);
		w4.play.stop();  //stops the game.
		System.out.println("**** Game Over ****");
		w4.isOver=true;
		w4.repaint();
	}

	/**this function updates each pacman location according to the game board. 
	 * 
	 * @param split :the relevant line in the board which represents the pacman.
	 */
	public void updatePacman(String [] split) {
		Iterator<Pacman> itp = w4.mainPacmanList.Iterator();
		while(itp.hasNext()) {
			Pacman temp = itp.next();
			if(temp.getId()==Integer.parseInt(split[1])) {
				temp.setLat(Double.parseDouble(split[2])); //sets the temp pacman latitude according to the game board 
				temp.setLon(Double.parseDouble(split[3])); //sets the temp pacman longitude according to the game board
			}
		}
	}
	/**this function updates each ghost location according to the game board. 
	 * 
	 * @param split :the relevant line in the board which represents the ghost.
	 */
	public void updateGhost(String [] split) {
		Iterator<Ghost> itg = w4.mainGhostsList.Iterator();
		while(itg.hasNext()) {
			Ghost temp = itg.next();
			if(temp.getId()==Integer.parseInt(split[1])) {  
				temp.setLat(Double.parseDouble(split[2])); //sets the temp ghost latitude according to the game board 
				temp.setLon(Double.parseDouble(split[3])); //sets the temp ghost longitude according to the game board
			}
		}
	}
	/**
	 * this function updates the board according to current game situation.
	 * if a fruit or a pacman were eaten, they get removed from the game.
	 * @param board: the game board
	 */
	public void updateBoard(ArrayList<String> board) {
		ArrayList<Integer> fruitsLeft=new ArrayList<>();  //the array list of the indexes of the fruits
		ArrayList<Integer> pacmanLeft=new ArrayList<>(); //the array list of the indexes of the pacman
		for(int i=0;i<board.size();i++) {
			String temp=board.get(i);
			String [] splitedRow = temp.split(",");
			if(splitedRow[0].equals("P")) {
				updatePacman(splitedRow); //sets the pacman's location to it's new location.
				pacmanLeft.add(Integer.parseInt(splitedRow[1])); //adds the pacman to the pacmanLeft array. 

			}
			else if(splitedRow[0].equals("M")) {
				w4.player.updatePlayer(Double.parseDouble(splitedRow[2]), Double.parseDouble(splitedRow[3])); //sets the player's location to it's new location.
			}
			else if(splitedRow[0].equals("F")) {
				fruitsLeft.add(Integer.parseInt(splitedRow[1])); //adds the fruit to the fruitsLeft array.
			}
			else if(splitedRow[0].equals("G")) {
				updateGhost(splitedRow); //sets the ghost's location to it's new location.

			}
		}
		w4.mainFruitsList.updateFruitsList(fruitsLeft);  //updates the fruits list according to the fruits that weren't eaten. 
		w4.mainPacmanList.updatePacmanList(pacmanLeft);  //updates the pacman list according to the pacman that weren't eaten. 


	}
	////private/////
	Window4 w4;





}
