package designpattern.factorymethod;

import designpattern.factorymethod.framework.Factory;
import designpattern.factorymethod.framework.Product;
import designpattern.factorymethod.idcard.IDCard;
import designpattern.factorymethod.idcard.IDCardFactory;

/**
 * @author Guo-hao Zhang
 */
public class Main {
    public static void main(String[] args) {
        Factory factory = new IDCardFactory();
        Product card1 = factory.create("小明");
        Product card2 = factory.create("小红");
        Product card3 = factory.create("小刚");
        card1.use();
        card2.use();
        card3.use();
    }
}
