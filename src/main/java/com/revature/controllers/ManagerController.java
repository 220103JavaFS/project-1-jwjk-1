package com.revature.controllers;

import com.revature.models.Reimbursement;
import com.revature.services.ReimbursementService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class ManagerController implements Controller {
    private ReimbursementService reimbursementService = new ReimbursementService();
    Handler findAllReimbursement = (ctx) -> {
        if (ctx.req.getSession(false) != null) {
            ctx.json(reimbursementService.findAllReimbursement());
            ctx.status(200);
        } else {
            ctx.status(401);
        }
    };

    Handler findAllRequest = (ctx) -> {
        if (ctx.req.getSession(false) != null) {
            ctx.json(reimbursementService.findAllRequest());
            ctx.status(200);
        } else {
            ctx.status(401);
        }
    };

    Handler updateStatus = (ctx) -> {
        if (ctx.req.getSession(false) != null) {
            Reimbursement reimbUpdate = ctx.bodyAsClass(Reimbursement.class);

            if(reimbursementService.updateStatus(reimbUpdate)){
                ctx.status(202);
            }else {
                ctx.status(400);
            }
        }else {
            ctx.status(401);
        }
    };


    @Override
    public void addRoutes(Javalin app) {
        app.get("/manager/allReimbursement", findAllReimbursement);
        app.get("manager/findAllRequest", findAllRequest);
        app.put("/manager/updateStatus", updateStatus);

    }
}
