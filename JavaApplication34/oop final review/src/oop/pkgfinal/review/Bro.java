/*
 * Name: James Vanaselja
 * Course: COP3330 - Spring 2015
 * University of Central Florida
 */
package oop.pkgfinal.review;

/**
 *
 * @author James
 */
public class Bro implements Comparable<Bro> {

    private String name;
    private double height;
    private Shades shades;
    private String battleCry;
    
    public Bro(String name, double height, Shades s) {
        //This is a new variable. This.Name that is in the object.
        //name is a string that is inside of the Bro constructor
        this.height = height;
        this.name = name;
       
        shades = s;
        battleCry = BattleCry(s);

    }

    private String BattleCry(Shades s) {
        String re;
        switch (s) {
            case AVIATORS:
                re = "I'll be back";
                break;
            case SHUTTERSHADES:
                re = "I'm a massive douche";
                break;
            case TRANSITIONLENSES:
                re = "What's that say?";
                break;
            case NONE:
                re = "the crust is the best part";
                break;
            default:
                re = "swag";

        }
        return re;

    }

    @Override
    public int compareTo(Bro bruh) {
        if (this.height > bruh.height) {
            return 1;
        }
        if (this.height < bruh.height) {
            return -1;

        } else {
            return 0;
        }
    }
    public long compareCocks(Bro bruh){
        if (this.dick > bruh.dick){
            return 1;
        }
        if (this.dick < bruh.dick){
            return -1;
           
        }
        else{
            return 0;
        }
    }
    public void BroDown(Bro bruh){
        System.out.println(this.battleCry);
        System.out.println(bruh.battleCry);
        int win = this.compareTo(bruh);
        long bigger = this.compareCocks(bruh);
        
        if (win == 1 || bigger == 1){
            System.out.println(bruh.name + "says I do respect ya bruh, " 
                    + this.name);
        }
        if (win == -1 || bigger == -1){
            System.out.println(this.name + "Do you even lift?"
                    + bruh.name);
        }
        
        BroOut();
        
    }
    private static void BroOut()
    {
        //Static methods are not called by an object, only by a class.
        System.out.println("Who ordered fifty cases of natty light?");
        System.out.println("We did! we love lacrosse!");
    }
/*
    //Regular Expressions
    This is the end.
    [A-Z] [a-z]+\\s [a-z]+  \\s [a-z] + \\s [a-z] [.|?|!]
    */
    
    
    
}
