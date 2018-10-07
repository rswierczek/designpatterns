package learning.rasw.designpatterns.state.example5;

/**
 * https://www.baeldung.com/java-state-design-pattern
 */
public class Demo {
    public static void main(String[] args) {

        Package pkg = new Package();
        pkg.printStatus();

        pkg.nextState();
        pkg.printStatus();

        pkg.nextState();
        pkg.printStatus();

        pkg.nextState();
        pkg.printStatus();
    }
}
