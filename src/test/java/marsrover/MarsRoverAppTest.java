package marsrover;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MarsRoverAppTest {


    @Test(expected = IllegalStateException.class)
    public void moveUpFacingNFails() throws Exception {
        MarsRoverApp app = new MarsRoverApp(5, 5, new Rover(Orientation.NORTH, new RoverPosition(0, 5)));
        app.execute(Event.MOVE);
    }

    @Test(expected = IllegalStateException.class)
    public void moveDownFacingSFails() throws Exception {
        MarsRoverApp app = new MarsRoverApp(5, 5, new Rover(Orientation.SOUTH, new RoverPosition(4, 0)));
        app.execute(Event.MOVE);
    }

    @Test(expected = IllegalStateException.class)
    public void moveLeftFacingWFails() throws Exception {
        MarsRoverApp app = new MarsRoverApp(1, 1, new Rover(Orientation.forAbbrev( "W"), new RoverPosition(0, 1)));
        app.execute(Event.MOVE);
    }

    @Test(expected = IllegalStateException.class)
    public void moveRightFacingEFails() throws Exception {
        MarsRoverApp app = new MarsRoverApp(1, 1, new Rover(Orientation.forAbbrev( "E"), new RoverPosition(1, 0)));
        app.execute(Event.MOVE);
    }


    @Test
    public void moveUpFacingN() throws Exception {
        MarsRoverApp app = new MarsRoverApp(0, 1, new Rover(Orientation.NORTH, new RoverPosition(0, 0)));
        app.execute(Event.MOVE);
        assertEquals("N", app.getRover().getOrientation());
        assertEquals(new RoverPosition(0, 1), app.getRover().getRoverPosition());
    }

    @Test
    public void moveDownFacingS() throws Exception {
        MarsRoverApp app = new MarsRoverApp(0, 0, new Rover(Orientation.SOUTH, new RoverPosition(0, 1)));
        app.execute(Event.MOVE);
        assertEquals("S", app.getRover().getOrientation());
        assertEquals(new RoverPosition(0, 0), app.getRover().getRoverPosition());
    }

    @Test
    public void moveLeftFacingW() throws Exception {
        MarsRoverApp app = new MarsRoverApp(1, 1, new Rover(Orientation.forAbbrev( "W"), new RoverPosition(1, 1)));
        app.execute(Event.MOVE);
        assertEquals("W", app.getRover().getOrientation());
        assertEquals(new RoverPosition(0, 1), app.getRover().getRoverPosition());
    }

    @Test
    public void moveRightFacingE() throws Exception {
        MarsRoverApp app = new MarsRoverApp(1, 1, new Rover(Orientation.forAbbrev( "E"), new RoverPosition(0, 0)));
        app.execute(Event.MOVE);
        assertEquals("E", app.getRover().getOrientation());
        assertEquals(new RoverPosition(1, 0), app.getRover().getRoverPosition());
    }

    @Test
    public void rotateLeftChangesOrientationFromNtoW() throws Exception {
        MarsRoverApp app = new MarsRoverApp(0, 0, new Rover(Orientation.forAbbrev( "N"), new RoverPosition(0, 0)));
        app.execute(Event.LEFT);
        assertEquals("W", app.getRover().getOrientation());
    }

    @Test
    public void rotateLeftChangesOrientationFromWtoS() throws Exception {
        MarsRoverApp app = new MarsRoverApp(0, 0, new Rover(Orientation.forAbbrev( "W"), new RoverPosition(0, 0)));
        app.execute(Event.LEFT);
        assertEquals("S", app.getRover().getOrientation());
    }

    @Test
    public void rotateLeftChangesOrientationFromStoE() throws Exception {
        MarsRoverApp app = new MarsRoverApp(0, 0, new Rover(Orientation.forAbbrev( "S"), new RoverPosition(0, 0)));
        app.execute(Event.LEFT);
        assertEquals("E", app.getRover().getOrientation());
    }

    @Test
    public void rotateLeftChangesOrientationFromEtoN() throws Exception {
        MarsRoverApp app = new MarsRoverApp(0, 0, new Rover(Orientation.forAbbrev( "E"), new RoverPosition(0, 0)));
        app.execute(Event.LEFT);
        assertEquals("N", app.getRover().getOrientation());
    }

    @Test
    public void rotateRightChangesOrientationFromNtoE() throws Exception {
        MarsRoverApp app = new MarsRoverApp(0, 0, new Rover(Orientation.forAbbrev( "N"), new RoverPosition(0, 0)));
        app.execute(Event.RIGHT);
        assertEquals("E", app.getRover().getOrientation());
    }

    @Test
    public void rotateRightChangesOrientationFromEtoS() throws Exception {
        MarsRoverApp app = new MarsRoverApp(0, 0, new Rover(Orientation.forAbbrev( "E"), new RoverPosition(0, 0)));
        app.execute(Event.RIGHT);
        assertEquals("S", app.getRover().getOrientation());
    }

    @Test
    public void rotateRightChangesOrientationFromStoW() throws Exception {
        MarsRoverApp app = new MarsRoverApp(0, 0, new Rover(Orientation.forAbbrev( "S"), new RoverPosition(0, 0)));
        app.execute(Event.RIGHT);
        assertEquals("W", app.getRover().getOrientation());
    }

    @Test
    public void rotateRightChangesOrientationFromEtoN() throws Exception {
        MarsRoverApp app = new MarsRoverApp(0, 0, new Rover(Orientation.forAbbrev( "W"), new RoverPosition(0, 0)));
        app.execute(Event.RIGHT);
        assertEquals("N", app.getRover().getOrientation());
    }

}
