package tasks.model;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
//    public Task(String title, Date time){
class TaskTest {


    @RepeatedTest(5)
    void ECP1() {
        Date time =new Date();
        time.setTime(-5);
        Assertions.assertThrows(IllegalArgumentException.class,()->{
                new Task("titlu",time);
        });

    }

    @Timeout(1)
    @Test
    void ECP2() {
        Date time =new Date();
        time.setTime(500214);
        Assertions.assertDoesNotThrow(()->{
            new Task("titlu",time);
        });

    }


    @DisplayName("MEGA TEST")
    @Test
    void BVA1() {
        Date time =new Date();
        time.setTime(0);
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            new Task("titlu",time);
        });
    }

    @ParameterizedTest()
    @ValueSource(strings = {""})
    void BVA2(String titlu) {
        Date time =new Date();
        Assertions.assertThrows(IllegalArgumentException.class,()->{
            new Task(titlu,time);
        });


    }

    @Disabled
    @Test
    void disableTest() {
        System.out.println("DISABLEd");
    }
}
