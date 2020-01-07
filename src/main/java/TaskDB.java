import java.sql.*;
import java.util.ArrayList;

public class TaskDB {
    private static String url = "jdbc:mysql://localhost/wozkowy?serverTimezone=GMT%2B8&useSSL=false";
    private static String username = "user";
    private static String password = "password";

    public static ArrayList<Task> select() {

        ArrayList<Task> tasks = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM tasks");
                while (resultSet.next()) {

                    int id = resultSet.getInt(1);
                    String username = resultSet.getString(2);
                    String descriptionTask = resultSet.getString(3);
                    String priority = resultSet.getString(4);
                    int quantity = resultSet.getInt(5);
                    long timeUTC = resultSet.getLong(7);
                    System.out.println(timeUTC);

                    Task task = new Task(id, username, descriptionTask, priority, quantity, timeUTC);
                    tasks.add(task);
                    System.out.println(task);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return tasks;
    }

    public static int insert(Task task) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                String sql = "INSERT INTO tasks (username, description_task, priority, quantity, time) Values (?, ?, ?, ?, ?)";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setString(1, task.getUsername());
                    preparedStatement.setString(2, task.getDescription_task());
                    preparedStatement.setString(3, task.getPriority());
                    preparedStatement.setInt(4, task.getQuantity());
                    preparedStatement.setLong(5, new java.util.Date().getTime()); //set UTC-datetime in DB


                    return preparedStatement.executeUpdate();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return 0;
    }

    public static int delete(int id) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {

                String sql = "DELETE FROM tasks WHERE _id = ?";
                try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
                    preparedStatement.setInt(1, id);

                    return preparedStatement.executeUpdate();
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return 0;
    }
}
