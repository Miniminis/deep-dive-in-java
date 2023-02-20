package _02_bytecode.jacoco;

public class Moim {

    int maxNumOfAttendees;

    int numOfEnrollment;

    public boolean isFull() {
        if (maxNumOfAttendees == 0) {
            return false;
        }

        if (numOfEnrollment < maxNumOfAttendees) {
            return false;
        }

        return true;
    }
}
