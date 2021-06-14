
package com.example.m8_hibernate_homework.zad1;

import java.util.HashMap;
import java.util.List;
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
    "product",
    "init",
    "dataseries"
})
@Generated("jsonschema2pojo")
public class Example {

    @JsonProperty("product")
    private String product;
    @JsonProperty("init")
    private String init;
    @JsonProperty("dataseries")
    private List<Dataseries> dataseries = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("product")
    public String getProduct() {
        return product;
    }

    @JsonProperty("product")
    public void setProduct(String product) {
        this.product = product;
    }

    @JsonProperty("init")
    public String getInit() {
        return init;
    }

    @JsonProperty("init")
    public void setInit(String init) {
        this.init = init;
    }

    @JsonProperty("dataseries")
    public List<Dataseries> getDataseries() {
        return dataseries;
    }

    @JsonProperty("dataseries")
    public void setDataseries(List<Dataseries> dataseries) {
        this.dataseries = dataseries;
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
        return new StringJoiner(", ", Example.class.getSimpleName() + "[", "]")
                .add("product='" + product + "'")
                .add("init='" + init + "'")
                .add("dataseries=" + dataseries)
                .add("additionalProperties=" + additionalProperties)
                .toString();
    }
}
