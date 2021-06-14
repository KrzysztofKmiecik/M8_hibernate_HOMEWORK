
package com.example.m8_hibernate_homework.zad1;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "timepoint",
    "cloudcover",
    "lifted_index",
    "prec_type",
    "prec_amount",
    "temp2m",
    "rh2m",
    "wind10m",
    "weather"
})
@Generated("jsonschema2pojo")
public class Dataseries {

    @JsonProperty("timepoint")
    private Integer timepoint;
    @JsonProperty("cloudcover")
    private Integer cloudcover;
    @JsonProperty("lifted_index")
    private Integer liftedIndex;
    @JsonProperty("prec_type")
    private String precType;
    @JsonProperty("prec_amount")
    private Integer precAmount;
    @JsonProperty("temp2m")
    private Integer temp2m;
    @JsonProperty("rh2m")
    private String rh2m;
    @JsonProperty("wind10m")
    private Wind10m wind10m;
    @JsonProperty("weather")
    private String weather;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("timepoint")
    public Integer getTimepoint() {
        return timepoint;
    }

    @JsonProperty("timepoint")
    public void setTimepoint(Integer timepoint) {
        this.timepoint = timepoint;
    }

    @JsonProperty("cloudcover")
    public Integer getCloudcover() {
        return cloudcover;
    }

    @JsonProperty("cloudcover")
    public void setCloudcover(Integer cloudcover) {
        this.cloudcover = cloudcover;
    }

    @JsonProperty("lifted_index")
    public Integer getLiftedIndex() {
        return liftedIndex;
    }

    @JsonProperty("lifted_index")
    public void setLiftedIndex(Integer liftedIndex) {
        this.liftedIndex = liftedIndex;
    }

    @JsonProperty("prec_type")
    public String getPrecType() {
        return precType;
    }

    @JsonProperty("prec_type")
    public void setPrecType(String precType) {
        this.precType = precType;
    }

    @JsonProperty("prec_amount")
    public Integer getPrecAmount() {
        return precAmount;
    }

    @JsonProperty("prec_amount")
    public void setPrecAmount(Integer precAmount) {
        this.precAmount = precAmount;
    }

    @JsonProperty("temp2m")
    public Integer getTemp2m() {
        return temp2m;
    }

    @JsonProperty("temp2m")
    public void setTemp2m(Integer temp2m) {
        this.temp2m = temp2m;
    }

    @JsonProperty("rh2m")
    public String getRh2m() {
        return rh2m;
    }

    @JsonProperty("rh2m")
    public void setRh2m(String rh2m) {
        this.rh2m = rh2m;
    }

    @JsonProperty("wind10m")
    public Wind10m getWind10m() {
        return wind10m;
    }

    @JsonProperty("wind10m")
    public void setWind10m(Wind10m wind10m) {
        this.wind10m = wind10m;
    }

    @JsonProperty("weather")
    public String getWeather() {
        return weather;
    }

    @JsonProperty("weather")
    public void setWeather(String weather) {
        this.weather = weather;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }


    @Override
    public String toString() {
        return new StringJoiner(", ", Dataseries.class.getSimpleName() + "[", "]")
                .add("timepoint=" + timepoint)
                .add("cloudcover=" + cloudcover)
                .add("liftedIndex=" + liftedIndex)
                .add("precType='" + precType + "'")
                .add("precAmount=" + precAmount)
                .add("temp2m=" + temp2m)
                .add("rh2m='" + rh2m + "'")
                .add("wind10m=" + wind10m)
                .add("weather='" + weather + "'")
                .add("additionalProperties=" + additionalProperties)
                .toString();
    }
}
