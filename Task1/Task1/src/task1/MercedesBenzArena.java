package task1;

public class MercedesBenzArena {
    static int totalMatchDisputed = 0;
    int vfbStuttgartHomeGoals = 0;

     void createTicketsNewMatch() {
        totalMatchDisputed += 1; // error/warning
        MercedesBenzArena.totalMatchDisputed += 1; // valid
    }

    void stuttgartScore () {
        this.vfbStuttgartHomeGoals += 1; // valid
        MercedesBenzArena.vfbStuttgartHomeGoals += 1; // error
    }
    static int value(int valueOfValue){
        return valueOfValue;
    }

public static void main(String[] args){
    // Somewhere else in the code , e.g. , in a main method :
    MercedesBenzArena a = new MercedesBenzArena ();
    MercedesBenzArena b = new MercedesBenzArena ();

         a.stuttgartScore (); // valid
         a.createTicketsNewMatch(); // warning
         MercedesBenzArena.stuttgartScore(); // error
         MercedesBenzArena.createTicketsNewMatch(); // valid

         System.out.println(value(a.totalMatchDisputed )); //Behaviour 1

    System.out.println(value(a.vfbStuttgartHomeGoals )); //Behaviour 1
    System.out.println(value(b.totalMatchDisputed )); //Behaviour 0
    System.out.println( value(b.vfbStuttgartHomeGoals )); //Behaviour 0

         MercedesBenzArena.totalMatchDisputed += 1; //valid 1
         //MercedesBenzArena.vfbStuttgartHomeGoals += 1; //error
         a.totalMatchDisputed += 1; //warning 2 / 3
         a.vfbStuttgartHomeGoals += 1; // valid 2

    System.out.println(value(a.totalMatchDisputed )); //Behaviour 2/3
    System.out.println(value(a.vfbStuttgartHomeGoals )); //Behaviour 2
    System.out.println(value(b.totalMatchDisputed )); //Behaviour 1
    System.out.println(value(b.vfbStuttgartHomeGoals )); //Behaviour 0

         b.totalMatchDisputed += 1; // warning
         b.vfbStuttgartHomeGoals += 1; // valid

    System.out.println(value(a.totalMatchDisputed )); // Behavior 9 2/3
    System.out.println(value(a.vfbStuttgartHomeGoals )); // Behavior 10 2
    System.out.println(value(b.totalMatchDisputed )); // Behavior 11 2
    System.out.println(value(b.vfbStuttgartHomeGoals )); // Behavior 12 1
    }
}