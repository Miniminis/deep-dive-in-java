package _02_bytecode.jacoco;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoimTest {

    @Test
    void isFullTest() {
        Moim moim = new Moim();
        moim.maxNumOfAttendees = 100;
        moim.numOfEnrollment = 100;

        assertTrue(moim.isFull());
    }
}
