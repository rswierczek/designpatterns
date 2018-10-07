package learning.rasw.designpatterns.state.example4;

public class UnderDevState implements State {
    private ChangeRequestContext changeRequestContext;

    public UnderDevState(ChangeRequestContext changeRequestContext) {
        this.changeRequestContext = changeRequestContext;
    }

    @Override
    public void assignToDev(){
        System.out.println("It's already assigned to a developer.");
    }

    @Override
    public void assignToTester(){
        System.out.println("Assigning to available tester.");
        this.changeRequestContext.setCurrentState(changeRequestContext.getUnderTestState());
    }

    @Override
    public void markTested(){
        System.out.println("Cannot be marked tested when it is under dev.");
    }
}
