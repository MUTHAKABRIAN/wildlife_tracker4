package models;
import org.sql2o.*;

public class DB {
  public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", "moringa", "Access");

    //
//    static String connectionString = "jdbc:postgresql://ec2-18-233-207-22.compute-1.amazonaws.com:5432/d8qv515onsd2fo";
//    public static Sql2o sql2o = new Sql2o(connectionString, "zjqvyhmbohpuon", "b5246bac06aa5be203cc89997ae73dc8d930250dc8bef68089307ca36eac7b8b");
}
