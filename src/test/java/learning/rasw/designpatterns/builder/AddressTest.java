package learning.rasw.designpatterns.builder;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AddressTest {

    public static final String STREET = "Street";
    public static final String HOUSE_NUMBER = "12";
    public static final String LOCAL_NUMBER = "2";

    @Test
    public void testBuilder(){
        Address address = new Address.Builder()
                .street(STREET)
                .houseNumber(HOUSE_NUMBER)
                .localNumber(LOCAL_NUMBER)
                .build();

        assertThat(address.getStreet()).isEqualTo(STREET);
        assertThat(address.getHouseNumber()).isEqualTo(HOUSE_NUMBER);
        assertThat(address.getLocalNumber()).isEqualTo(LOCAL_NUMBER);

    }
}
