package learning.rasw.designpatterns.state.example5;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StatePatternUnitTest {

    @Test
    public void givenNewPackage_whenPackageReceived_thenStateReceived() {
        Package pkg = new Package();

        assertThat(pkg.getState()).isInstanceOf(OrderedState.class);
        pkg.nextState();

        assertThat(pkg.getState()).isInstanceOf(DeliveredState.class);
        pkg.nextState();

        assertThat(pkg.getState()).isInstanceOf(ReceivedState.class);
    }

    @Test
    public void givenDeliveredPackage_whenPrevState_thenStateOrdered() {
        Package pkg = new Package();
        pkg.setState(new DeliveredState());
        pkg.previousState();

        assertThat(pkg.getState()).isInstanceOf(OrderedState.class);
    }
}