/**All tickets table model for admin.component.tsx */
export interface Tickets {
    ticketId: number;
    title?: string;
    datePosted?: Date | string;
    dateResolved?: Date | string;
    userFirstName?: string,
    userLastName?: string,
    img?: File; //!implement img storage
    message?: string;
    ticketStatus: number;
    adminId: number;
};