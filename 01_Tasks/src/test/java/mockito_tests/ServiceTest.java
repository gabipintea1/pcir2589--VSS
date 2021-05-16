package mockito_tests;

import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.Repository.ArrayTaskList;
import tasks.model.Task;
import tasks.services.TasksService;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceTest {

    private TasksService tasksService;
    private ObservableList<Task> observableList;
    private ArrayTaskList arrayTaskList=new ArrayTaskList();

    @BeforeEach
    public void setUp(){
        Date date=new Date(1990,11,23);
        arrayTaskList.add(new Task("title",date));
        arrayTaskList.add(new Task("aa",date));
        tasksService=new TasksService(arrayTaskList);
    }

    @Test
    public void getObservableList(){

        observableList=tasksService.getObservableList();
        assertEquals(observableList.size(),2);
    }

    @Test
    public void stringToSeconds(){
        int seconds=tasksService.parseFromStringToSeconds("00:01");
        assertEquals(60,seconds);
    }
}
