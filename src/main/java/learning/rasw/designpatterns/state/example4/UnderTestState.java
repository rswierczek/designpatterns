package learning.rasw.designpatterns.state.example4;

public class UnderTestState implements State {
    private ChangeRequestContext changeRequestContext;

    public UnderTestState(ChangeRequestContext changeRequestContext) {
        this.changeRequestContext = changeRequestContext;
    }

    @Override
    public void assignToDev() {
        System.out.println("Assigning Back to Developer.");
        this.changeRequestContext.setCurrentState(changeRequestContext.getUnderDevState());
    }

    @Override
    public void assignToTester() {
        System.out.println("Cannot be done as already under test.");
    }

    @Override
    public void markTested() {
        System.out.println("Marking as tested.");
        this.changeRequestContext.setCurrentState(changeRequestContext.getClosedState());
    }
}
