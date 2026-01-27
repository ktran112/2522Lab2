    import ca.bcit.comp2522.lab2.*;



    import java.util.Date;

    public class CreatureTests
    {
        public static void main(String[] args)
        {
            Creature c1;
            Creature c2;
            Creature c3;

            c1 = new Dragon("Bob", new Date(107, 2, 10), 100, 20);
            c2 = new Elf("Dob", new Date(80, 11, 28), 40, 40);
            c3 = new Orc ("Lob", new Date(90, 3, 20), 70, 3);

            System.out.println(c1.getDetails());
            System.out.println(c2.getDetails());
            System.out.println(c3.getDetails());

            if (c1 instanceof Dragon d)
            {
                System.out.println("Is dragon");


                try

                {
                d.breatheFire(c1);
                }

                catch (LowFirePowerException f)
                {
                    System.out.println("Too little firepower :(");
                }
            }

            if (c2 instanceof Elf e)
            {
                System.out.println("Is elf");


                try

                {
                    e.castSpell(c3);
                }

                catch (LowManaException m)
                {
                    System.out.println("Too little mana :(");
                }
            }

            if (c3 instanceof Orc o)
            {
                System.out.println("Is orc");
                try
                {
                    o.berserk(c1);
                }

                catch (LowRageException r)
                {
                    System.out.println("Too little rage :(");
                }
                }

            System.out.println(c1.getDetails());
            System.out.println(c2.getDetails());
            System.out.println(c3.getDetails());

        }




    }