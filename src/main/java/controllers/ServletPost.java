package controllers;

import models.Task;
import services.TaskService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/api/addTasks")
public class ServletPost extends HttpServlet {
    private TaskService taskService = new TaskService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String username = req.getParameter("username");
        String descriptionTask = req.getParameter("description_task");
        boolean priority = Boolean.parseBoolean(req.getParameter("priority"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));

        Task task = new Task(username, descriptionTask, priority, quantity, new Date());
        taskService.addTask(task);
        PrintWriter out = res.getWriter();
        res.setContentType("text/html");
        out.print("200"); //send status
        out.flush();
    }
}
