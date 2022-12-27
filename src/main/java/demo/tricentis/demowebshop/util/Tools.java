package demo.tricentis.demowebshop.util;

import java.util.Objects;

public class Tools {
    public String selectGender(String gender){
        if (Objects.equals(gender, "male")){
            return "gender-male";
        }return "gender-female";
    }
}
