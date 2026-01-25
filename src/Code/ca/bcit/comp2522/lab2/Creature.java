package ca.bcit.comp2522.lab2;

import java.util.Date;

/**
 * Represents the base of all living entities within the program.
 * <p>
 *     Defines attributes such as name, birth date, and health.
 * </p>
 *
 * @author Devan Lam
 * @author Kiet Tran
 * @version 1.0
 */
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

    /**
     * Constructs a new creature with a name, birth date, and initial health.
     *
     * @param name the name of the creature
     * @param dateOfBirth the date when the creature was born
     * @param health the health of the creature
     */
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

    /**
     * Checks if the creature is currently alive.
     *
     * @return true if the health is more than 0, false otherwise.
     */
    public boolean isAlive()
    {
        return this.health > MIN_HEALTH;
    }

    /**
     * Subtracts damage from the creature's current health.
     *
     * @param damage the amount of damage to that the creature takes
     * @throws DamageException if damage is less than 0
     */
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

    /**
     * Increases the creature's health by a specified amount.
     *
     * @param healAmount the amount of health to add
     * @return the new health value after healing
     * @throws HealException if the healAmount is less than 0
     */
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

    /**
     * Calculates the creature's age in years based on the current year.
     *
     * @return the age of the creature
     */
    public int getAgeYears()
    {
        final int age;

        age = CURRENT_YEAR - dateOfBirth.getYear();

        return age;
    }

    /**
     * A string containing all the creature's details.
     *
     * @return the name, birthdate, and health of the creature
     */
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

    /*
     * Validates the creature's name.
     *
     * @param name the name to validate
     * @throws IllegalArgumentException if the name is null or empty
     */
    private static void validateName(final String name)
    {
        if (name == null || name.isEmpty())
        {
            throw new IllegalArgumentException("Name is not valid: " + name);
        }
    }

    /*
     * Validates the creature's date of birth.
     *
     * @param dateofBirth the birthdate to validate
     * @throws IllegalArgumentException if the birthdate is null or after the current year
     */
    private static void validateDateOfBirth(final Date dateOfBirth)
    {
        if (dateOfBirth == null || dateOfBirth.after(new Date()))
        {
            throw new IllegalArgumentException("Birth date not valid: " + dateOfBirth);
        }
    }

    /*
     * Validates the creature's health.
     *
     * @param health the health to validate
     * @throws IllegalArgumentException if the name is less than the minimum, or more than the maximum
     */
    private static void validateHealth(final int health)
    {
        if (health < MIN_HEALTH || health > MAX_HEALTH)
        {
            throw new IllegalArgumentException("Health not valid: " + health);
        }
    }
}
