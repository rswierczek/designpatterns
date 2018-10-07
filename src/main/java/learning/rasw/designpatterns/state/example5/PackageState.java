package learning.rasw.designpatterns.state.example5;

public interface PackageState {
    void next(Package pkg);
    void prev(Package pkg);
    void printStatus();
}
