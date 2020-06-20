/**All tickets table model for admin.component.tsx */
export interface Administrator {
    ticket_id?: number;
    description?: string;
    adminName?: string;
    resolvedDate: Date | string;
    employeeName?: string;
};