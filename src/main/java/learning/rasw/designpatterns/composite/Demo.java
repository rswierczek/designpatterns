package learning.rasw.designpatterns.composite;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;


interface ValueContainer extends Iterable<Integer> {}

class SingleValue implements ValueContainer {
    public int value;

    // please leave this constructor as-is
    public SingleValue(int value) {
        this.value = value;
    }

    @Override
    public Iterator<Integer> iterator() {
        return Collections.singleton(value).iterator();
    }
}

class ManyValues extends ArrayList<Integer> implements ValueContainer {
}


class MyList extends ArrayList<ValueContainer> {
    // please leave this constructor as-is
    public MyList(Collection<? extends ValueContainer> c) {
        super(c);
    }

    public int sum() {
        int sum = 0;
        for (ValueContainer vc : this) {
            for (int n : vc) {
                sum += n;
            }
        }
        return sum;
    }
}

public class Demo {
    public static void main(String[] args) {


        SingleValue singleValue = new SingleValue(4);
        ManyValues manyValues = new ManyValues();
        manyValues.add(3);
        manyValues.add(4);

        Collection<ValueContainer> group = new ArrayList<>();
        group.add(singleValue);
        group.add(manyValues);

        MyList myList = new MyList(group);
        System.out.println(myList.sum());
    }
}
