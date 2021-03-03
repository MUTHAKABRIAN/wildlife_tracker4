package models;
import org.sql2o.Connection;
import org.sql2o.Query;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;
import java.util.List;
import java.util.Objects;

public class Animals implements DatabaseManagement{
    private int id;
    private String name;
    public String type;
    private final String DATABASE_TYPE = "animal";

//    private final Sql2o sql2o;

    public Animals( String name) {
        this.name = name;
        this.setType(DATABASE_TYPE);

//        this.sql2o = sql2o;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {

        return name;
    }

    public static Object all() {
        return all();
    }

    @Override
    public boolean equals (Object otherAnimals){
        if (!(otherAnimals instanceof Animals)){
            return false;
        }else{
            Animals newAnimals = (Animals) otherAnimals;
            return this.getName().equals(newAnimals.getName()) &&
                    this.getId() == newAnimals.getId();
        }
    }


    public static List<Animals> getAllAnimals(){
        String sql = "SELECT * FROM animals where type='animal';";

        try (Connection con = DB.sql2o.open()){
            return   con.createQuery(sql)
                    .throwOnMappingFailure(false)
                    .executeAndFetch(Animals.class);

        }
    }

    public void save() {
        try (Connection con = DB.sql2o.open()){
            String sql = "INSERT INTO animals (name, type) VALUES (:name, :type)";
            this.id = (int) con.createQuery(sql,true)
                    .addParameter("name", this.name)
                    .addParameter("type", this.type)
                    .executeUpdate()
                    .getKey();
            setId(id);
        }
    }



    public void delete(){
        try (Connection con = DB.sql2o.open()){
            String sql = "DELETE FROM animals WHERE id =:id;";
            con.createQuery(sql)
                    .addParameter("id", this.id)
                    .executeUpdate();
        }
    }
}
