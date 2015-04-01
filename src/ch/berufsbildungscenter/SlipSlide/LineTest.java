package ch.berufsbildungscenter.SlipSlide;
import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

@SuppressWarnings("deprecation")
public class LineTest {

	private static Line l;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		LineTest.l = new Line();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		LineTest.l = null;
	}

	@Test
    public void testSetScrollSpeed() {
		// Hier wird ein erfolg erwartet
        final int scrollSpeed = 100;
        l.setScrollSpeed(scrollSpeed);;
        Assert.assertEquals(l.getScrollSpeed(), scrollSpeed);
    }

	@Test
	public void testSetZufallsZahl() {
		// Erfolg erwartet
		final int zz = l.getZufallsZahl();
		l.setZufallsZahl(zz);
		Assert.assertEquals(l.getZufallsZahl(), zz);
	}

	@Test
	public void testSetY() {
		final int y = 10;
		l.setY(y);
		Assert.assertEquals(l.getY(), y);

	}

	@Test
	public void testSetName() {
		final int yMove = 40;
		l.setyMove(yMove);
		Assert.assertEquals(l.getyMove(), yMove);
	}
}