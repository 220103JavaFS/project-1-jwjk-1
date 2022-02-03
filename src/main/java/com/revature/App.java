package com.revature;

import com.revature.controllers.Controller;
import com.revature.controllers.EmployeeController;
import com.revature.controllers.LoginController;
import com.revature.controllers.ManagerController;
import io.javalin.Javalin;

public class App {

    private static Javalin app;

    public static void main(String[] args) {

        app = Javalin.create();
        configure(new LoginController(), new EmployeeController(), new ManagerController());
        app.start();
    }
    private static void configure(Controller... controllers) {
            for(Controller c: controllers) {
                c.addRoutes(app);
            }


        }


}
