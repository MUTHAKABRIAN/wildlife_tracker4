package models;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import static org.junit.Assert.*;

public class AnimalsTest {


    @Test
    public void Animals_instantiatesName_of_the_animal_true_String() {
        Animals testAnimals = new Animals("Rhino");
        assertEquals("Rhino", testAnimals.getAnimalName());
    }


//    @Test
//    public void save_successfully_List() {
//        Animals testAnimals = new Animals("Lion");;
//        testAnimals.save();
//        assertTrue(Endangered.getAllEndangered().get(0).equals(testAnimals));
//    }



}