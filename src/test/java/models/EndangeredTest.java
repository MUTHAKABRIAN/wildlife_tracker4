package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class EndangeredTest {

    @Test
    public void Animals_instantiatesName_of_the_animal_true_String(){
        Endangered testEndangered = new Endangered("Lion", "Okay", "Newborn");
        assertEquals("Lion", testEndangered.getName());
    }


//    @Test
//    public void save_successfully_List() {
//        Endangered testEndangered = new Endangered("Lion", "Okay", "Newborn");;
//        testEndangered.save();
//        assertTrue(Endangered.getAllEndangered().get(0).equals(testEndangered));
//    }



}