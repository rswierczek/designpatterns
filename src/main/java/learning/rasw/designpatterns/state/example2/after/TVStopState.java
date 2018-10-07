package learning.rasw.designpatterns.state.example2.after;

public class TVStopState implements State {
    @Override
    public void doAction() {
        System.out.println("TV is turned OFF");
    }
}
