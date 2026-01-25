package ca.bcit.comp2522.lab2;

import java.util.Date;

/**
 * Represents a dragon.
 * <p>
 *     Defines a unique attribute "Fire Power" that can be consumed and restored.
 * </p>
 *
 * @author Devan Lam
 * @author Kiet Tran
 * @version 1.0
 */
public class Dragon extends Creature
{
    private int firePower;

    private static final int MIN_FIRE_POWER = 0;
    private static final int MAX_FIRE_POWER = 100;

    private static final int BREATHE_FIRE_DAMAGE = 20;
    private static final int FIRE_POWER_DECREMENT = 10;
    private static final int FIRE_POWER_EXCEPTION_CONSTANT = 10;

    /**
     * Constructs a new Dragon with a name, birthdate, health, and fire power.
     *
     * @param name the name of the dragon
     * @param dateOfBirth the birthdate of the dragon
     * @param health the health of the dragon
     * @param firePower the fire power of the dragon
     */
    public Dragon(final String name,
                  final Date dateOfBirth,
                  final int health,
                  final int firePower)
    {
        super(name, dateOfBirth, health);

        validateFirePower(firePower);

        this.firePower = firePower;
    }

    /**
     * A string containing all the dragon's details.
     *
     * @return the name, birthdate, health, and fire power of the dragon
     */
    @Override
    public String getDetails()
    {
        return super.getDetails() +
                "\nFire Power: " +
                firePower;
    }

    /**
     * Performs a fire breath attack on another creature.
     *
     * @param target the specified target that will receive damage
     * @throws LowFirePowerException if the current fire power is below the required threshold
     */
    public void breatheFire(Creature target)
        throws LowFirePowerException
    {
        if (firePower < FIRE_POWER_EXCEPTION_CONSTANT)
        {
            throw new LowFirePowerException("Not enough fire power");
        }

        firePower -= FIRE_POWER_DECREMENT;

        target.takeDamage(BREATHE_FIRE_DAMAGE);
    }

    /**
     * Increases the dragon's fire power by a specified amount.
     *
     * @param amount the amount of fire power to add
     */
    public void restoreFirePower(final int amount)
    {
        firePower = firePower + amount;

        if (firePower > MAX_FIRE_POWER)
        {
            firePower = MAX_FIRE_POWER;
        }

    }

    /*
     * Validates that the provided fire power is within the range [0, 100].
     *
     * @param firePower the value to validate
     * @throws IllegalArgumentException if the value is less than 0 or greater than 100
     */
    private static void validateFirePower(final int firePower)
    {
        if (firePower > MAX_FIRE_POWER || firePower < MIN_FIRE_POWER)
        {
            throw new IllegalArgumentException("Fire Power cannot be less than 0, or exceed 100.");
        }
    }
}
