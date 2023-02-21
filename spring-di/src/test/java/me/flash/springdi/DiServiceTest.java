package me.flash.springdi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DiServiceTest {

    @Autowired DiService diService;

    @Test
    void diTest() {
        assertThat(diService).isNotNull();
        assertThat(diService.diRepository).isNotNull();
    }
}
