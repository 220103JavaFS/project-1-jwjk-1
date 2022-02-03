package com.revature.controllers;

import com.revature.models.Reimbursement;
import com.revature.services.ReimbursementService;
import io.javalin.Javalin;
import io.javalin.http.Handler;

public class EmployeeController implements Controller {
    private ReimbursementService reimbursementService = new ReimbursementService();

    Handler addRequest = (ctx) -> {
        if(ctx.req.getSession(false) != null) {
            Reimbursement request = ctx.bodyAsClass(Reimbursement.class);
            if(reimbursementService.addRequest(request)){
                ctx.status(202);
            }else {
                ctx.status(400);
            }
        }else {
            ctx.status(401);
        }
    };

    Handler viewPastRequests = (ctx) -> {
        if(ctx.req.getSession(false) != null){
            String authorId = ctx.pathParam("authorId");
            int id = Integer.parseInt(authorId);
            ctx.json(reimbursementService.viewPastRequests(id));
            ctx.status(200);
        }else {
            ctx.status(400);
        }
    };

    @Override
    public void addRoutes(Javalin app) {
        app.post("/employee", addRequest);
        app.get("/employee/{authorId}", viewPastRequests);
    }
}
