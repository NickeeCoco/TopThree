import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TopThree {
    public static void main(String[] args) {
        ArrayList<String> items = new ArrayList<String>(
                Arrays.asList("Trusted Care Facial Tissues:CDN$ 8.73", "Trusted Care Facial Tissues:CDN$ 8.73",
                        "10 Pairs of Stainless Steel Chopsticks:CDN$ 17.99", "4K@60Hz HDMI Splitter:CDN$ 32.89",
                        "Toothbrush with Suction Cup:CDN$ 5.99")
        );

        System.out.println(findTopThree(items));
    }

    static ArrayList<String> findTopThree(ArrayList<String> items) {

        ArrayList<Double> pricesList = new ArrayList<Double>(); // create an array list of prices (for sorting)

        for(String item : items) {
            String[] nameAndPrice = item.split(":CDN\\$ "); // split the item into name and price
            Double itemPrice = Double.parseDouble(nameAndPrice[1]);
            pricesList.add(itemPrice); // add the price to the array list
        }

        Collections.sort(pricesList, Collections.reverseOrder()); // sort the prices in decreasing order

        // create an ArrayList to store most sold items
        ArrayList<String> topThree = new ArrayList<>();

        for(int price = 0; price < pricesList.size(); price++) { // loop through the sorted prices
            for (String item : items) { // loop through the original array of items
                if(topThree.size() < 3 && !topThree.contains(item)) { // if topThree has less than 3 items and the current item is not yet in it
                    String currentPrice = pricesList.get(price).toString(); // get the price from the pricesList array
                    if(item.contains(currentPrice)) { // if the current item's name contains the price
                        topThree.add(item); // add it to the top three
                    }
                }
            }
        }

        return topThree;
    }
}
