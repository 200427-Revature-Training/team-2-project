/**Global Model for All commnets */
export interface Replies {
    rid: number;
    ticketPostId: number;
    timestamp: Date | string;
    userFirstName: string;
    userLastName: string;
    userImage: JSX.Element;
    replies: string;
};