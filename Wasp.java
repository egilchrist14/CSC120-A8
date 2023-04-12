import java.util.ArrayList;

/**
 * Creates an instance of the Wasp class
 */
public class Wasp implements Contract{
    ArrayList<String> items = new ArrayList<String>();
    ArrayList<String> actions = new ArrayList<String>();
    int size = 1;
    int energy = 1;
    
    /**
     * "Picks up" at item by adding it to a string array
     * @param item The item being picked up
     */
    public void grab(String item){
        items.add(item);
    }

    /**
     * Drops at item by removing it from a string array
     * @param item The item being dropped
     */
    public String drop(String item){
        items.remove(item);
        String dropped = ("You are no longer carrying " + item);
        return dropped;
    }

    /*
     * Describes an item
     * @param item The item being described
     */
    public void examine(String item){
        System.out.println("This is a/an " + item);
    }

    /*
     * Throws an item and removes it from the array list of items the wasp is carrying and reduces the wasp's energy
     * @param item The item being thrown/used
     */
    public void use(String item){
        System.out.println("You just threw your " + item + "!");
        items.remove(item);
        this.energy = energy - 1;
        System.out.println("You are no longer carrying " + item);
    }

    /*
     * States whether the wasp can walk in a certain direction
     * @param direction The direction in which the wasp wants to walk in
     */
    public boolean walk(String direction){
        if (direction == "down"){
            System.out.println("Sorry, you can't walk down.");
            return false;
        }else{
            return true;
        }
    }
    
    /*
     * States whether the wasp can fly to a specified coordinate
     * @param int x The x-coordinate the wasp wants to fly to
     * @param int y The y-coordinate the wasp wants to fly to
     */
    public boolean fly(int x, int y){
        System.out.println("Since you can fly, you can go pretty much anywhere. Hooray for freedom!");
        return true;
    }

    /*
     * Reduces the wasp's size
     */
    public Number shrink(){
        Number newSize = size - 1;
        System.out.println("You're smaller now! Your size is " + newSize + ".");
        actions.add("shrink");
        return newSize;
    }
    
    /*
     * Increases the wasp's size
     */
    public Number grow(){
        Number newSize = size + 1;
        System.out.println("You're bigger now! Your size is " + newSize + ".");
        actions.add("grow");
        return newSize;
    }

    /*
     * Prints a string which describes the wasp resting and restores some energy
     */
    public void rest(){
        System.out.println("You lie down to rest for a while but are now vulnerable.");
        this.energy = energy + 3;
    }

    /*
     * Undoes the last instance of either shrink() or grow(), depending on which one was called last
     */
    public void undo(){
        if (actions.get(-1) == "grow"){
            actions.remove(-1);
            shrink();
        }else if (actions.get(-1) == "shrink"){
            actions.remove(-1);
            grow();
        }
    }
    
}
