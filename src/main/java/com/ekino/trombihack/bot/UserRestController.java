package com.ekino.trombihack.bot;

import com.ekino.trombihack.model.request.NewUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@RestController
public class UserRestController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${slackBotToken}")
    private String slackBotToken;

    @PutMapping("/user")
    public ResponseEntity createUser() {

        NewUserRequest userRequest = new NewUserRequest();
        userRequest.setChannel("C9JKMFE8H");
        userRequest.setText("A new guy is arrived in Ekino !");
        userRequest.setUsername("Trombit bot");
        userRequest.setAttachments("[{" +
                "\"color\": \"#8BC34A\"," +
                "\"title\": \"There is a new guy in Ekino !!!\"," +
                "\"text\": \"And he is awewsome\"," +
                "\"fields\": [" +
                "    {" +
                "        \"title\": \"Firstname :\"," +
                "        \"value\": \"Chuck\"," +
                "        \"short\": true" +
                "    }," +
                "    {" +
                "        \"title\": \"Lastname :\"," +
                "        \"value\": \"Norris\"," +
                "        \"short\": true" +
                "    }," +
                "    {" +
                "        \"title\": \"Phone number :\"," +
                "        \"value\": \"06.66.66.66;66\"," +
                "        \"short\": true" +
                "    }," +
                "    {" +
                "        \"title\": \"Email :\"," +
                "        \"value\": \"chucknorris@chuck.norris\"," +
                "        \"short\": true" +
                "    }" +
                "]," +
                "\"actions\": [" +
                "    {" +
                "        \"name\": \"Detail\"," +
                "        \"text\": \"Detail\"," +
                "        \"type\": \"button\"," +
                "        \"value\": \"Detail\"," +
                "        \"url\": \"https://www.google.fr\"" +
                "    }" +
                "]," +
                "\"image_url\": \"https://s3.amazonaws.com/mf-cnorris/assets/uploads/2016/10/19123509/timeline-05.jpg\"" +
                "}]");
        userRequest.setToken(slackBotToken);


        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("text", userRequest.getText());
        map.add("channel", userRequest.getChannel());
        map.add("token", userRequest.getToken());
        map.add("attachments", userRequest.getAttachments());
        map.add("username", userRequest.getUsername());

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        ResponseEntity<String> response = restTemplate.postForEntity( "https://slack.com/api/chat.postMessage", request , String.class );

        return new ResponseEntity(HttpStatus.OK);
    }
}
