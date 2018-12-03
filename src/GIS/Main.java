package GIS;

public class Main {

	public static void main(String[] args) {
		ElementLayer el = new ElementLayer();
		Element e = new Element();
		el.add(e);
		boolean b = el.contains(e);
		boolean b1 = el.isEmpty();
		
		System.out.println("b: "+b+" b1: "+b1);
	}

}
