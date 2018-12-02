package Coords;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import Geom.Point3D;

class myCoordsTest {

	@Test
	void testAdd() {
		myCoords m=new myCoords();
		Point3D gps1=new Point3D(0,0,0);
		Point3D gps0=new Point3D( 32.001094,  34.950391, 58);
		Point3D vector=new Point3D( -391.9621161751731, -1599.285928235099, 34.0);
		gps1=m.add(gps0, vector);
		
		Assert.assertEquals(31.997569, gps1.x(), 0.1);
		Assert.assertEquals(34.933431, gps1.y(), 0.1);
		Assert.assertEquals(92, gps1.z(), 0.1);

		
	}

	@Test
	void testDistance3d() {
		myCoords m=new myCoords();
		Point3D gps0=new Point3D( 32.001094,  34.950391, 58);
		Point3D gps1=new Point3D( 32.886176,  35.088681, 7);
		double dis=m.distance3d(gps0, gps1);
		
		Assert.assertEquals(99273, dis, 0.1);
	}

	@Test
	void testVector3D() {
		myCoords m=new myCoords();
		Point3D gps0=new Point3D( 32.001094,  34.950391, 58);
		Point3D gps1=new Point3D( 31.997569,  34.933431, 92);
		Point3D vector=new Point3D(m.vector3D(gps0, gps1));
		
		Assert.assertEquals(-391.962, vector.x(), 0.1);
		Assert.assertEquals(-1599.285, vector.y(), 0.1);
		Assert.assertEquals(34, vector.z(), 0.1);

	}

	@Test
	void testAzimuth_elevation_dist() {
		myCoords m=new myCoords();
		double [] res = new double [3];
		Point3D gps0=new Point3D( 32.001094,  34.950391, 58);
		Point3D gps1=new Point3D( 31.997569,  34.933431, 92);
		res=m.azimuth_elevation_dist(gps0, gps1);
		
		Assert.assertEquals(256.2290670384151, res[0], 0);
		Assert.assertEquals(1.1831495449328315, res[1], 0);
		Assert.assertEquals(1646.61767899149, res[2], 0);
	}

	@Test
	void testIsValid_GPS_Point() {
		myCoords m=new myCoords();
		
		Point3D gps0=new Point3D( 32.001094,  34.950391, 58);
		Point3D gps1=new Point3D( 32.001094,  91.950391, 345);
		Point3D gps2=new Point3D( 189.001094,  34.950391, 58);
		
		Assert.assertTrue(m.isValid_GPS_Point(gps0));
		Assert.assertFalse(m.isValid_GPS_Point(gps1));
		Assert.assertFalse(m.isValid_GPS_Point(gps2));
		
	
	}

}
