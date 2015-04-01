import junit.framework.Assert;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

@SuppressWarnings("deprecation")
public class PlayerTest {

	private static Player p;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		PlayerTest.p = new Player();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		PlayerTest.p = null;
	}

	@Test
    public void testSetXPos() {
		// Hier wird ein erfolg erwartet
        final int xPos = 100;
        p.setxPos(xPos);
        Assert.assertEquals(p.getxPos(), xPos);
    }

	@Test
	public void testSetPlayerSpeedDown() {
		// Erfolg erwartet
		final int down = 30;
		p.setPlayerSpeedDown(down);
		Assert.assertEquals(p.getPlayerSpeedDown(), down);
	}

	@Test
	public void testSetPlayerSpeedLeft() {
		final int left = 10;
		p.setPlayerSpeedLeft(left);
		Assert.assertEquals(p.getPlayerSpeedLeft(), left);

	}

	@Test
	public void testSetName() {
		final int xMove = 20;
		p.setxMove(xMove);
		Assert.assertEquals(p.getxMove(), xMove);
	}
}