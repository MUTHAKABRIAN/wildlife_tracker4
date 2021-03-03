
import models.DB;
import org.junit.rules.ExternalResource;
import org.sql2o.*;

public class DatabaseRule extends ExternalResource {

    @Override
    protected void before() {
       DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/virtual_pets_test", "moringa", "Access");
//        static String connectionString = "jdbc:postgresql://ec2-3-232-163-23.compute-1.amazonaws.com:5432/db7vkhmq0fvd6a";
//public static Sql2o sql2o = new Sql2o(connectionString, "yreolbfpdgvczq", "77dfecc0285a78264ee3b7fc989e41eaac56fe315c626578f8b3d84942b94c2e");

    }

    @Override
    protected void after() {
        try(Connection con = DB.sql2o.open()) {
            String deleteAnimalsQuery = "DELETE FROM animals *;";
            String deleteSightingsQuery = "DELETE FROM sightings *;";
            con.createQuery(deleteAnimalsQuery).executeUpdate();
            con.createQuery(deleteSightingsQuery).executeUpdate();

        }
    }

}
