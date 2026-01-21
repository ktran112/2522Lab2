package ca.bcit.comp2522.lab2;

import java.util.Date;

public class Dragon extends Creature
{
    private int firePower;

    private static final int MIN_FIRE_POWER = 0;
    private static final int MAX_FIRE_POWER = 100;

    private static final int FIRE_POWER_DECREMENT = 10;
    private static final int FIRE_POWER_EXCEPTION_CONSTANT = 10;

    public Dragon(final String name,
                  final Date dateOfBirth,
                  final int health,
                  final int firePower)
    {
        super(name, dateOfBirth, health);

        validateFirePower(firePower);

        this.firePower = firePower;
    }

    @Override
    public String getDetails()
    {
        return super.getDetails() +
                "\nFire Power: " +
                firePower;
    }

    public void breatheFire()
        throws LowFirePowerException
    {
        if (firePower < FIRE_POWER_EXCEPTION_CONSTANT)
        {
            throw new LowFirePowerException("Not enough fire power");
        }

        firePower -= FIRE_POWER_DECREMENT;
    }

    public void restoreFirePower(final int amount)
    {
        firePower = firePower + amount;

        if (firePower > MAX_FIRE_POWER){
            firePower = MAX_FIRE_POWER;
        }
    }

    private static void validateFirePower(final int firePower)
    {
        if (firePower > MAX_FIRE_POWER || firePower < MIN_FIRE_POWER)
        {
            throw new IllegalArgumentException("Fire Power cannot be less than 0, or exceed 100.");
        }
    }
}
