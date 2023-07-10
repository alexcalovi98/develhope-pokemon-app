import java.sql.*;

public class Exercise2 {

    public static void main(String[] args) {

        try{
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/newdb", "root","gigi98dm");

            Statement statement = connection.createStatement();

            String createTableQuery = "CREATE TABLE IF NOT EXISTS students (" +
                    "student_id INT(10) NOT NULL AUTO_INCREMENT, " +
                    "last_name VARCHAR(30), " +
                    "first_name VARCHAR(30), " +
                    "PRIMARY KEY (student_id)" +
                    ")";
            statement.executeUpdate(createTableQuery);

            String insertDataQuery = "INSERT INTO students (last_name, first_name) VALUES " +
                    "('Smith', 'John'), " +
                    "('Johnson', 'Emma'), " +
                    "('Brown', 'Michael'), " +
                    "('Davis', 'Olivia')";
            statement.executeUpdate(insertDataQuery);

            ResultSet resultSet = statement.executeQuery("SELECT * FROM students");

            while(resultSet.next()) {
                System.out.print(resultSet.getString("last_name") + " " +
                        resultSet.getString("first_name") + "\n");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

