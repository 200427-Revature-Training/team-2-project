export interface HistoryPost {
    userId: number;
    title: string;
    datePosted: Date | string;
    dateResolved: Date | string;
    ticketStatus: number;
}