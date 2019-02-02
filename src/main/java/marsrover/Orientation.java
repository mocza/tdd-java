package marsrover;

import java.text.MessageFormat;
import java.util.Arrays;

public enum Orientation {
    NORTH("N"), WEST("W"), SOUTH("S"), EAST("E");

    private String abbrev;

    Orientation(String abbrev) {
        this.abbrev = abbrev;
    }

    public String getAbbrev() {
        return abbrev;
    }

    public static Orientation forAbbrev(String abbrev) {
        return Arrays.stream(Orientation.values()).filter(orientation -> orientation.abbrev.equals(abbrev)).findFirst()
                .orElseThrow( () -> new UnsupportedOperationException(MessageFormat.format("No Orientation defined for abbreviation {1}", abbrev)));
    }
}
