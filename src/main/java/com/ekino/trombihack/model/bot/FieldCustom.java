package com.ekino.trombihack.model.bot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class FieldCustom extends me.ramswaroop.jbot.core.slack.models.Field {
    @JsonProperty("short")
    private boolean shortEnough;


    @Override
    public boolean isShortEnough() {
        return shortEnough;
    }

    @Override
    public void setShortEnough(boolean shortEnough) {
        this.shortEnough = shortEnough;
    }
}
