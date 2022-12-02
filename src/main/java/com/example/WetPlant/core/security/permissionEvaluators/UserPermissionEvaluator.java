package com.example.WetPlant.core.security.permissionEvaluators;

import com.example.WetPlant.domain.user.User;
import org.springframework.stereotype.Component;

@Component
public class UserPermissionEvaluator {

    public UserPermissionEvaluator() {
    }

    public boolean isUserAboveAge(User principal, int age) {
        return true;
    }

}
