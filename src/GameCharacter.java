public class GameCharacter 
{
    private String name;
    private int healthPoint;

    /* Constructors */
    public GameCharacter()
    {
        this("No name yet", 100);
    }

    public GameCharacter(String characterName)
    {
        this(characterName, 100);
    }

    public GameCharacter(String characterName, int initialHp)
    {
        name = characterName;
        healthPoint = initialHp;
    }

    /* Methods */
    public void printStatus()
    {
        System.out.println("Name: " + name);
        System.out.println("Health point: " + healthPoint);
        System.out.println();
    }
}
