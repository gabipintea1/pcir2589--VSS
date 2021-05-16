package mockito_tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import tasks.Repository.ArrayTaskList;
import tasks.model.Task;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;

    public class ArrayTaskListTest {


    private ArrayTaskList arrayTaskList;
    private Task task;

    @BeforeEach
    public void setUp(){
        task= Mockito.mock(Task.class);
        arrayTaskList=new ArrayTaskList();
        when(task.getTitle()).thenReturn("tests");
        when(task.getStartTime()).thenReturn(new Date(1999,1,1));
        when(task.getEndTime()).thenReturn(new Date(2020,2,2));
       // when(task.equals(null)).thenThrow(new NullPointerException("Task shouldn't be null"));
    }

    @Test
    public void testAdd(){
        arrayTaskList.add(task);
        Task addedTask=arrayTaskList.getAll().get(0);
        assertSame(task,addedTask);
        assertEquals(addedTask.getEndTime(),task.getEndTime());
        assertEquals(addedTask.getTitle(),task.getTitle());
        assertEquals(arrayTaskList.size(),1);
    }

    @Test
    public void testRemove(){

        arrayTaskList.add(task);
        assertEquals(arrayTaskList.size(),1);
        arrayTaskList.remove(task);
        assertEquals(arrayTaskList.size(),0);
    }
}
