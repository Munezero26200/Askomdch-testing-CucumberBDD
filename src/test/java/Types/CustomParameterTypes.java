package Types;

import io.cucumber.java.ParameterType;
import objects.Product;

public class CustomParameterTypes {

    @ParameterType(".*")
    public Product product(String name){
        return new Product(name);
    }


}
