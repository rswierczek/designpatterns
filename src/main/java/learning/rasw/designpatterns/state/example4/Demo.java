package learning.rasw.designpatterns.state.example4;


/**
 * https://www.javabrahman.com/design-patterns/state-design-pattern-in-java/
 *
 * Explanation of Java Example’s Class Diagram & Code
 * The Java class diagram above depicts State Design pattern implemented for a ChangeRequest State Handler. Lets quickly go through whats there in UML class diagram & corresponding code –
 *
 *     State is the base interface which implements 3 methods – assignToDev, assignToTester() and markTested(). These 3 methods represent the 3 transitions possible between states.
 *     There are 4 concrete states – NewState, UnderDevState, UnderTestState and ClosedState.
 *     The allowed transitions between states are –
 *         NewState to UnderDevState transition is possible through assignToDev().
 *         UnderDev state to UnderTest state transition is possible through assignToTester().
 *         In UnderTest state tester can transition the CR back to UnderDev state if he finds an error using assignToDev(). If tester passes the CR then he transitions it to Closed state using markClosed().
 *     The Client invokes series of transitions in sequence. Some transitions are valid and move the CR to the next state. For eg: When moving from New to UnderDev the following is output – Assigning to available developer.
 *     There are also some invalid transitions such as invoking assignToTester() in NewState without going through UnderDev state in which case the line Cannot be assigned to tester from new state – is printed.
 *     Thus, a CR moves through the states – New > UnderDev > UnderTest > Closed during its lifecycle.
 *
 * Summary
 * In the above tutorial we understood what is State design pattern and its main advantage. We then looked at the UML class diagram for State Design Pattern & its explanation, a Java Use Case implementing State pattern with its class diagram and code for the classes shown in the class diagram, followed by explanation of both the class diagram & code. This concludes the tutorial on State design pattern.
 */
public class Demo {
    public static void main(String args[]){
        ChangeRequestContext changeRequestContext = new ChangeRequestContext();
        changeRequestContext.assignToTester();
        changeRequestContext.assignToDev();
        changeRequestContext.markTested();
        changeRequestContext.assignToTester();
        changeRequestContext.assignToDev();
        changeRequestContext.assignToTester();
        changeRequestContext.markTested();
    }
}
