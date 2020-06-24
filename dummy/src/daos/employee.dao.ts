import { db } from './db';
import { Tickets, TicketsRow } from '../models/Tickets';
import { Replies, RepliesRow } from '../models/Replies';
import { PostForum, PostForumRow } from '../models/employees/PostForum';
import { HistoryPost, HistoryPostRow } from '../models/employees/HistoryPost';

// Get all posts/tickets
export function getAllTicketsPosts(): Promise<Tickets[]> {
    const sql = `select * from all_tickets_and_posts;`;
       return db.query<TicketsRow>(sql, []).then(result => {
           const rows: TicketsRow[] = result.rows;
           const tickets: Tickets[] = rows.map(row => Tickets.from(row));
           return tickets;
       });
}

// Get posts/tickets request by id
export function getTicketsPostById(id: number): Promise<Tickets> {
    const sql = `select * from all_tickets_and_posts where id = $1;`;
    return db.query<TicketsRow>(sql,[id])
    .then(result => result.rows.map(row => Tickets.from(row))[0]);
}

// Filter tickets by type
export function filterTicketsByType(ticketStatus: number): Promise<Tickets> {
    const sql = `select * from all_tickets_and_posts where ticket_status = $1;`;
    return db.query<TicketsRow>(sql,[ticketStatus])
    .then(result => result.rows.map(row => Tickets.from(row))[0]);
}

// See all previous posts by user
export function getHistoryPosts(userId: number): Promise<HistoryPost> {
    const sql = `select title, entry_time, date_resolved, ticket_status from cards where user_id = $1;`;
    return db.query<HistoryPostRow>(sql,[userId])
    .then(result => result.rows.map(row => HistoryPost.from(row))[0]);
}

// Get replies
export function getReplies(rid: number): Promise<Replies> {
    const sql = `select * from replies where rid = $1;`;
    return db.query<RepliesRow>(sql,[rid])
    .then(result => result.rows.map(row => Replies.from(row))[0]);
}

// // Make new Post/Ticket
// export function savePost(post: PostForum): Promise<PostForum> {
//     const sql = `INSERT INTO public.ers_reimbursement (reimb_amount, reimb_submitted, \
//         reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_resolver, \
//         reimb_status_id, reimb_type_id) VALUES ($1, $2, $3, $4, $5, $6, $7, $8, $9) RETURNING *`;
//         return db.query<ReimbursementPostRow>(sql, [
//             reimbursement.reimbAmount,
//             new Date(),
//             null,
//             reimbursement.reimbDescription,
//             reimbursement.reimbReceipt,
//             reimbursement.reimbAuthor,
//             null,
//             1,
//             reimbursement.reimbTypeId
//         ]).then(result => result.rows.map(row => ReimbursementPost.from(row))[0]);
// }

// export function saveReimbursement(reimbursement: ReimbursementPost): Promise<ReimbursementPost> {
//     const sql = `INSERT INTO public.ers_reimbursement (reimb_amount, reimb_submitted, \
//         reimb_resolved, reimb_description, reimb_receipt, reimb_author, reimb_resolver, \
//         reimb_status_id, reimb_type_id) VALUES ($1, $2, $3, $4, $5, $6, $7, $8, $9) RETURNING *`;
//         return db.query<ReimbursementPostRow>(sql, [
//             reimbursement.reimbAmount,
//             new Date(),
//             null,
//             reimbursement.reimbDescription,
//             reimbursement.reimbReceipt,
//             reimbursement.reimbAuthor,
//             null,
//             1,
//             reimbursement.reimbTypeId
//         ]).then(result => result.rows.map(row => ReimbursementPost.from(row))[0]);
// }

