package learning.rasw.designpatterns.state.example5;

public class Package {
    private PackageState state = new OrderedState();


    public void nextState() {
        state.next(this);
    }

    public void previousState() {
        state.prev(this);
    }

    public void printStatus() {
        state.printStatus();
    }


    public PackageState getState() {
        return state;
    }

    public void setState(PackageState state) {
        this.state = state;
    }
}
