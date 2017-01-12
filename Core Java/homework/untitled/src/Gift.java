/**
 * Created by jay on 5/10/16.
 */
public class Gift <T>{

    private final T value;
    private final Double cost;

    public Gift(T value, Double cost ){
        this.value= value;
        this.cost= cost;
    }

    public T getValue(){
        return value;
    }

    public Double getCost(){
        return cost;
    }
}
