package web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.model.User;
import web.service.UserService;
import javax.annotation.PostConstruct;

@Component
public class InitializationUserDB {
        private UserService userService;

        @Autowired
        public InitializationUserDB(UserService userService) {
            this.userService = userService;
        }

        @PostConstruct
        public void testMethod() {
            userService.setUser(new User("Diana", "Andreeva", "d.Andreeva@internet.ru"));
            userService.setUser(new User("Elizaveta", "Amandosova", "e.Amandosova@internet.ru"));
            userService.setUser(new User("Elina", "Akulova", "e.Akulova@internet.ru"));
        }
}
