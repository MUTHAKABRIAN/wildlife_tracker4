package models;
import org.sql2o.*;

public class DB {
  public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker4", "moringa", "Access");

    //
//    static String connectionString = "jdbc:postgresql://ec2-52-6-178-202.compute-1.amazonaws.com:5432/d7mobpu01clgs1";
//   public static Sql2o sql2o = new Sql2o(connectionString, "lyitixwprpespu", "f4a4dd73e64deb6e75d14f77d31d85fb13c4d7f2314c3c850dd12fc764586604");
}
