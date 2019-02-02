package marsrover;

public enum Event {
    MOVE("M"), LEFT("L"), RIGHT("R");

    private String abbrev;

    Event(String abbrev) {
        this.abbrev = abbrev;
    }
}
