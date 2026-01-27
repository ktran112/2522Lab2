package ca.bcit.comp2522.lab2;

import java.util.Date;

/**
 * Represents an Elf.
 * <p>
 *     Defines a unique attribute "Mana" that can be consumed and restored.
 * </p>
 *
 * @author Devan Lam
 * @author Kiet Tran
 * @version 1.0
 */
public class Elf extends Creature
{
    private int mana;

    private static final int MANA_EXCEPTION_CONSTANT = 5;
    private static final int MANA_DECREMENT = 5;
    private static final int CAST_SPELL_DAMAGE = 10;

    private static final int MIN_MANA = 0;
    private static final int MAX_MANA = 50;

    /**
     * Constructs an Elf with a specified name, birthdate, health, and mana.
     *
     * @param name the name of the elf.
     * @param dateOfBirth the birthdate of the elf
     * @param health the health of the elf
     * @param mana the mana of the elf
     */
    public Elf(final String name,
               final Date dateOfBirth,
               final int health,
               final int mana)
    {
        super(name, dateOfBirth, health);

        validateMana(mana);

        this.mana = mana;
    }

    /**
     * A string containing all the elf's details.
        *
        * @return the name, birthdate, health, and mana of the elf
     */
    @Override
    public String getDetails()
    {
        return super.getDetails() + "\nMana: " + mana;
    }

    /**
     * Casts a magical spell on a target creature.
     *
     * @param target the specified creature that will receive the spell damage
     * @throws LowManaException if the current mana is below the required threshold
     */
    public void castSpell(Creature target)
            throws LowManaException
    {
        if (mana < MANA_EXCEPTION_CONSTANT)
        {
            throw new LowManaException("Not enough Mana!");
        }

        mana = mana - MANA_DECREMENT;

        target.takeDamage(CAST_SPELL_DAMAGE);
    }

    /**
     * Restores the elf's mana by a specified amount.
     *
     * @param amount the amount of mana that is restored
     */
    public void restoreMana(int amount)
    {
        mana = mana + amount;

        if (mana > MAX_MANA)
        {
            mana = MAX_MANA;
        }
    }

    /*
     * Validates that the provided mana is within the range [0, 50].
     *
     * @param mana the value to validate
     * @throws IllegalArgumentException if the value is less than 0 or greater than 50
     */
    private static void validateMana(final int mana)
    {
        if (mana < MIN_MANA || mana > MAX_MANA)
        {
            throw new IllegalArgumentException("Mana has to range from 0-50");
        }
    }
}
