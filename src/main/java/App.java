import models.Animals;
import models.Endangered;
import models.Sightings;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;


public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

//    Sql2o sql2o = new Sql2o ("jdbc:postgresql://localhost:5432/wildlife_tracker4", "moringa", "Access");
//static String connectionString = "jdbc:postgresql://ec2-3-232-163-23.compute-1.amazonaws.com:5432/db7vkhmq0fvd6a";
//public static Sql2o sql2o = new Sql2o(connectionString, "yreolbfpdgvczq", "77dfecc0285a78264ee3b7fc989e41eaac56fe315c626578f8b3d84942b94c2e");

    public static void main(String[] args) {


        port(getHerokuAssignedPort());
        staticFileLocation("/public");

//        homepage
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

//        animals
        get("/AnimalForm", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "AnimalForm.hbs");
        }, new HandlebarsTemplateEngine());
//
        post("/addAnimal", (request, response) -> {

            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");

            Animals animals = new Animals(name);
            animals.save();
            model.put("animals", animals);
            return new ModelAndView(model, "SuccessAnimal.hbs");
        }, new HandlebarsTemplateEngine());

        get("/Animals", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("Animals", Animals.getAllAnimals());
            return new ModelAndView(model, "Animals.hbs");
        }, new HandlebarsTemplateEngine());


//endangered
        get("/EndangeredForm", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "EndangeredForm.hbs");
        }, new HandlebarsTemplateEngine());


        post("/report", (request, response) -> {

            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            String health = request.queryParams("health");
            String age = request.queryParams("age");
            Endangered endangered = new Endangered(name, health,age);
            endangered.save();
            model.put("endangered", endangered);
            return new ModelAndView(model, "SuccessDanger.hbs");
        }, new HandlebarsTemplateEngine());

        get("/Endangered", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("Endangered", Endangered.getAllEndangered());
            return new ModelAndView(model, "Endangered.hbs");
        }, new HandlebarsTemplateEngine());

//        Sightings
        get("/SightingsForm", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "SightingsForm.hbs");
        }, new HandlebarsTemplateEngine());

        post("/spotted", (request, response) -> {

            Map<String, Object> model = new HashMap<>();
            String location = request.queryParams("location");
            String rangerName = request.queryParams("rangerName");
            String aniName = request.queryParams("aniName");

            Sightings sightings = new Sightings(location,rangerName, aniName);
            sightings.save();
            model.put("sightings", sightings);
            return new ModelAndView(model, "SuccessSight.hbs");
        }, new HandlebarsTemplateEngine());

        get("/Sightings", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("Sightings", Sightings.getAllSightings());
            return new ModelAndView(model, "Sightings.hbs");
        }, new HandlebarsTemplateEngine());


    }


}
