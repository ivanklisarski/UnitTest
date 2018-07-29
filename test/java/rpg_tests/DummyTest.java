package rpg_tests;

import org.junit.Assert;
import org.junit.Test;
import rpg_lab.Axe;
import rpg_lab.Dummy;


public class DummyTest {

    @Test
    public void DummyLosesHealthAfterAttack(){
        //Arrange
        Axe axe = new Axe(10,10);
        Dummy dummy = new Dummy(15,10);

        //Act

        axe.attack(dummy);

        //Assert

        Assert.assertEquals(5,dummy.getHealth());

    }

    @Test(expected = IllegalStateException.class)
     public void DeadDummy(){
        //Arrange
         Axe axe = new Axe(10,10);
         Dummy dummy = new Dummy(5,10);

         //Act

         axe.attack(dummy);
         axe.attack(dummy);

     }

     @Test
     public void DeadDummyCanGiveXP(){
         //Arrange
         Axe axe = new Axe(10,10);
         Dummy dummy = new Dummy(5,10);

         //Act

         axe.attack(dummy);

         //Assert
         Assert.assertEquals(10,dummy.giveExperience());


     }

     @Test(expected = IllegalStateException.class)
     public void AliveDummyCantGiveXp(){
         //Arrange
         Axe axe = new Axe(10,10);
         Dummy dummy = new Dummy(25,10);

         //Act

         axe.attack(dummy);
         dummy.giveExperience();
     }



}