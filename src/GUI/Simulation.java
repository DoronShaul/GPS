package GUI;

import java.util.ArrayList;
import Algorithm.GameAlgo4;
import Geom.Point3D;
import graph.Graph;
import graph.Graph_Algo;
import graph.Node;

public class Simulation implements Runnable {
	private Window4 w4;
	public Simulation(Window4 w4) {
		this.w4=w4;
	}

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
			double aziPlayerGhost=w4.player.isGhostClose(w4.mainGhostsList);    //calculates the azimuth between the player and a ghost less than 4 meters away.
			
			if(aziPlayerGhost!=-1) {            //if there is a ghost less than 4 meters away
				w4.play.rotate(aziPlayerGhost+135);  //the angle in which the player is moving to. to avoid ghosts.
			}

			else {            //if there isn't a ghost less than 4 meters away
				int id=GameAlgo4.quickestPath(w4.mainFruitsList, w4.mainBoxList, w4.player);    //finds the quickest path from the player to a fruit.
			
				if(w4.player.playerToPoint().isDirect(w4.mainFruitsList.flArray().get(id).fruitToPoint(),
						w4.mainBoxList)) {    //if the player has a direct path to the closest fruit.
					w4.play.rotate(GameAlgo4.movePlayer(w4.player.playerToPoint(),
							w4.mainFruitsList.flArray().get(id).fruitToPoint()));  //the angle in which the player is moving to
				}
				
				
				else {  //the player doesn't have a direct path to the closest fruit.
					Graph g=new Graph();
					g = GameAlgo4.buildGraph(w4.player.playerToPoint(),
							w4.mainFruitsList.flArray().get(id).fruitToPoint(), w4.mainBoxList);   //creating a graph when the source is the player and the taeget is the closest not-direct fruit.
					Graph_Algo.dijkstra(g, "a");     //using dijkstra algorithm.
					Node b=new Node("b");
					b = g.getNodeByName("b");
					ArrayList<String> shortestPath = b.getPath();
					Point3D directionPoint = w4.boxCorners.get(Integer.parseInt(shortestPath.get(1))-1);
					w4.play.rotate(GameAlgo4.movePlayer(w4.player.playerToPoint(), directionPoint));  //the angle in which the player is moving to
				}
			}

			w4.splitedInfo=w4.info.split(",");
			w4.timeLeft=Double.parseDouble(w4.splitedInfo[3].substring(11)); //the current time left
			w4.player.setScore(Double.parseDouble(w4.splitedInfo[2].substring(6)));  //the current player's score
			w4.board = w4.play.getBoard(); //the current game board situation
			w4.repaint();
			GameAlgo4.updateBoard(w4.board, w4.mainPacmanList, w4.mainFruitsList, w4.mainGhostsList,w4.player); //updates the game board.
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
		w4.dbc.setScore(w4.player.getScore());
		w4.rank=w4.dbc.rank();
		w4.isOver=true;
		w4.repaint();
	};

}
