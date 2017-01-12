/**
 * Created by jay on 5/10/16.
 */
public class GiftGiver {

    public static void main (String[] args){
        String laptop= "mac";

        Computer computer = new Computer(laptop);
        Gift giftToJohn = new Gift (computer,1500d);
        String sports= "adventure";
        Bicycle bicycle = new Bicycle (sports);
        Gift giftToBob = new Gift (bicycle,2000d);

        Object johnGift = giftToJohn.getValue();
        Computer jonComputer = (Computer) johnGift;

        Object bobGift = giftToBob.getValue();
        Bicycle bobBicycle = (Bicycle) bobGift;

        System.out.println("this is " + johnGift);
        System.out.println("this is " + jonComputer);
        System.out.println("this is " + bobGift);
        System.out.println("this is " + bobBicycle);

    }
}
