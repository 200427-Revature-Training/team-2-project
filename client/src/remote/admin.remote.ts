import { internalAxios, authAxios } from './internal-axios';
import { Administrator } from '../models/Administrators';


// Get all tickets table
export const getAllTicketTable = async () => {
    const response = await internalAxios.get<Administrator[]>('/employees/reimburse');
    return response.data.map(reimburse => {
        reimburse.sumitDate = new Date(reimburse.sumitDate); // Replace string birthdate with Date object
        reimburse.resolvedDate = new Date(reimburse.resolvedDate);
        console.log(response);
        return reimburse;
    });
    
}