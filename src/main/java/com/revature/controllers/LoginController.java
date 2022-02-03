package com.revature.controllers;

import com.revature.models.User;
import com.revature.services.LoginService;
import com.revature.services.UserService;
import io.javalin.Javalin;
import io.javalin.http.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginController implements Controller{
    private UserService userService = new UserService();
    private LoginService loginService = new LoginService();
    private static final Logger log = LoggerFactory.getLogger(LoginService.class);

    private Handler login = (ctx) -> {
        User user = ctx.bodyAsClass(User.class);

        if(loginService.login(user.getUserName(), user.getPassword())) {
            log.info("Login Success");
            ctx.req.getSession();
            ctx.status(200);
        }else {
            log.info("Login Failed");
            ctx.req.getSession().invalidate();
            ctx.status(401);
        }

    };

    private Handler logout = (ctx) -> {
        if(ctx.req.getSession(false) != null) {
            ctx.req.getSession().invalidate();
            ctx.status(200);
        }else {
            ctx.status(401);
        }
    };

    @Override
    public void addRoutes(Javalin app) {
        app.post("/login", this.login);
        app.post("/logout", this.logout);

    }
}
