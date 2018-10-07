package learning.rasw.designpatterns.state.example4;

public class ClosedState implements State {
    private ChangeRequestContext changeRequestContext;

    public ClosedState(ChangeRequestContext changeRequestContext) {
        this.changeRequestContext = changeRequestContext;
    }


    @Override
    public void assignToTester() {

    }

    @Override
    public void assignToDev() {

    }

    @Override
    public void markTested() {

    }
}
