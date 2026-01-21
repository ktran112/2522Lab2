package ca.bcit.comp2522.lab2;

import java.util.Date;

public class Elf extends Creature
{
    private int mana;

    private static final int MIN_MANA = 0;
    private static final int MAX_MANA = 50;

    public Elf(final String name,
               final Date dateOfBirth,
               final int health,
               final int mana)
    {
        super(name, dateOfBirth, health);

        validateMana(mana);

        this.mana = mana;
    }

    @Override
    public String getDetails()
    {
        return super.getDetails() + "\nMana: " + mana;
    }

    private static void validateMana(final int mana)
    {
        if (mana < MIN_MANA || mana > MAX_MANA)
        {
            throw new IllegalArgumentException("Mana has to range from 0-100");
        }
    }
}
