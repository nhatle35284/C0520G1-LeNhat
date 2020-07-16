package collection_framework.bai_tap.linkedkist_product;


import java.util.Comparator;
import java.util.List;
public class SortProduct implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return (int) (o1.getPrice()*Math.pow(10,6)-o2.getPrice()*Math.pow(10,6));
//        if (o1.getId()>o2.getId()) {return 1}
//        else if (o1.getId()<o2.getId()) {return -1}
//        else return 0;
    }
}
