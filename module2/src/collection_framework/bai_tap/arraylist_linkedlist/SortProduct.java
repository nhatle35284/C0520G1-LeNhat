package collection_framework.bai_tap.arraylist_linkedlist;

import java.util.Comparator;

public class SortProduct implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getId()-o2.getId();
//        if (o1.getId()>o2.getId()) {return 1}
//        else if (o1.getId()<o2.getId()) {return -1}
//        else return 0;
    }
}
