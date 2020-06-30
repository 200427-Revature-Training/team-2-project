import { internalAxios, authAxios } from './internal-axios';
import { Tickets } from '../models/Tickets';
import { PostForum } from '../models/employee/PostForum';
import { Replies } from '../models/Replies';
import { HistoryPost } from '../models/employee/HistoryPost';


// Get all tickets table
export const getAllTickets = async () => {
    const response = await internalAxios.get<Tickets[]>('/employees/all-tickets');
    return response.data.map(ticket => {
        ticket.datePosted = new Date(ticket.datePosted); // Replace string birthdate with Date object
        ticket.dateResolved = new Date(ticket.dateResolved);
        console.log(response);
        return ticket;
    });
}

export const getAllHistoryPosts = async () => {
    const response = await internalAxios.get<HistoryPost[]>('/employees/history');
    return response.data.map(posts => {
        posts.datePosted = new Date(posts.datePosted); // Replace string birthdate with Date object
        posts.dateResolved = new Date(posts.dateResolved);
        console.log(response);
        return posts;
    }); 
}

// Get all ticket/post replies
export const getRepliesById = async () => {
    const response = await internalAxios.get<Replies[]>('/employees/replies');
    return response.data.map(replies => {
        replies.timestamp = new Date(replies.timestamp); // Replace string birthdate with Date object
        console.log(response);
        return replies;
    });
}

// Get ticket by category
export const getTicketByPostCategory = async () => {
    const response = await internalAxios.get<Tickets[]>(`/employees/post/`);
    return response.data.map(categories => {
        categories.datePosted = new Date(categories.datePosted); // Replace string birthdate with Date object
        categories.dateResolved = new Date(categories.dateResolved);
        return categories;
    });
}

// Get ticket by category
export const getTicketByPendingCategory = async () => {
    const response = await internalAxios.get<Tickets[]>(`/employees/pending/`);
    return response.data.map(categories => {
        categories.datePosted = new Date(categories.datePosted); // Replace string birthdate with Date object
        categories.dateResolved = new Date(categories.dateResolved);
        return categories;
    });
}

// Get ticket by category
export const getTicketByAcceptedCategory = async () => {
    const response = await internalAxios.get<Tickets[]>(`/employees/accepted/`);
    return response.data.map(categories => {
        categories.datePosted = new Date(categories.datePosted); // Replace string birthdate with Date object
        categories.dateResolved = new Date(categories.dateResolved);
        return categories;
    });
}

// Get ticket by category
export const getTicketByResolvedCategory = async () => {
    const response = await internalAxios.get<Tickets[]>(`/employees/resolved/`);
    return response.data.map(categories => {
        categories.datePosted = new Date(categories.datePosted); // Replace string birthdate with Date object
        categories.dateResolved = new Date(categories.dateResolved);
        return categories;
    });
}

// Create new post
export const createPost = async (post: any) => {
    // let reader = new FileReader();
    // reader.readAsDataURL(post.img);
    const response = await internalAxios.post<PostForum[]>('/employees/post', post);
    return response.data.map(post => {
        post.datePosted = new Date(post.datePosted);
        console.log(response);
    })
}
