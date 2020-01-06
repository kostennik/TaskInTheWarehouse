import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/api/tasks")
public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        ArrayList<Task> tasks = TaskDB.select();
        Gson gson = new Gson();
        String tasksJsonString = gson.toJson(tasks);
        System.out.println(tasksJsonString);
        PrintWriter out = res.getWriter();
        res.setContentType("application/json");
        res.setCharacterEncoding("UTF-8");
        out.print(tasksJsonString);
        System.out.println(tasksJsonString);
        out.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String username = req.getParameter("username");
        String descriptionTask = req.getParameter("description_task");
        String priority = req.getParameter("priority");
        if (priority == null){
            priority = "no";
        }
        int quantity = Integer.parseInt(req.getParameter("quantity"));


        Task task = new Task(username, descriptionTask, priority, quantity);
        TaskDB.insert(task);
        System.out.println(task.toString());
        PrintWriter out = res.getWriter();
        res.setContentType("text/html");
        out.print("200"); //send status
        out.flush();
    }
}
