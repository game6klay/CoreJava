import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by jay on 5/10/16.
 */
public class Item {

    private String value;

    public Item (String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals (Object o){

        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()){
            return false;
        }

        Item item = (Item)o;
        return (value == null ? item.value == null : value.equals(item.value));

    }

    @Override
    public int hashCode(){

        return value != null ? value.hashCode() : 0;
    }

    public static void main (String [] args ){
/*
        Set<Item> set = new HashSet<>(2, 1.0f);
        Item foo = new Item("foo");
        set.add(foo);

        System.out.printf("%s%n", set.contains(foo));
        System.out.printf("%s%n", set.contains(new Item("foo")));

        foo.setValue("foos");

        System.out.printf("%s%n", set.contains(foo));
*/
        int a=-1,b=-1,c=3;
        c += b*= a;
        System.out.println(c);

    }
}
