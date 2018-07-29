package rpg_tests;

import contracts.Target;
import contracts.Weapon;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import rpg_lab.Hero;

public class HeroTestsWithMocking {
    private static final int TARGET_XP = 10;
    private static final String HERO_NAME = "hero";
    private static final int WEAPON_ATTACK = 10;
    private static final int WEAPON_DURABILITY = 10;

    private Target fakeTarget;
    private Weapon fakeWeapon;

    @Before
    public void init() {
        this.fakeTarget = Mockito.mock(Target.class);
        this.fakeWeapon = Mockito.mock(Weapon.class);
    }

        @Test
        public void attackGainsXpIfTargetIsDeath () {
            Mockito.when(this.fakeTarget.isDead()).thenReturn(true);
            Mockito.when(this.fakeTarget.giveExperience()).thenReturn(TARGET_XP);

            Hero hero = new Hero(HERO_NAME, this.fakeWeapon);
            hero.attack(this.fakeTarget);

            Assert.assertEquals("Wrong experience", TARGET_XP, hero.getExperience());
        }
    }

