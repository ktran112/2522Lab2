package ca.bcit.comp2522.lab2;

import java.util.Date;


/**
 * Represents an Orc creature with berserk as its ability.
 * @author Kiet Tran
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

        validateRage();

        this.rage = rage;
    }

    // Rage cannot be less than the minimum requirement and more than the maximum threshold
    private final void validateRage()
    {
        if (this.rage < RAGE_MIN || this.rage > RAGE_MAX)
        {
            throw new IllegalArgumentException("Invalid rage value.");
        }
    }


    /**
     * This is the Orc's main attack. Increases rage value, then attacks. If rage is above the threshold, damage is doubled.
     * @return Damage output
     */
    public final int berserk()
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
            return BASE_DMG * RAGE_MULTIPLIER;
        }


        else


        {
            return BASE_DMG;
        }
    }
}
