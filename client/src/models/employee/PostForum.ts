export interface PostForum {
    postId: number;
    statusId: number;
    userId: number;
    adminId: number;
    datePosted: Date | string;
    title: string;
    message: string;
}