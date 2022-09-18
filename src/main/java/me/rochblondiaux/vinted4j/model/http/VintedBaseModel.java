package me.rochblondiaux.vinted4j.model.http;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class VintedBaseModel {

    @JsonAnySetter
    private final Map<String, Object> extra_properties = new HashMap<>();


    @JsonAnyGetter
    public Map<String, Object> getExtraProperties() {
        return this.extra_properties;
    }

    @JsonIgnore
    public Object get(String key) {
        return extra_properties.get(key);
    }

    @SuppressWarnings("unchecked")
    public <T extends VintedBaseModel> T put(String key, Object val) {
        this.extra_properties.put(key, val);
        return (T) this;
    }
}
