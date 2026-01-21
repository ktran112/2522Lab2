package ca.bcit.comp2522.lab2;

import java.util.Date;

public class Orc extends Creature
{
    private int rage;

    private static final int RAGE_INCREMENT = 5;
    private static final int RAGE_THRESHOLD = 20;
    private static final int DOUBLE_DAMAGE = 2;

    public Orc(final String name,
               final Date dateOfBirt,
               final int health,
               final int rage)
    {

    }

    public void berserk()
    {
        rage = rage + RAGE_INCREMENT;

        if (rage > RAGE_THRESHOLD)
        {
            //wrong logic but conceptually this is what is needed
            damage = damage * DOUBLE_DAMAGE;
        }
    }
}
