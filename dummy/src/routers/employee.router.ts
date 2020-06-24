import express from 'express';
import * as employeeService from '../services/employee.service';
import { Tickets } from '../models/Tickets';
import { HistoryPost } from '../models/employees/HistoryPost';
import { Replies } from '../models/Replies';

export const employeeRouter = express.Router();

employeeRouter.get('/posts',  async(request, response, next)=> {
    let tickets: Tickets[];

    try{
        tickets = await employeeService.getAllTicketsPosts();
        response.json(tickets);
    }catch(err){
        console.log(err);
        response.sendStatus(500);
        return;
    }
    next();
});

employeeRouter.get('/posts/:id', async(request, response, next)=> {
    const id = parseInt(request.params.id);
    let tickets: Tickets;

    try {
        tickets = await employeeService.getTicketsPostById(id);
    } catch (err) {
        response.sendStatus(500);
        return;
    }

    if (!tickets) {
        // console.log(tickets)
        response.sendStatus(404);
    } else {
        response.json(tickets);
    }
    next();
 });

employeeRouter.get('/filter/:ticketStatus', async(request, response, next)=> {
    const id = parseInt(request.params.ticketStatus);
    let tickets: Tickets;

    try {
        tickets = await employeeService.filterTicketsByType(id);
    } catch (err) {
        response.sendStatus(500);
        return;
    }

    if (!tickets) {
        // console.log(tickets)
        response.sendStatus(404);
    } else {
        response.json(tickets);
    }
    next();
});

employeeRouter.get('/history/:userId', async(request, response, next)=> {
    const id = parseInt(request.params.userId);
    let posts: HistoryPost;

    try {
        posts = await employeeService.getHistoryPosts(id);
    } catch (err) {
        response.sendStatus(500);
        return;
    }

    if (!posts) {
        // console.log(posts)
        response.sendStatus(404);
    } else {
        response.json(posts);
    }
    next();
});

employeeRouter.get('/replies/:rid', async(request, response, next)=> {
    const id = parseInt(request.params.rid);
    let replies: Replies;

    try {
        replies = await employeeService.getReplies(id);
    } catch (err) {
        console.log(err);
        response.sendStatus(500);
        return;
    }

    if (!replies) {
        // console.log(replies)
        response.sendStatus(404);
    } else {
        response.json(replies);
    }
    next();
});