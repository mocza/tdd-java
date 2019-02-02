package marsrover;

/**
 * Created by Salty on 2/2/2019.
 */
public class RoverPosition {
    private int x;
    private int y;

    public RoverPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public RoverPosition moveX(int value) { return new RoverPosition(x + value, y); }
    public RoverPosition moveY(int value) { return new RoverPosition(x, y + value); }

    public boolean isValid(int areaEndsX, int areaEndsY) {
        return x <= areaEndsX && x >= 0 && y <= areaEndsY && y >= 0;
    }

    @Override
    public String toString() {
        return "RoverPosition{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RoverPosition that = (RoverPosition) o;

        if (x != that.x) return false;
        return y == that.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
