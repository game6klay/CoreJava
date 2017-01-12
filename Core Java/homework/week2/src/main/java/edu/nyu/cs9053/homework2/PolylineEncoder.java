package edu.nyu.cs9053.homework2;

/**
 * User: blangel
 * Date: 8/17/14
 * Time: 9:02 AM
 *
 * Implements the Polyline Algorithm defined here
 * {@literal https://developers.google.com/maps/documentation/utilities/polylinealgorithm}
 */
public class PolylineEncoder {

    public String encodePolyline(Gps[] gpsPoints) {
    	StringBuffer result = new StringBuffer();
        for (int i = 0; i < gpsPoints.length; i++) {
            if(i==0) {
                result.append(encodeWithOperations(gpsPoints[i].getLatitude()));
                result.append(encodeWithOperations(gpsPoints[i].getLongitude()));
            }
            else {
                result.append(encodeWithOperations(gpsPoints[i].getLatitude() - gpsPoints[i-1].getLatitude()));
                result.append(encodeWithOperations(gpsPoints[i].getLongitude() - gpsPoints[i-1].getLongitude()));
            }
        }
        return result.toString();
    }
    
    private int multiplyByE5(double value) {
        return (int)Math.round(value * Math.pow(10, 5));
    }
    
    private int leftShiftOneBit(int value) {
        return value << 1;
    }
    
    private int negate(int value) {
        return value > 0 ? value : ~value;
    }
    
    private String encodeWithOperations(double input) {
        int value = multiplyByE5(input);
        value = leftShiftOneBit(value);
        value = negate(value);
        StringBuffer temp = new StringBuffer();
        while(value >= 0x20){
            int last5Bits = value & 0x1f;
            int or5Bits = last5Bits | 0x20;
            int add63 = or5Bits + 63;
            value >>= 5;
            temp.append((char)(add63));
        }
        value += 63;
        temp.append((char)(value));
        return temp.toString();
    }

}
