package org.springframework.samples.petclinic.sfg;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Primary // Spring will configure this implemantation prioritly
@Component
public class LaurelWordProducer implements WordProducer {
    @Override
    public String getWord() {
        return "Laurel";
    }
}
