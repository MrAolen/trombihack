package com.ekino.trombihack.bot;

import com.ekino.trombihack.model.Field;
import com.ekino.trombihack.service.RuleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.ramswaroop.jbot.core.slack.models.Attachment;
import me.ramswaroop.jbot.core.slack.models.RichMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SlashCommandController {

    private static final Logger logger = LoggerFactory.getLogger(SlashCommandController.class);

    @Value("${slashCommandToken}")
    private String slackToken;
    @Autowired
    private RuleService ruleService;

    @RequestMapping(value = "/trombibot",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public RichMessage onReceiveSlashCommand(@RequestParam("token") String token,
                                             @RequestParam("team_id") String teamId,
                                             @RequestParam("team_domain") String teamDomain,
                                             @RequestParam("channel_id") String channelId,
                                             @RequestParam("channel_name") String channelName,
                                             @RequestParam("user_id") String userId,
                                             @RequestParam("user_name") String userName,
                                             @RequestParam("command") String command,
                                             @RequestParam("text") String text,
                                             @RequestParam("response_url") String responseUrl) {
        // validate token
        if (!token.equals(slackToken)) {
            return new RichMessage("Sorry! You're not lucky enough to use our slack command.");
        }

        //List<User> user = ruleService.proceedCommand(text);

        RichMessage richMessage = new RichMessage("Résultat de la recherche");
        richMessage.setResponseType("in_channel");
        // set attachments
        Attachment[] attachments = new Attachment[1];

        Attachment attachment = new Attachment();
        Field nameField = new Field();
        nameField.setTitle("Nom");
        nameField.setValue("Gunther");
        nameField.setShortEnough(true);

        Field fornameField = new Field();
        fornameField.setTitle("Prénom");
        fornameField.setValue("Nicolas");
        fornameField.setShortEnough(true);

        Field telField = new Field();
        telField.setTitle("Téléphone");
        telField.setValue("06.99.41.91.69");
        telField.setShortEnough(true);

        Field emailField = new Field();
        emailField.setTitle("Email");
        emailField.setValue("nicolas.gunther@ekino.com");
        emailField.setShortEnough(true);


        Field[] fields = new Field[4];
        fields[0] = nameField;
        fields[1] = fornameField;
        fields[2] = telField;
        fields[3] = emailField;

        attachment.setFields(fields);
        attachment.setText("This is the user");
        attachment.setColor("good");
        attachment.setImageUrl("https://image.noelshack.com/fichiers/2018/10/2/1520328766-familyguy-4.png");
        attachment.setTitle("We found a user for you !");
        attachments[0] = attachment;

        richMessage.setAttachments(attachments);

        // For debugging purpose only
        if (logger.isDebugEnabled()) {
            try {
                logger.debug("Reply (RichMessage): {}", new ObjectMapper().writeValueAsString(richMessage));
            } catch (JsonProcessingException e) {
                logger.debug("Error parsing RichMessage: ", e);
            }
        }

        return richMessage.encodedMessage();
    }
}
