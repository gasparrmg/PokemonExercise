import java.util.Objects;

public class Coordinate {
    private int x;
    private int y;

    public Coordinate() {
        // EMPTY
    }

    public Coordinate(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void goNorth() {
        this.y++;
    }

    public void goSouth() {
        this.y--;
    }

    public void goEast() {
        this.x++;
    }

    public void goWest() {
        this.x--;
    }

    public void reset() {
        this.x = 0;
        this.y = 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinate that = (Coordinate) o;
        return x == that.x && y == that.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }
}
