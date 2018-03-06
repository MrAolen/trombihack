package com.ekino.trombihack.userService;

import com.ekino.trombihack.user.User;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserService {
    private static User[] allUser;
    public static void run() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            User[] obj = mapper.readValue(new File("/Users/ruben.desert/Documents/workspace/trombihack/src/main/resources/data.json"), User[].class);

            System.out.println(obj.length);
            setAllUser(obj);

        } catch (JsonGenerationException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<User> searchByUsername(String name) {
        User[] users = getAllUser();
        return  Arrays.asList(users).stream().filter(e -> e.getFirstName().equals(name)).collect(Collectors.toList());
    }

    private static void setAllUser(User[] Users) {
        allUser = Users;
    }

    private static User[] getAllUser()  {
        return allUser;
    }
}
