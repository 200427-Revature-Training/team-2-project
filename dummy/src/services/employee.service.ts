import * as employeeDao from '../daos/employee.dao';
import { Tickets } from '../models/Tickets';
import { Replies } from '../models/Replies';
import { HistoryPost } from '../models/employees/HistoryPost';

// Get all posts/tickets
export function getAllTicketsPosts(): Promise<Tickets[]> {
    return employeeDao.getAllTicketsPosts();
}

// Get posts/tickets request by id
export function getTicketsPostById(id: number): Promise<Tickets> {
    return employeeDao.getTicketsPostById(id);
}

// Filter tickets by type
export function filterTicketsByType(ticketStatus: number): Promise<Tickets> {
    return employeeDao.filterTicketsByType(ticketStatus);
}

// See all previous posts by user
export function getHistoryPosts(userId: number): Promise<HistoryPost> {
    return employeeDao.getHistoryPosts(userId);
}

// Get replies
export function getReplies(rid: number): Promise<Replies> {
    return employeeDao.getReplies(rid);
}