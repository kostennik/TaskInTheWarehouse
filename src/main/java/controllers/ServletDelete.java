package controllers;

import services.TaskService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/api/deleteTask")
public class ServletDelete extends HttpServlet {
private TaskService taskService = new TaskService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        System.out.println(req.getParameter("elemToRemove"));
        int id = Integer.parseInt(req.getParameter("elemToRemove"));
        taskService.deleteTask(id);
    }
}
