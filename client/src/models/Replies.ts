/**Global Model for All commnets */
export interface Replies {
    ticketPostId: number;
    timestamp: Date | string;
    userId: number;
    replies: string;
};