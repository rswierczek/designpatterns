package learning.rasw.designpatterns.state.example2.after;

public class TVContext {
    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void doAction() {
        state.doAction();
    }
}
