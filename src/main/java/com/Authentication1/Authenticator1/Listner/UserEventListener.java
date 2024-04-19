package com.Authentication1.Authenticator1.Listner;

import com.Authentication1.Authenticator1.model.User;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertCallback;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveCallback;
import org.springframework.stereotype.Component;
import java.util.Date;
import org.bson.Document;

@Component
public class UserEventListener implements BeforeConvertCallback<User>, BeforeSaveCallback<User> {

    @Override
    public User onBeforeConvert(User user, String collection) {
        if (user.getLastLoggedIn() == null) {
            user.setLastLoggedIn(new Date()); // Set this only initially if needed
        }
        user.setLastUpdated(new Date()); // Always update lastUpdated before saving
        return user;
    }

    @Override
    public User onBeforeSave(User user, Document document, String collection) {
        document.put("lastUpdated", new Date()); // Directly manipulate the document if necessary
        return user;
    }
}
