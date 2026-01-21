package ca.bcit.comp2522.lab2;

import java.util.Date;

public class Creature
{

    private String name;
    private Date dateOfBirth;
    private int health;

    private static final int CURRENT_YEAR = 2026;

    private static final int MIN_HEALTH = 0;
    private static final int MAX_HEALTH = 100;

    private static final int MIN_DAMAGE = 0;
    private static final int MIN_HEALING = 0;

    public Creature(final String name,
                    final Date dateOfBirth,
                    final int health)
    {
        validateName(name);
        validateDateOfBirth(dateOfBirth);
        validateHealth(health);

        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.health = health;
    }

    public boolean isAlive()
    {
        return this.health > MIN_HEALTH;
    }

    public void takeDamage(final int damage)
            throws DamageException
    {
        if (damage < MIN_DAMAGE)
        {
            throw new DamageException("Damage cannot be negative: " + damage);
        }

        if (health < MIN_HEALTH)
        {
            health = 0;
        }

        health = health - damage;
    }

    public int heal(final int healAmount)
            throws HealException
    {
        if (healAmount < MIN_HEALING)
        {
            throw new HealException("Healing cannot be negative: " + healAmount);
        }

        if (health > MAX_HEALTH)
        {
            health = 100;
        }

        return health = health + healAmount;
    }

    public int getAgeYears()
    {
        final int age;

        return age = CURRENT_YEAR - dateOfBirth;
    }

    public String getDetails()
    {
        final StringBuilder details;
        details = new StringBuilder();

        details.append("Creature Name: ").
                append(name).
                append("\n").
                append("Creature birth date: ").
                append(dateOfBirth).
                append("\n").
                append("Creature health: ").
                append(health);

        return details.toString();
    }

    private static void validateName(final String name)
    {
        if (name == null || name.isEmpty())
        {
            throw new IllegalArgumentException("Name is not valid: " + name);
        }
    }

    private static void validateDateOfBirth(final Date dateOfBirth)
    {
        if ()
        {
            throw new IllegalArgumentException("Birth date not valid: " + dateOfBirth);
        }
    }

    private static void validateHealth(final int health)
    {
        if (health < MIN_HEALTH || health > MAX_HEALTH)
        {
            throw new IllegalArgumentException("Health not valid: " + health);
        }
    }
}
