package marsrover;

import java.text.MessageFormat;
import java.util.function.UnaryOperator;

import static java.util.function.UnaryOperator.identity;

public class Rover {
    private Orientation roverState;
    private RoverPosition roverPosition;

    private StateTransition[] transitions = new StateTransition[] {
        new StateTransition(Orientation.NORTH, Event.LEFT, Orientation.WEST, identity()),
        new StateTransition(Orientation.WEST, Event.LEFT, Orientation.SOUTH, identity()),
        new StateTransition(Orientation.SOUTH, Event.LEFT, Orientation.EAST, identity()),
        new StateTransition(Orientation.EAST, Event.LEFT, Orientation.NORTH, identity()),
        new StateTransition(Orientation.NORTH, Event.RIGHT,Orientation.EAST, identity()),
        new StateTransition(Orientation.EAST, Event.RIGHT, Orientation.SOUTH, identity()),
        new StateTransition(Orientation.SOUTH, Event.RIGHT,Orientation.WEST, identity()),
        new StateTransition(Orientation.WEST, Event.RIGHT, Orientation.NORTH, identity()),
        new StateTransition(Orientation.NORTH, Event.MOVE,Orientation.NORTH, position ->  position.moveY(1)),
        new StateTransition(Orientation.EAST, Event.MOVE, Orientation.EAST, position -> position.moveX(1)),
        new StateTransition(Orientation.SOUTH, Event.MOVE, Orientation.SOUTH, position -> position.moveY(-1)),
        new StateTransition(Orientation.WEST, Event.MOVE, Orientation.WEST, position -> position.moveX(-1))
    };

    public Rover(Orientation roverState, RoverPosition roverPosition) {
        this.roverState = roverState;
        this.roverPosition = roverPosition;
    }

    public Rover execute(Event event, int areaEndsX, int areaEndsY) {
        StateTransition foundTransition = null;
        for (StateTransition transition: transitions) {
            if (transition.currentState.getAbbrev().equals(roverState.getAbbrev())
                    && event.equals(transition.event)) {
                foundTransition = transition;
            }
        }
        if (foundTransition != null) {
            roverState = foundTransition.nextState;
            RoverPosition newPosition = foundTransition.action.apply(roverPosition);
            if (newPosition.isValid(areaEndsX, areaEndsY)) {
                this.roverPosition = newPosition;
            } else {
                throw new IllegalStateException(MessageFormat.format("Cannot move out of the area with position={0}}", newPosition));
            }
            return this;
        } else {
            throw new IllegalStateException(String.format("No state transition defined from orientation %s to %s", roverState.getAbbrev(), event));
        }
    }

    private static final class StateTransition {
        private Orientation currentState;
        private Orientation nextState;
        private Event event;
        private UnaryOperator<RoverPosition> action;

        public StateTransition(Orientation currentState, Event event, Orientation nextState, UnaryOperator<RoverPosition> action) {
            this.currentState = currentState;
            this.event = event;
            this.nextState = nextState;
            this.action = action;
        }
    }

    public String getOrientation() {
        return roverState.getAbbrev();
    }

    public RoverPosition getRoverPosition() {
        return roverPosition;
    }
}
