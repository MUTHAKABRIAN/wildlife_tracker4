package models;

import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Query;
import org.sql2o.Sql2oException;

import java.util.List;

public class Sightings implements DatabaseManagement{

    private int id;
    private String location;
    private String rangerName;
    private String aniName;

    public Sightings(String location, String rangerName, String aniName) {
        this.id = id;
        this.location = location;
        this.rangerName = rangerName;
        this.aniName = aniName;
//        public Timestamp time_sighted;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAniName() {
        return aniName;
    }

    public int getId() {

        return id;
    }

    public String getLocation() {
        return location;
    }

    public String getRangerName() {
        return rangerName;
    }

    public static List<Sightings> getAllSightings(){
        String sql = "SELECT * FROM sightings;";

        try (Connection con = DB.sql2o.open()){
            Query query =con.createQuery(sql);
            System.out.println(query.executeAndFetch(Sightings.class));
            return query.executeAndFetch(Sightings.class);
        }
    }

    public void save() {
        try (Connection con = DB.sql2o.open()) {
            String sql = "INSERT INTO sightings (location, rangerName, aniName) VALUES (:location, :rangerName, :aniName);";
            this.id = (int) con.createQuery(sql,true)
                    .throwOnMappingFailure(false)
                    .addParameter("location", this.location)
                    .addParameter("rangerName", this.rangerName)
                    .addParameter("aniName", this.aniName)
                    .executeUpdate()
                    .getKey();
            setId(id);
        }catch (Sql2oException ex ){
            System.out.println(ex);
        }
    }
    public void delete() {
        try(Connection con = DB.sql2o.open()) {
            String sql = "DELETE FROM sightings WHERE id = :id;";
            con.createQuery(sql)
                    .addParameter("id", this.id)
                    .executeUpdate();

        }catch (Sql2oException ex ){
            System.out.println(ex);
        }
    }

}

