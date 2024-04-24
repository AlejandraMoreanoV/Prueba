package com.example.demo;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class PrimerPruebaTest {

    @Test
    void miPrimerTest() {
        assertThat(3).isEqualTo(42);
    }

    @Test
    void miSegundoTest() {
        assertThat(42).isEqualTo(42);
    }

}