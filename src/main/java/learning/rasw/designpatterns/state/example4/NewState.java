package learning.rasw.designpatterns.state.example4;

public class NewState implements State {
    private ChangeRequestContext changeRequestContext;

    public NewState(ChangeRequestContext changeRequestContext) {
        this.changeRequestContext = changeRequestContext;
    }

    @Override
    public void assignToDev() {
        System.out.println("Assigning to available developer.");
        this.changeRequestContext.setCurrentState(changeRequestContext.getUnderDevState());
    }

    @Override
    public void assignToTester() {
        System.out.println("Cannot be assigned to tester from new state.");
    }

    @Override
    public void markTested() {
        System.out.println("Cannot be marked tested when it is new.");
    }
}
