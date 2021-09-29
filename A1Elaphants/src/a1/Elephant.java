package a1;

/** NetId: wz282. Time spent: 00 hours 59 minutes <br>
 * What I thought about this assignment: A bit simple but nice assignment to really understand how
 * to create a class, its constructors, how objects are created, and practice coding it all out. The
 * hardest part was probably reading the instructions and making sure to follow them correctly.
 *
 * <br>
 * <br>
 * An instance maintains info about an Elephant.
 *
 * @author willzhang */

public class Elephant {

    /** private field variables accessible within this class */
    /** name with length > 0 */
    private String nickname;

    /** be >= 2000 */
    private int yearOfBirth;

    /** range 1 - 12 ; 1 = jan */
    private int monthOfBirth;

    /** F = female M = male */
    private char gender;

    /** store object of Elephant class. null if unknown */
    private Elephant mother;
    private Elephant father;

    /** program updates */
    private int numberOfChildren;

    /** GROUP A: First constructor and getter/setters methods of class Elephant */

    /** constructor method */
    /** Constructor:
     *
     * @param n nickname
     * @param g gender
     * @param y year
     * @param m month Precondition: n has at least 1 character, y >= 2000, m is in 1..12, and g is
     *          'F' for female and 'M' for male. */
    public Elephant(String n, char g, int y, int m) {
        assert n.length() >= 1 && (g == 'M' || g == 'F') && y >= 2000 && m >= 1 && m <= 12;
        nickname= n;
        gender= g;
        yearOfBirth= y;
        monthOfBirth= m;

    }

    /** @return elephant's nickname */
    public String name() {

        return nickname;
    }

    /** @return value of "this elephant is a female" */
    public boolean isFemale() {
        assert this != null;

        return gender == 'F';
    }

    /** @return date of birth of elephant. Form "month/year" with no blanks. e.g. "6/2007" */
    public String date() {

        return monthOfBirth + "/" + yearOfBirth;
    }

    /** @return this elephant's mother (null if unknown) */
    public Elephant mom() {
        return mother;

    }

    /** @return this elephant's father (null if unknown) */
    public Elephant dad() {
        return father;

    }

    /** @return number of children of this elephant */
    public int children() {
        return numberOfChildren;

    }

    /** GROUP B: Getter / mutator methods */

    /** @param e Add e as this elephant's mother. Precondition: elephants mother is unknown and e is
     *          female */
    public void addMom(Elephant e) {
        assert mother == null && e != null && e.isFemale();
        e.numberOfChildren+= 1;
        mother= e;
    }

    /** @param e Add e as this elephant's father. Precondition: This elephant's father is unknown
     *          and e is male. */
    public void addDad(Elephant e) {
        assert father == null && e != null && !e.isFemale();
        e.numberOfChildren+= 1;
        father= e;
    }

    /** GROUP C: Second Constructor. Create an Elephant with new constructor. Requires creating two
     * Elephants using the first constructor and then checking that the new constructor set all 7
     * fields properly. Also the number of children of parameters ma and pa. */

    /** Constructor:
     *
     * @param n  nickname
     * @param g  gender
     * @param y  year
     * @param m  month
     * @param ma mother
     * @param pa father Precondition: n has at least 1 character, y >= 2000, m is in 1..12, and g is
     *           'F' for female and 'M' for male, ma is a female, and pa is a male. */
    public Elephant(String n, char g, int y, int m, Elephant ma, Elephant pa) {
        assert n.length() >= 1 && ma != null && pa != null && !pa.isFemale() && ma.isFemale() &&
            y >= 2000 && m >= 1 &&
            m <= 12 && (g == 'M' ||
                g == 'F');
        nickname= n;
        gender= g;
        yearOfBirth= y;
        monthOfBirth= m;
        father= pa;
        mother= ma;
        pa.numberOfChildren+= 1;
        ma.numberOfChildren+= 1;
    }

    /** GROUP D: two comparison methods to see which of two elephants are older and to see whether
     * two elephant are siblings. Use only boolean expression. */

    /** @param e
     * @return value of "this elephant is older than e" Precondition: e is not null. Smaller y =
     *         older Smaller m = older */
    public boolean isOlder(Elephant e) {
        assert e != null;
        return yearOfBirth < e.yearOfBirth ||
            yearOfBirth == e.yearOfBirth && monthOfBirth < e.monthOfBirth;
    }

    /** @param e
     * @return value of "this elephant and e are sibling." (note: if e is null, they can't be
     *         siblings, so false is returned). */
    public boolean areSibs(Elephant e) {
        return e != null && e != this && mother == e.mother && father == e.father &&
            mother != null &&
            father != null;
    }

}
