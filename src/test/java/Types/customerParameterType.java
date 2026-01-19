package Types;

import io.cucumber.java.ParameterType;
import objects.Customer;

public class customerParameterType {
    @ParameterType(".+ / .+")
    public Customer enterCredentials(String input){
        String[] parts = input.split(" / ");
        String username = parts[0];
        String password = parts[1];

        return new Customer(username, password);

    }

}
