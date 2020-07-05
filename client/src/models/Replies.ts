/**Global Model for All commnets */
export interface Replies {
    rid: number;
    ticketPostId: number;
    date: Date | string;
    userFirstName: string;
    userLastName: string;
    userImage: string;
    replies: string;
};