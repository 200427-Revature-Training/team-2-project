export interface HistoryPost {
    userId: number;
    ticketId: number;
    title: string;
    datePosted: Date | string;
    dateResolved: Date | string;
    ticketStatus: number;
}