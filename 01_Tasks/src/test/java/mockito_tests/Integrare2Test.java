package mockito_tests;

import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tasks.Repository.ArrayTaskList;
import tasks.model.Task;
import tasks.services.TasksService;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class Integrare2Test {
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
   public void addTaskTest(){
        assertEquals(tasksService.getAll().size(),2);
        Task task=tasksService.getAll().get(0);
        assertEquals(task.getTitle(),"title");

   }

   @Test
    public void deleteTask(){
       assertEquals(tasksService.getAll().size(),2);
       Task task=tasksService.getAll().get(0);
       tasksService.remove(task);
       assertEquals(tasksService.getAll().size(),1);
   }
}
