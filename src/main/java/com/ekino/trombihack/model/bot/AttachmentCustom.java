package com.ekino.trombihack.model.bot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import me.ramswaroop.jbot.core.slack.models.Attachment;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class AttachmentCustom extends Attachment {
    private ActionCustom[] actions;

    public ActionCustom[] getActions() {
        return actions;
    }

    public void setActions(ActionCustom[] actions) {
        this.actions = actions;
    }
}
