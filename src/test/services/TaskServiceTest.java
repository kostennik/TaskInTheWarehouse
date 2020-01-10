package services;

import models.Task;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {
    private static final String username = "Andrey";
    private static final String description = "test description";
    private static final Boolean priority = true;
    private static final int quantity = 1;
    private static TaskService taskService = new TaskService();

    @BeforeEach
    void setUp() {
        Task task = new Task(username, description, priority, quantity, new Date());
        taskService.addTask(task);
    }

    @Test
    void findTask() {
        Task task = taskService.findTask(1);

        assertAll(
                () -> assertEquals(task.getUserName(), username),
                () -> assertEquals(task.getDescriptionTask(), description),
                () -> assertEquals(task.getPriority(), priority),
                () -> assertEquals(task.getQuantity(), quantity)
        );
    }

    @Test
    void deleteTask() {
        int taskId = 3;

        taskService.deleteTask(taskId);
        Task task = taskService.findTask(taskId);

        assertNull(task);
    }

    @Test
    void updateTask() {
        int id = 1;
        Task oldTask = taskService.findTask(id);

        Task task = new Task("New user", "new description", false, 100, new Date());
        taskService.updateTask(task, id);


        assertNotEquals(task, oldTask);
    }

    @Test
    void findAllTasks() {
        List<Task> tasks = taskService.findAllTasks();
        System.out.println(tasks);
        assertNotNull(tasks);
    }

    @Test
    void addTask() {
        Task task = new Task(username, description, priority, quantity, new Date());
        int id = taskService.addTask(task);
        Task taskSaved = taskService.findTask(id);

        assertEquals(task, taskSaved);
    }
}