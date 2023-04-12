import java.util.ArrayList;

public class Wasp implements Contract{
    ArrayList<String> items = new ArrayList<String>();
    ArrayList<String> actions = new ArrayList<String>();
    int size = 1;
    
    public void grab(String item){
        items.add(item);
    }

    public String drop(String item){
        items.remove(item);
        String dropped = ("You are no longer carrying " + item);
        return dropped;
    }

    public void examine(String item){
        System.out.println("This is a/an " + item);
    }

    public void use(String item){
        System.out.println("You just threw your " + item + "!");
        items.remove(item);
        System.out.println("You are no longer carrying " + item);
    }

    public boolean walk(String direction){
        if (direction == "down"){
            System.out.println("Sorry, you can't walk down.");
            return false;
        }else{
            return true;
        }
    }
    
    public boolean fly(int x, int y){
        return true;
    }

    public Number shrink(){
        Number newSize = size - 1;
        System.out.println("You're smaller now! Your size is " + newSize + ".");
        actions.add("shrink");
        return newSize;
    }
    
    public Number grow(){
        Number newSize = size + 1;
        System.out.println("You're bigger now! Your size is " + newSize + ".");
        actions.add("grow");
        return newSize;
    }

    public void rest(){
        System.out.println("You lie down to rest for a while, but are now vulnerable.");
    }

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
