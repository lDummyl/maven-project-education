package bonus;


public class Generic {

    public static void main(String[] args) {
        Supplier supplier = new Supplier();
        Consumer consumer = new Consumer();

        Container product = supplier.produceGoods();
        // a тут какой-то  *<):o) решил пошутить
        product.setPayload("shit");

        consumer.concume(product);
    }
}

class Supplier {


    Container produceInt() {
        return new Container(1);
    }

    Container produceDouble() {
        return new Container(1.5);
    }

    Container produceGoods() {
        return new Container(new Goods());
    }

}


class Consumer  {

    public void concume(Container product) {
        Object productPayload = product.getPayload();
        if (productPayload instanceof Goods) {
            Goods payload = (Goods) product.getPayload();
            System.out.println("Consumer happy! With his " + payload);
        } else {
            System.out.println("Consumer sad! He got " + product.getPayload() + " instead of goods");
        }
    }

//    public void concume(Container<Goods> product) {
//        Goods payload = product.getPayload();
//        System.out.println("Consumer happy! With his " + payload);
//    }

//    public void concume(Container<T> product) {
//        T payload = product.getPayload();
//        System.out.println("Consumer happy! With his " + payload);
//    }

}


//class Container<T> {
//
//    private T payload;
//
//    public Container(T payload) {
//        this.payload = payload;
//    }
//
//    public T getPayload() {
//        return payload;
//    }
//
//    public void setPayload(T payload) {
//        this.payload = payload;
//    }
//}

class Container {

    private Object payload;

    public Container(Object payload) {
        this.payload = payload;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }
}

class Goods {

}