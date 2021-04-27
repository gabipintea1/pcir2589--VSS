package tasks.model;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.*;

import static org.junit.jupiter.api.Assertions.*;

class TasksOperationsTest {
   private static ObservableList<Task> observableList= FXCollections.observableArrayList();
private static TasksOperations task_op=new TasksOperations(observableList);

    ArrayList<Task> tasks=new ArrayList<>();



    @BeforeEach
    void setUp() {
        Date date1=new Date(2021,10,26);
        Date date2=new Date(2022,10,26);
        Task task=new Task("abcd",date1,date2,12);
        task.setActive(true);
        tasks.add(task);

        Date date3=new Date(2021,5,22);
        Date date4=new Date(2021,10,21);
        Task task1=new Task("abcd2",date3,date4,12);
        task1.setActive(true);
        tasks.add(task1);

        task_op.setTasks(tasks);


    }
    @Test
    void incoming_1() {
        Date date1=new Date(2020,10,25);
        Date date2=new Date(2023,11,26);
        ArrayList<Task> incoming = (ArrayList<Task>) task_op.incoming(date1, date2);
       assertEquals(2,incoming.size());

    }

    @Test
    void incoming_2() {
        Date date1=new Date(2020,10,25);
        Date date2=new Date(2023,11,26);
        task_op.setTasks(new ArrayList<>());
        ArrayList<Task> incoming = (ArrayList<Task>) task_op.incoming(date1, date2);
        assertEquals(0,incoming.size());

    }


@Test
    void incoming_3() {
        Date date1=new Date(2021,10,25);
        Date date2=new Date(2021,10,26);
        ArrayList<Task> incoming = (ArrayList<Task>) task_op.incoming(date1, date2);
        assertEquals(1,incoming.size());

    }

    @Test
    void incoming_4() {
        Date date1=new Date(2021,10,24);
            Date date2=new Date(2021,10,25);
        ArrayList<Task> incoming = (ArrayList<Task>) task_op.incoming(date1, date2);
        assertEquals(0,incoming.size());
    }


}