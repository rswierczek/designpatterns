package learning.rasw.designpatterns.builder;

import org.junit.jupiter.api.Test;

import static learning.rasw.designpatterns.builder.NyPizza.Size.SMALL;
import static learning.rasw.designpatterns.builder.Pizza.Topping.ONION;
import static learning.rasw.designpatterns.builder.Pizza.Topping.SAUSAGE;
import static org.assertj.core.api.Assertions.assertThat;

class NyPizzaTest {



    @Test
    public void testBuilder(){
        NyPizza pizza = new NyPizza.Builder(SMALL)
                .addTopping(SAUSAGE)
                .addTopping(ONION)
                .build();


        assertThat(pizza.getSize()).isEqualTo(SMALL);
    }



}