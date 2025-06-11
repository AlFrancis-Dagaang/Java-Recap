package com.ExceptionLambdaStreams;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;

public class ConfiguringRoles {

    static List<Roles> configurationRoles (){
        List<Roles> roles = new ArrayList<Roles>();

        Roles admin = new Roles("admin", new ActionsPolicy(true,true,true));
        Roles user = new Roles("user", new ActionsPolicy(true,true,false));
        Roles guest = new Roles("guest", new ActionsPolicy(true,false,false));

        roles.add(admin);
        roles.add(user);
        roles.add(guest);

        return roles;

    }
}
