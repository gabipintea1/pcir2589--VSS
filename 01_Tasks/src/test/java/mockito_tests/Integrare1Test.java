package mockito_tests;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tasks.Repository.ArrayTaskList;
import tasks.model.Task;
import tasks.services.TasksService;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.when;

public class Integrare1Test {

    private TasksService tasksService;
    private Task task;
    private ArrayTaskList arrayTaskList=new ArrayTaskList();

    @BeforeEach
    public void setUp(){
        task= Mockito.mock(Task.class);
        tasksService=new TasksService(arrayTaskList);
        when(task.getTitle()).thenReturn("tests");
        when(task.getStartTime()).thenReturn(new Date(1999,1,1));
        when(task.getEndTime()).thenReturn(new Date(2020,2,2));
        // when(task.equals(null)).thenThrow(new NullPointerException("Task shouldn't be null"));
    }

    @Test
    public void testAdd(){
        ObservableList<Task> observableList=FXCollections.observableArrayList();
        arrayTaskList.add(task);
        observableList=tasksService.getObservableList();
        Task addedTask=arrayTaskList.getAll().get(0);
        assertEquals(observableList.size(),arrayTaskList.getAll().size());
        assertSame(task,addedTask);
        assertEquals(addedTask.getEndTime(),task.getEndTime());
        assertEquals(addedTask.getTitle(),task.getTitle());
        assertEquals(arrayTaskList.size(),1);
    }

    @Test
    public void deleteTask(){
        arrayTaskList.add(task);
        assertEquals(tasksService.getAll().size(),1);
        tasksService.remove(task);
        assertEquals(tasksService.getAll().size(),0);
    }
}
