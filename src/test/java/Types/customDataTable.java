package Types;

import io.cucumber.java.DataTableType;
import objects.BillingDetail;
import objects.Country;

import java.util.Map;

public class customDataTable {

    @DataTableType
    public BillingDetail enterBillingDetail(Map<String,String> entry){
        Country country = Country.fromString(entry.get("country"));
        return new BillingDetail(
                entry.get("firstname"),
                entry.get("lastname"),
                entry.get("address_line1"),
                entry.get("zip"),
                entry.get("email"),
                entry.get("state"),
                entry.get("city"),
                country
        );

    }
}
