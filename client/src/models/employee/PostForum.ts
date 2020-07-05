export interface PostForum {
    statusId: number;
    userId: number; //change to username, pull from localstorage for evan to valid who send it
    datePosted: Date | string;
    title: string;
    message: string;
}