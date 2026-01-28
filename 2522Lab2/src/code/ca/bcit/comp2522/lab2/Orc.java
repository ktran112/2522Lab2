package ca.bcit.comp2522.lab2;


/**
 * Represents an Orc creature with berserk as its ability.
 * @author Kiet Tran
 * @author Devan Lam
 * @version 1.0
 */
public class Orc extends Creature
{
    private int rage;                            // Not final because this data is changing frequently.

    private static final int RAGE_INCREMENT = 5;
    private static final int RAGE_MIN = 0;
    private static final int RAGE_MAX = 30;
    private static final int RAGE_THRESHOLD_VALUE = 20;
    private static final int RAGE_MULTIPLIER = 2;
    private static final int BASE_DMG = 15;

    /**
     * Constructs an Orc using the Creature class as its superclass.
     * @param name Orc's name
     * @param dateOfBirth Orc's date of birth
     * @param health Orc's health
     * @param rage Orc's value of rage
     */
    public Orc(final String name,
               final Date dateOfBirth,
               final int health,
               final int rage)
    {
        super(name, dateOfBirth, health);

        validateRage(rage);

        this.rage = rage;
    }

    // Rage cannot be less than the minimum requirement and more than the maximum threshold
    private final void validateRage(int rage)
    {
        if (rage < RAGE_MIN || rage > RAGE_MAX)
        {
            throw new IllegalArgumentException("Invalid rage value.");
        }
    }


    /**
     * This is the Orc's main attack. Increases rage value, then attacks. If rage is above the threshold, damage is doubled.
     * @param target the creature to be attacked
     * @return Damage output
     * @throws LowRageException if rage is below 5 after entering berserk
     */
    public final void berserk(Creature target)
    throws LowRageException
    {
        this.rage += RAGE_INCREMENT;

        if (this.rage > RAGE_MAX)
        {
            this.rage = RAGE_MAX;
        }


        if (this.rage < RAGE_MIN)
        {
            throw new LowRageException("Too low of rage");
        }


        else


        if (rage > RAGE_THRESHOLD_VALUE)
        {
            target.takeDamage(BASE_DMG * RAGE_MULTIPLIER);
        }


        else


        {
            target.takeDamage(BASE_DMG);
        }
    }


    /**
     * Provides the stats of the Orcs.
     * @return stats of the orc, including its rage value
     */
    @Override
    public final String getDetails()
    {
        return super.getDetails() + "\nRage: " + rage;
    }

}
