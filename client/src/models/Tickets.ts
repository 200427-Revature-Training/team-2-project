/**Global Model for All tickets */
export interface Tickets {
    ticketId: number;
    ticketStatus: number;
    userFirstName: string,
    userLastName: string,
    userImage: string; //!implement img storage
    adminFirstName: string;
    adminLastName: string;
    datePosted: Date | string;
    dateResolved: Date | string;
    title: string;
    message: string;
};