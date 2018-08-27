package domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Request {

    @JsonProperty("city1")
    private String city1;

    @JsonProperty("city2")
    private String city2;

    public String getCity2() {

        return city2;
    }

    public void setCity2(String city2) {

        this.city2 = city2;
    }

    public String getCity1() {

        return city1;
    }

    public void setCity1(String city1) {

        this.city1 = city1;
    }


}
