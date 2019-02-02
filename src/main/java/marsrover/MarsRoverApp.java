package marsrover;

import java.util.Collection;

public class MarsRoverApp {
    private final Rover rover;
    private int areaEndsX;
    private int areaEndsY;

    public MarsRoverApp(int areaEndsX, int areaEndsY, Rover rover) {
        this.areaEndsX = areaEndsX;
        this.areaEndsY = areaEndsY;
        this.rover = rover;
    }

    public Rover execute(Event event) {
        return rover.execute(event, areaEndsX, areaEndsY);
    }

    public Rover getRover() {
        return rover;
    }


}
