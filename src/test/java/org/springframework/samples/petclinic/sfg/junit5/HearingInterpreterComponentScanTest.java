package org.springframework.samples.petclinic.sfg.junit5;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.samples.petclinic.sfg.HearingInterpreter;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

// Component should be beaned by spring to use in junit test
@ActiveProfiles("component-scan")
@SpringJUnitConfig(classes= HearingInterpreterComponentScanTest.TestConfig.class)
class HearingInterpreterComponentScanTest {

    @Profile("component-scan")
    @Configuration
    @ComponentScan("org.springframework.samples.petclinic.sfg")
    static class TestConfig {
    }

    @Autowired
    HearingInterpreter hearingInterpreter;

    @Test
    public void whatIHeard() {
        String word = hearingInterpreter.whatIHeard();
        // Laurel will be prioritized by @Priority annotation
        assertEquals("Laurel", word);
    }
}