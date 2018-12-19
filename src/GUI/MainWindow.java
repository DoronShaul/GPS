package GUI;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
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

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;
import javax.swing.plaf.FileChooserUI;

import File_format.Csv2kml;
import File_format.PacmanCsvReader;
import File_format.csvReader;
import GIS.Fruit;
import GIS.FruitsList;
import GIS.Map;
import GIS.Pacman;
import GIS.PacmanList;
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
	private boolean pac=false;
	private boolean fru=false;
	private boolean def=true;
	private boolean isFirstPac=true;
	private boolean isFirstFru=true;

	int []a=new int[2];
	Point3D p= new Point3D(0, 0);
	private PacmanList mainPacmanList = new PacmanList();
	private FruitsList mainFruitsList = new FruitsList();

	
	public BufferedImage myImage;
	public BufferedImage myPac;
	public BufferedImage myFru;
	public BufferedImage myFru1;
	public BufferedImage myFru2;
	
	
	public MainWindow() 
	{
		initGUI();		
		this.addMouseListener(this);
	}
	
	private void initGUI() 
	{
		MenuBar menuBar = new MenuBar();
		Menu file = new Menu("File"); 
		Menu options = new Menu("Options");
		MenuItem item1 = new MenuItem("Save");
		MenuItem item2 = new MenuItem("Exit");
		MenuItem item3 = new MenuItem("Packman");
		MenuItem item4 = new MenuItem("Fruit");
		MenuItem item5 = new MenuItem("Run");
		MenuItem item6 = new MenuItem("Load");
		MenuItem item7 = new MenuItem("Clear");
		
		
		
		menuBar.add(file);
		menuBar.add(options);
		file.add(item1);
		file.add(item6);
		file.add(item7);
		file.add(item2);
		options.add(item3);
		options.add(item4);
		
		options.add(item5);
		this.setMenuBar(menuBar);
		item2.setEnabled(true);
		ActionListener l = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getActionCommand()=="Exit") {
					mainPacmanList.clear();
					mainFruitsList.clear();
					System.exit(0);
				}
				if(e.getActionCommand()=="Load") {
					JFileChooser fc = new JFileChooser();
					File dir = new File("C:/Users/doron/Desktop/data");
					fc.setCurrentDirectory(dir);
					fc.showOpenDialog(getParent());
					if(fc.getSelectedFile().getName().endsWith(".csv")) {
						PacmanCsvReader.csv(fc.getSelectedFile().getPath(), mainPacmanList, mainFruitsList);
						repaint();
					}
					else {
						System.out.println("ERROR: the file must be a csv file.");
					}
				}
				if(e.getActionCommand()=="Packman") {
					pac=true;
					fru=false;
					def=false;
				}
				if(e.getActionCommand()=="Fruit") {
					fru=true;
					pac=false;
					def=false;
				}
				if(e.getActionCommand()=="Clear") {
					mainPacmanList.clear();
					mainFruitsList.clear();
					fru=false;
					pac=false;
					repaint();
				}
				
				
			}
		};
		item2.addActionListener(l);
		item6.addActionListener(l);
		item3.addActionListener(l);
		item4.addActionListener(l);
		item7.addActionListener(l);
		
		
		try {
			 myImage = ImageIO.read(new File("Ariel1.png"));
			 myPac = ImageIO.read(new File("PacMan.png"));
			 myFru = ImageIO.read(new File("g.png"));
			 myFru1 = ImageIO.read(new File("g1.png"));
			 myFru2 = ImageIO.read(new File("g2.png"));
			 
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	int x = -1;
	int y = -1;

	
	@Override
	public void mouseClicked(MouseEvent arg) {
		System.out.println("pixels point: ("+ arg.getX() + "," + arg.getY() +")");
		x = arg.getX();
		y = arg.getY();
		p=GIS.Map.pixelsToCoords(x, y, getWidth(), getHeight());     //insert the coordinates values given by the pixels to a point.
		a=GIS.Map.coordsToPixels(p, getWidth(), getHeight());        //insert the pixels given by the coordinates values to an double[].
	
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
		Iterator<Pacman> itp = mainPacmanList.Iterator();
		while(itp.hasNext()) {
			       //the color of the pacman.
			Pacman tempPac = itp.next();
			Point3D point = new Point3D(tempPac.getLat(), tempPac.getLon(), tempPac.getAlt());
			a=Map.coordsToPixels(point, getWidth(), getHeight());
			g2d.drawImage(myPac, a[0]-15, a[1]-15, 30, 30, this);     //drawing the current pacman.     
			
		}
		mainPacmanList.Print();
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
			a=Map.coordsToPixels(point1, getWidth(), getHeight());
			if(temp.getId()==0) {
				g2d.drawImage(myFru, a[0]-10, a[1]-10, 20, 20, this);     //printing the current fruit if it's the first.
			}
			if(temp.getId()%1==0) {
				g2d.drawImage(myFru, a[0]-10, a[1]-10, 20, 20, this);    //printing the current fruit if it's id number % 1 = 0.
			}
			if(temp.getId()%2==0) {
				g2d.drawImage(myFru1, a[0]-10, a[1]-10, 20, 20, this);   //printing the current fruit if it's id number % 2 = 0.
			}
			if(temp.getId()%3==0) {
				g2d.drawImage(myFru2, a[0]-10, a[1]-10, 20, 20, this);   //printing the current fruit if it's id number % 3 = 0.
			}
		}
		mainFruitsList.print();
		if(def) {         //neither pacman nor fruit were selected.
			g2d.setColor(Color.blue);
			a=Map.coordsToPixels(p, getWidth(), getHeight());
			g2d.fillOval(a[0]-5, a[1]-5, 10, 10);      //drawing the current point.
		}		

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
