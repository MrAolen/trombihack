package com.ekino.trombihack.bot;

import com.ekino.trombihack.model.User;
import com.ekino.trombihack.model.bot.ActionCustom;
import com.ekino.trombihack.model.bot.AttachmentCustom;
import com.ekino.trombihack.model.bot.FieldCustom;
import com.ekino.trombihack.service.RichMessageBuilder;
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

import java.util.List;


@RestController
public class SlashCommandController {

    private static final Logger logger = LoggerFactory.getLogger(SlashCommandController.class);

    @Value("${slashCommandToken}")
    private String slackToken;
    @Autowired
    private RuleService ruleService;
    @Autowired
    private RichMessageBuilder richMessageBuilder;

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

        List<User> users = ruleService.proceedCommand(text);
        RichMessage richMessage = richMessageBuilder.buildMessage(users);

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
