package learning.rasw.designpatterns.state.example3;


import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

enum State {
    OFF_HOOK,
    ON_HOOK,
    CONNECTING,
    CONNECTED,
    ON_HOLD
}
enum Trigger {
    CALL_DIALED,
    HANG_UP,
    CALL_CONNECTED,
    PLACED_ON_HOLD,
    TAKEN_OFF_HOLD,
    LEFT_MESSAGE,
    STOP_USING_PHONE
}

class StateMachine {
    public final Map<State, List<Pair<Trigger, State>>> rules;
    private State currentState;

    StateMachine(Map<State, List<Pair<Trigger, State>>> rules, State initState) {
        this.rules = rules;
        this.currentState = initState;
    }

    public void changeState(Trigger trigger){
        currentState = rules.get(currentState).stream()
                .filter(p -> trigger.equals(p.getKey()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Incorrect Trigger"))
                .getValue();

    }

    public State getCurrentState() {
        return currentState;
    }
}


/**
 * Simple state machine. For more complex problem use Spring State Machine.
 */
public class Demo {

    public static final Map<State, List<Pair<Trigger, State>>> rules = new HashMap<>();
    static
    {
        rules.put(State.OFF_HOOK, Arrays.asList(
                Pair.of(Trigger.CALL_DIALED, State.CONNECTING),
                Pair.of(Trigger.STOP_USING_PHONE , State.ON_HOOK)
        ));

        rules.put(State.CONNECTING, Arrays.asList(
                Pair.of(Trigger.HANG_UP, State.OFF_HOOK),
                Pair.of(Trigger.CALL_CONNECTED , State.CONNECTED)
        ));

        rules.put(State.CONNECTED, Arrays.asList(
                Pair.of(Trigger.LEFT_MESSAGE, State.OFF_HOOK),
                Pair.of(Trigger.HANG_UP , State.OFF_HOOK),
                Pair.of(Trigger.PLACED_ON_HOLD , State.ON_HOLD)
        ));

        rules.put(State.ON_HOLD, Arrays.asList(
                Pair.of(Trigger.TAKEN_OFF_HOLD, State.CONNECTED),
                Pair.of(Trigger.HANG_UP , State.OFF_HOOK)
        ));
    }

    public static void main(String[] args) {
        StateMachine stateMachine = new StateMachine(rules, State.OFF_HOOK);
        System.out.println(stateMachine.getCurrentState());

        //Call Dial event
        stateMachine.changeState(Trigger.CALL_DIALED);
        System.out.println(stateMachine.getCurrentState());
    }
}
