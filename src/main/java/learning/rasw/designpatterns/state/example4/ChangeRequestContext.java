package learning.rasw.designpatterns.state.example4;

public class ChangeRequestContext {
    private State newState;
    private State underDevState;
    private State underTestState;
    private State closedState;
    private State currentState = new NewState(this);
    public ChangeRequestContext() {
        newState = new NewState(this);
        underDevState = new UnderDevState(this);
        underTestState = new UnderTestState(this);
        closedState = new ClosedState(this);
    }
    public void assignToDev() {
        currentState.assignToDev();
    }
    public void assignToTester() {
        currentState.assignToTester();
    }
    public void markTested() {
        currentState.markTested();
    }

    public State getNewState() {
        return newState;
    }

    public State getUnderDevState() {
        return underDevState;
    }

    public State getUnderTestState() {
        return underTestState;
    }

    public State getClosedState() {
        return closedState;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }
}
