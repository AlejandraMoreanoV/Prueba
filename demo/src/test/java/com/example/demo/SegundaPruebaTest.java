package com.example.demo;

import com.example.demo.modelo.Tarjeta;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

@JsonTest
class SegundaPruebaTest {

    @Autowired
    private JacksonTester<Tarjeta> json;

    @Test
    void segundaPruebaSerializacionTest() throws IOException {
        Tarjeta tarjeta = new Tarjeta(99L, 123.45);
        assertThat(json.write(tarjeta)).isStrictlyEqualToJson("/expected.json");
        assertThat(json.write(tarjeta)).hasJsonPathNumberValue("@.id");
        assertThat(json.write(tarjeta)).extractingJsonPathNumberValue("@.id")
                .isEqualTo(99);
        assertThat(json.write(tarjeta)).hasJsonPathNumberValue("@.cantidad");
        assertThat(json.write(tarjeta)).extractingJsonPathNumberValue("@.cantidad")
                .isEqualTo(123.45);
    }

    /*
    @Test
    void segundaPruebaDeserializacionTest() throws IOException {
        String expected = """
           {
               "id":1000L,
               "cantidad":67.89
           }
           """;
        assertThat(json.parse(expected))
                .isEqualTo(new Tarjeta(1000L, 67.89));
        assertThat(json.parseObject(expected).getId()).isEqualTo(1000L);
        assertThat(json.parseObject(expected).getCantidad()).isEqualTo(67.89);
    }
    */
}