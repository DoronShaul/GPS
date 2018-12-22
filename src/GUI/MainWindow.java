package GUI;
import java.awt.BasicStroke;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;


import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.filechooser.FileFilter;
import javax.swing.plaf.FileChooserUI;

import Algorithm.GameAlgo;
import File_format.Csv2kml;
import File_format.PacmanCsvReader;
import File_format.csvReader;
import GIS.Fruit;
import GIS.FruitsList;
import GIS.Map;
import GIS.Pacman;
import GIS.PacmanList;
import GIS.Path;
import GIS.PathList;
import Geom.Point3D;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.RepaintManager;


public class MainWindow extends JFrame implements MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5431285052113509107L;
	private boolean pac=false;
	private boolean fru=false;
	private boolean def=true;
	private boolean runSim=false;
	private Random rnd = new Random();

	private boolean isFirstPac=true;
	private boolean isFirstFru=true;

	int []currentPointInPixels=new int[2];
	Point3D p= new Point3D(0, 0);
	private PacmanList mainPacmanList = new PacmanList();
	private FruitsList mainFruitsList = new FruitsList();
	private PathList pathlist = new PathList ();



	public BufferedImage myImage;
	public BufferedImage myPac;
	public BufferedImage myFru1;
	public BufferedImage start;


	public MainWindow() 
	{
		initGUI();		
		this.addMouseListener(this);
	}
	/**
	 * this function is responsible for all the graphics in the game.
	 */
	private void initGUI() 
	{
		//***//menu bar buttons//***//
		MenuBar menuBar = new MenuBar();
		Menu file = new Menu("File"); 
		Menu options = new Menu("Options");
		MenuItem save = new MenuItem("Save");
		MenuItem exit = new MenuItem("Exit");
		MenuItem pacman = new MenuItem("Pacman");
		MenuItem fruit = new MenuItem("Fruit");
		MenuItem run = new MenuItem("Run");
		MenuItem load = new MenuItem("Load");
		MenuItem clear = new MenuItem("Clear");

		menuBar.add(file);
		menuBar.add(options);
		file.add(save);
		file.add(load);
		file.add(clear);
		file.add(exit);
		options.add(pacman);
		options.add(fruit);
		options.add(run);
		this.setMenuBar(menuBar);
		exit.setEnabled(true);
		
				//***//the role of each button//***//
		ActionListener l = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand()=="Exit") {
					//clears the game board (clears 'PacmanList' and 'FruitsList')
					mainPacmanList.clear(); 
					mainFruitsList.clear();
					System.exit(0);
				}
				//loads a .csv file
				if(e.getActionCommand()=="Load") {
					JFileChooser fc = new JFileChooser();
					File dir = new File("C:/Users/doron/Desktop/data");
					fc.setCurrentDirectory(dir);
					fc.showOpenDialog(getParent());
					if(fc.getSelectedFile().getName().endsWith(".csv")) {
						PacmanCsvReader.csv(fc.getSelectedFile().getPath(), mainPacmanList, mainFruitsList); //reading the file and generates the PacmanList and the FruitsList 
						repaint();
					}
					else {
						System.out.println("ERROR: the file must be a csv file."); //if the file isn't a .csv file
					}
				}
				if(e.getActionCommand()=="Pacman") {
					pac=true;
					fru=false;
					def=false;
					runSim=false;
				}
				
				if(e.getActionCommand()=="Fruit") {
					fru=true;
					pac=false;
					def=false;
					runSim=false;
				}
				
				if(e.getActionCommand()=="Clear") {
					mainPacmanList.clear();
					mainFruitsList.clear();
					pathlist.clear();
					fru=false;
					pac=false;
					isFirstPac=true;
					isFirstFru=true;
					runSim=false;
					repaint();
				}
				//starts the game.
				if(e.getActionCommand()=="Run") {
					fru=false;
					pac=false;
					def=false;
					runSim=true;
					pathlist = new PathList (mainPacmanList);
					GameAlgo.pathArrange(pathlist, mainFruitsList);
					repaint();
				}
			}
		};
		
		exit.addActionListener(l);
		load.addActionListener(l);
		pacman.addActionListener(l);
		fruit.addActionListener(l);
		clear.addActionListener(l);
		run.addActionListener(l);

		//importing the game pictures.
		try {
			myImage = ImageIO.read(new File("Ariel1.png"));
			myPac = ImageIO.read(new File("PacMan.png"));
			myFru1 = ImageIO.read(new File("g1.png"));
			start = ImageIO.read(new File("start.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	int x = -1;
	int y = -1;


	@Override
	//runs this method with every click of the mouse.
	public void mouseClicked(MouseEvent arg) {
		System.out.println("pixels point: ("+ arg.getX() + "," + arg.getY() +")");
		x = arg.getX();
		y = arg.getY();
		p=GIS.Map.pixelsToCoords(x, y, getWidth(), getHeight());     //insert the coordinates values given by the pixels to a point.
		currentPointInPixels=GIS.Map.coordsToPixels(p, getWidth(), getHeight());        //insert the pixels given by the coordinates values to an double[].	
		repaint();	
	}

	public void paint(Graphics g)
	{
		g.drawImage(myImage, 0, 0, getWidth()-8, getHeight()-8, this);
		if(x!=-1 && y!=-1)
		{
			int r = 15;
			x = x - (r / 2);
			y = y - (r / 2);

		}
		Graphics2D g2d = (Graphics2D) g;
		if(pac) {      //if the user selected 'pacman' option.
			Pacman pacman = new Pacman(mainPacmanList.getSize(), p.x(), p.y(), p.z(), 1, 1);  //creating pacman with the current point values.
			if(isFirstPac) {            //if this is the first pacman.
				mainPacmanList.add(pacman);       //adding the pacman to the pacman list.
				isFirstPac=false;
			}
			else if(mainPacmanList.lastPacman().getLat()!=p.x() && mainPacmanList.lastPacman().getLon()!=p.y()) {   //if this pacman already exists, don't add it.
				mainPacmanList.add(pacman);       //adding the pacman to the pacman list.
			}
		}
		if(fru) {
			Fruit fruit = new Fruit(mainFruitsList.getSize(), p.x(), p.y(), p.z(), 1);     //creating fruit with the current point values.
			if(isFirstFru) {          //if this is the first fruit.
				mainFruitsList.add(fruit);        //adding the fruit to the fruits list.
				isFirstFru=false;
			}
			else if(mainFruitsList.lastFruit().getLat()!=p.x() && mainFruitsList.lastFruit().getLon()!=p.y()) {   //if this fruit already exists, don't add it.
				mainFruitsList.add(fruit);        //adding the fruit to the fruits list.
			}
		}
		Iterator<Fruit> itf = mainFruitsList.Iterator();
		while(itf.hasNext()) {
			Fruit temp = itf.next();		
			Point3D point1 = new Point3D(temp.getLat(), temp.getLon(), temp.getAlt());
			currentPointInPixels=Map.coordsToPixels(point1, getWidth(), getHeight());
			g2d.drawImage(myFru1, currentPointInPixels[0]-10, currentPointInPixels[1]-10, 20, 20, this); 
		}
		mainFruitsList.print();
		if(def) {         //neither pacman nor fruit were selected.
			g2d.setColor(Color.blue);
			currentPointInPixels=Map.coordsToPixels(p, getWidth(), getHeight());
			g2d.fillOval(currentPointInPixels[0]-5, currentPointInPixels[1]-5, 10, 10);      //drawing the current point.
		}

		if(runSim) {
			Iterator<Pacman> itPac = mainPacmanList.Iterator();
			int pacIndex=0;

			while(itPac.hasNext()) {
				Pacman currentPac = itPac.next();
				pacIndex=mainPacmanList.getPacIndex(currentPac);
				Path currentPath=pathlist.getPath(pacIndex);
				Iterator<Point3D> itCurrentPoint = currentPath.Iterator();
				while(itCurrentPoint.hasNext()) {
					Point3D nextPoint = itCurrentPoint.next();
					currentPac.setLat(nextPoint.x());
					currentPac.setLon(nextPoint.y());
					currentPac.setAlt(nextPoint.z());
				}
			}
		}
		Iterator<Path> itPathList = pathlist.Iterator();
		while(itPathList.hasNext()) {
			Path temp = itPathList.next();
			System.out.println("overall time of "+temp.getId()+" is:"+temp.getOverallTime()); ///prints the time of the path///
			Point3D prevPoint = temp.firstPoint();
			Point3D startPoint = temp.firstPoint();
			int [] nextPointPixels= new int[2];
			int [] startPointPixels = new int [2]; 
			startPointPixels=Map.coordsToPixels(startPoint, getWidth(), getHeight());
			///generates a random color for each path
			float red = rnd.nextFloat();
			float green = rnd.nextFloat();
			float blue = rnd.nextFloat();
			Color rndColor = new Color(red, green, blue);
			
			Stroke s = new BasicStroke(3.5f); //makes the lines and dots thicker.

			Iterator<Point3D> itPoint = temp.Iterator();
			//prints the path
			while(itPoint.hasNext()) {
				Point3D tempPoint = itPoint.next();
				currentPointInPixels=Map.coordsToPixels(prevPoint, getWidth(), getHeight());
				nextPointPixels=Map.coordsToPixels(tempPoint, getWidth(), getHeight());
				g2d.setStroke(s);
				g2d.setColor(rndColor);
				g2d.drawLine(currentPointInPixels[0], currentPointInPixels[1], nextPointPixels[0], nextPointPixels[1]); //draw a single section of a path with a line between two points. 
				g2d.setColor(Color.WHITE);  
				g2d.fillOval(currentPointInPixels[0]-5, currentPointInPixels[1]-5, 10, 10); //prints the eaten fruits with white dots.
				g2d.drawImage(start, startPointPixels[0]-14, startPointPixels[1]-40, 40, 40, this); //prints the start point for each pacman with a flag.
				prevPoint=tempPoint;
			}
		}
		//***//draws each pacman in it's final position //***//
		Iterator<Pacman> itp = mainPacmanList.Iterator();
		while(itp.hasNext()) {
			Pacman tempPac = itp.next();
			Point3D point = new Point3D(tempPac.getLat(), tempPac.getLon(), tempPac.getAlt());
			currentPointInPixels=Map.coordsToPixels(point, getWidth(), getHeight());
			g2d.drawImage(myPac, currentPointInPixels[0]-15, currentPointInPixels[1]-15, 30, 30, this);     //drawing the current pacman.     

		}
		mainPacmanList.Print();
	}
	
	@Override
	public void mouseEntered(MouseEvent arg0) {
		//System.out.println("mouse entered");
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		//System.out.println("mouse exited");		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

}
