export interface PostForum {
    ticketStatus: number;
    userName: string; //change to username, pull from localstorage for evan to valid who send it
    datePosted: Date | string;
    title: string;
    message: string;
}