package designpattern.factorymethod.idcard;

import designpattern.factorymethod.framework.Factory;
import designpattern.factorymethod.framework.Product;

import java.security.acl.Owner;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Guo-hao Zhang
 */
public class IDCardFactory extends Factory {
    private List<String> owners = new ArrayList();

    @Override
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }

    @Override
    protected void registerProduct(Product product) {
        IDCard idCard = (IDCard) product;
        owners.add(idCard.getOwner());
    }
}
