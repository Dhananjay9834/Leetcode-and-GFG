
import java.util.*;

class ProductOfNumbers {

    ArrayList<Integer> prefix;

    public ProductOfNumbers() {
        prefix = new ArrayList<>();
        prefix.add(1);
    }

    public void add(int num) {

        if (num == 0) {
            prefix = new ArrayList<>();
            prefix.add(1);
        }
        else {
            int lastProduct = prefix.get(prefix.size() - 1);
            prefix.add(lastProduct * num);
        }
    }

    public int getProduct(int k) {

        if (k >= prefix.size()) {
            return 0;
        }

        int lastProduct = prefix.get(prefix.size() - 1);
        int previousProduct = prefix.get(prefix.size() - 1 - k);

        return lastProduct / previousProduct;
    }
}


/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */