package me.rochblondiaux.vinted4j.model.device;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

@Data
public class MobileDevice implements Serializable {

    private final String userAgent;
    private final String capabilities;
    private final Map<String, Object> deviceMap;

}