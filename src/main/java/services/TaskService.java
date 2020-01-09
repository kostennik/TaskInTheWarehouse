package services;

import dao.Dao;
import dao.TaskDaoImpl;
import models.Task;

import java.util.List;

public class TaskService {
    private Dao<Task> taskDao = new TaskDaoImpl();


    public Task findTask(int id) {
        return taskDao.findById(id);
    }

    public void deleteTask(int taskId) {
        taskDao.delete(taskDao.findById(taskId));
    }

    public void updateTask(Task newTask, int taskId) {
        Task oldTask = taskDao.findById(taskId);

        taskDao.update(newTask, taskId);
    }

    public List<Task> findAllTasks() {
        return taskDao.findAll();
    }

    public int addTask(Task task) {
       int id = taskDao.save(task);
       return id;
    }
}
