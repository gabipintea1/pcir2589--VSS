package mockito_tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import tasks.model.Task;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
//    public Task(String title, Date time){
class TaskTest {


    @RepeatedTest(5)
    void ECP1() {
        Date time = new Date();
        time.setTime(-5);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Task("titlu", time);
        });

    }

    @Timeout(1)
    @Test
    void ECP2() {
        Date time = new Date();
        time.setTime(500);
       Task task=new Task("titlu",time);
       assertEquals(task.getTitle(),"titlu");

    }

}
