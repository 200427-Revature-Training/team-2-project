export class UpdateTickets {
    ticketId: number;
    title: string;
    dateResolved: Date | string;
    userFirstName: string;
    userLastName: string;
    message: string;
    ticketStatus: number;
    adminId: number;

    static from(obj: UpdateTicketsRow): UpdateTickets {
        const updateTickets = new UpdateTickets(
            obj.card_id,
            obj.title,
            new Date(obj.date_resolved),
            obj.firstname,
            obj.lastname,
            obj.message,
            obj.ticket_status,
            obj.admin_id
        );
        return updateTickets;
    }

    constructor(
        ticketId: number,
        title: string,
        dateResolved: Date | string,
        userFirstName: string,
        userLastName: string,
        message: string,
        ticketStatus: number,
        adminId: number
        )
        {
        this.ticketId = ticketId;
        this.title = title;
        this.dateResolved = dateResolved;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.message = message;
        this.ticketStatus = ticketStatus;
        this.adminId = adminId;
    }
}

export interface UpdateTicketsRow {
    card_id: number;
    title: string;
    date_resolved: string;
    firstname: string;
    lastname: string;
    message: string;
    ticket_status: number;
    admin_id: number;
}