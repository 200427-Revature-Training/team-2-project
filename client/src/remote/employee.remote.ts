import { internalAxios, authAxios } from './internal-axios';
import { Tickets } from '../models/Tickets';
import { PostForum } from '../models/employee/PostForum';
import { Replies } from '../models/Replies';
import { Categories } from '../models/employee/Categories';
import { HistoryPost } from '../models/employee/HistoryPost';

// Get all posts table
export const getAllPosts = async () => {
    const response = await internalAxios.get<Tickets[]>('/employees/posts');
    return response.data.map(posts => {
        posts.datePosted = new Date(posts.datePosted); // Replace string birthdate with Date object
        posts.dateResolved = new Date(posts.dateResolved);
        console.log(response);
        return posts;
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
export const getAllReplies = async () => {
    const response = await internalAxios.get<Replies[]>('/employees/replies');
    return response.data.map(replies => {
        replies.timestamp = new Date(replies.timestamp); // Replace string birthdate with Date object
        console.log(response);
        return replies;
    });
}

// Get ticket by category
export const getTicketByCategory = async (statusId: number) => {
    const response = await internalAxios.get<Categories[]>(`/employees/post/${statusId}`);
    return response.data.map(categories => {
        return categories;
    });
}

// // Get post/ticket history
// export const getTicketHistory = async ()

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

// Need to clarify if this is needed
// // Change post to ticket
// export const createTicket = async (ticket: Posts) => {
//     const response = await internalAxios.patch('/employees/set-ticket', ticket);
// }

