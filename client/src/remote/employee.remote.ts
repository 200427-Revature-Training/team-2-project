import { internalAxios, authAxios } from './internal-axios';
import { Tickets } from '../models/Tickets';
import { PostForum } from '../models/employee/PostForum';
import { Replies } from '../models/Replies';


// Get all tickets table
export const getAllTickets = async () => {
    const response = await internalAxios.get<Tickets[]>('/employee/tickets');
    return response.data.map(ticket => {
        // ticket.datePosted = new Date(ticket.datePosted); // Replace string birthdate with Date object
        // ticket.dateResolved = new Date(ticket.dateResolved);
        console.log(response);
        return ticket;
    });
}

// May be needed for later, leave for now
// export const getTicketById = async (ticketId: number) => {
    // const response = await internalAxios.get<Tickets[]>(`/employee/tickets/${ticketId}`)
export const getTicketById = async () => {
    const response = await internalAxios.get<Tickets[]>(`/employee/tickets/1`)
    console.log(response);
    return response.data.map(ticket => {
        // ticket.datePosted = new Date(ticket.datePosted); // Replace string birthdate with Date object
        // ticket.dateResolved = new Date(ticket.dateResolved);
        console.log('This is line 25', ticket);
        return ticket;
    });
}

// Get all post history for user logged in
export const getAllHistoryPosts = async () => {
    const response = await internalAxios.get<Tickets[]>(`/employee/history`);
    return response.data.map(posts => {
        // posts.datePosted = new Date(posts.datePosted); // Replace string birthdate with Date object
        // posts.dateResolved = new Date(posts.dateResolved);
        console.log(response);
        return posts;
    }); 
}

// Get all ticket/post replies
export const getRepliesById = async () => {
    const response = await internalAxios.get<Replies[]>('/employee/replies');
    return response.data.map(replies => {
        // replies.timestamp = new Date(replies.timestamp); // Replace string birthdate with Date object
        console.log(response);
        return replies;
    });
}

// Get ticket by category
export const getTicketByPostCategory = async () => {
    const response = await internalAxios.get<Tickets[]>(`/employee/post/0`);
    return response.data.map(categories => {
        // categories.datePosted = new Date(categories.datePosted); // Replace string birthdate with Date object
        // categories.dateResolved = new Date(categories.dateResolved);
        return categories;
    });
}

// Get ticket by category
export const getTicketByPendingCategory = async () => {
    const response = await internalAxios.get<Tickets[]>(`/employee/post/1`);
    return response.data.map(categories => {
        // categories.datePosted = new Date(categories.datePosted); // Replace string birthdate with Date object
        // categories.dateResolved = new Date(categories.dateResolved);
        return categories;
    });
}

// Get ticket by category
export const getTicketByAcceptedCategory = async () => {
    const response = await internalAxios.get<Tickets[]>(`/employee/post/2`);
    return response.data.map(categories => {
        // categories.datePosted = new Date(categories.datePosted); // Replace string birthdate with Date object
        // categories.dateResolved = new Date(categories.dateResolved);
        return categories;
    });
}

// Get ticket by category
export const getTicketByResolvedCategory = async () => {
    const response = await internalAxios.get<Tickets[]>(`/employee/post/3`);
    return response.data.map(categories => {
        // categories.datePosted = new Date(categories.datePosted); // Replace string birthdate with Date object
        // categories.dateResolved = new Date(categories.dateResolved);
        return categories;
    });
}

// Create new post
export const createPost = async (post: PostForum) => {
    console.log(post);
    // let reader = new FileReader();
    // reader.readAsDataURL(post.img);
    const response = await internalAxios.post<PostForum[]>('/employee/post', post);
    return response;
}
