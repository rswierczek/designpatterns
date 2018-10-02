package learning.rasw.designpatterns.builder;

import org.junit.jupiter.api.Test;

import static learning.rasw.designpatterns.builder.Pizza.Topping.HAM;

class CalzoneTest {

    @Test
    public void testBuilder(){
        Calzone calzone = new Calzone.Builder()
                .addTopping(HAM).sauceInside().build();
    }
}