package controllers;

import com.google.gson.Gson;
import models.Task;
import services.TaskService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/api/getTasks")
public class ServletGet extends HttpServlet {
    private TaskService taskService = new TaskService();
//    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        List<Task> tasks = taskService.findAllTasks();

        Gson gson = new Gson();
        String tasksJsonString = gson.toJson(tasks);
        PrintWriter out = res.getWriter();
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        out.print(tasksJsonString);

        System.out.println("Get:");
        System.out.println(tasks);
        out.flush();
    }
}
