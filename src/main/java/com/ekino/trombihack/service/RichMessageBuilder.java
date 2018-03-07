package com.ekino.trombihack.service;

import com.ekino.trombihack.model.User;
import com.ekino.trombihack.model.bot.ActionCustom;
import com.ekino.trombihack.model.bot.AttachmentCustom;
import com.ekino.trombihack.model.bot.FieldCustom;
import me.ramswaroop.jbot.core.slack.models.Attachment;
import me.ramswaroop.jbot.core.slack.models.RichMessage;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RichMessageBuilder {

    public RichMessage buildMessage(List<User> users) {
        if (users.size() == 1) {
            return buildMessageForOneUser(users.get(0));
        } else if (users.size() == 0) {
            return buildMessageNoUserFound();
        } else if (users.size() > 1) {
            return buildMessageManyUsers(users);
        }
        return new RichMessage();
    }

    private RichMessage buildMessageNoUserFound() {
        RichMessage richMessage = new RichMessage("Résultat de la recherche");
        richMessage.setResponseType("in_channel");
        Attachment[] attachments = new Attachment[1];
        AttachmentCustom attachment = new AttachmentCustom();
        attachment.setColor("#F44336");
        attachment.setText("No user has been found, try another request !");
        attachment.setImageUrl("https://image.noelshack.com/fichiers/2018/10/2/1520328766-familyguy-4.png");
        attachment.setTitle("Error");

        attachments[0] = attachment;

        richMessage.setAttachments(attachments);
        return richMessage;
    }

    private RichMessage buildMessageForOneUser(User user) {
        RichMessage richMessage = new RichMessage("Résultat de la recherche");
        richMessage.setResponseType("in_channel");
        // set attachments
        Attachment[] attachments = new Attachment[1];

        AttachmentCustom attachment = new AttachmentCustom();
        FieldCustom nameField = new FieldCustom();
        nameField.setTitle("Firstname");
        nameField.setValue(user.getFirstName());
        nameField.setShortEnough(true);

        FieldCustom fornameField = new FieldCustom();
        fornameField.setTitle("Lastname");
        fornameField.setValue(user.getLastName());
        fornameField.setShortEnough(true);

        FieldCustom telField = new FieldCustom();
        telField.setTitle("Phone number");
        telField.setValue(user.getPhoneNumber());
        telField.setShortEnough(true);

        FieldCustom emailField = new FieldCustom();
        emailField.setTitle("Email");
        emailField.setValue(user.getEmail());
        emailField.setShortEnough(true);

        FieldCustom[] fields = new FieldCustom[4];
        fields[0] = nameField;
        fields[1] = fornameField;
        fields[2] = telField;
        fields[3] = emailField;

        ActionCustom actionCustom = new ActionCustom();
        actionCustom.setName("Detail");
        actionCustom.setText("Detail");
        actionCustom.setType("button");
        actionCustom.setValue("Detail");

        ActionCustom[] actions = new ActionCustom[1];
        actions[0] = actionCustom;

        attachment.setFields(fields);
        attachment.setActions(actions);
        attachment.setText("This is the user : " + user.getFirstName());
        attachment.setColor("#8BC34A");
        attachment.setImageUrl(user.getPic());
        attachment.setTitle("We found a user for you !");


        attachments[0] = attachment;
        richMessage.setAttachments(attachments);
        return richMessage;
    }

    private RichMessage buildMessageManyUsers(List<User> users) {
        RichMessage richMessage = new RichMessage("Résultat de la recherche");
        richMessage.setResponseType("in_channel");
        // set attachments
        Attachment[] attachments = new Attachment[users.size()];

        for (int i = 0; i < users.size(); i++) {
            AttachmentCustom attachment = new AttachmentCustom();
            FieldCustom nameField = new FieldCustom();
            nameField.setTitle("Firstname");
            nameField.setValue(users.get(i).getFirstName());
            nameField.setShortEnough(true);

            FieldCustom fornameField = new FieldCustom();
            fornameField.setTitle("Lastname");
            fornameField.setValue(users.get(i).getLastName());
            fornameField.setShortEnough(true);

            FieldCustom[] fields = new FieldCustom[2];
            fields[0] = nameField;
            fields[1] = fornameField;

            ActionCustom actionCustom = new ActionCustom();
            actionCustom.setName("Detail");
            actionCustom.setText("Detail");
            actionCustom.setType("button");
            actionCustom.setValue("Detail");

            ActionCustom[] actions = new ActionCustom[1];
            actions[0] = actionCustom;

            attachment.setFields(fields);
            attachment.setActions(actions);
            attachment.setColor("#8BC34A");
            attachments[i] = attachment;
        }


        richMessage.setAttachments(attachments);
        return richMessage;
    }
}
