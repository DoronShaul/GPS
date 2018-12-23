package GIS;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Geom.Point3D;
import junit.framework.Assert;

/**
 * this class is a test class of the map class.
 */
class MapTest {

	@Test
	void testPixelsToCoords() {
		Point3D ans = Map.pixelsToCoords(727, 538, 1433, 642);
		Point3D p = new Point3D(32.102507252365925, 35.20756039157895);
		assertEquals(p.x(), ans.x(), 0.0001);
		assertEquals(p.y(), ans.y(), 0.0001);
		assertEquals(p.z(), ans.z(), 0.0001);
	}

	@Test
	void testCoordsToPixels() {
		Point3D p = new Point3D(32.102507252365925, 35.20756039157895);
		int [] ans = Map.coordsToPixels(p, 1433, 642);
		assertEquals(727, ans[0]);
		assertEquals(538, ans[1]);
	}

}
