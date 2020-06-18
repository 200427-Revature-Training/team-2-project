import { internalAxios, authAxios } from './internal-axios';
import { Authenticate } from '../models/Authenticate';
import { Reimburse } from '../models/Reimburse';
import { User } from '../models/User';


// Employee: Add Reimbursement
export const getAllEmployeeReimburse = async () => {
    const response = await internalAxios.get<Reimburse[]>('/employees/reimburse');
    return response.data.map(reimburse => {
        reimburse.sumitDate = new Date(reimburse.sumitDate); // Replace string birthdate with Date object
        reimburse.resolvedDate = new Date(reimburse.resolvedDate);
        console.log(response);
        return reimburse;
    });
    
}

// // Manager: Approval
// export const updateAllManagerRequests = async (approval: ApprovalPatch) => {
//     const response = await internalAxios.patch('/managers/approvals', approval);
//     // return true;
// }



// Account: Get from reimburse table
export const getAllReimbursements = async () => {
    const response = await internalAxios.get<Reimburse[]>('/employees/dashboard');
    return response.data.map(dashboard => {
        dashboard.sumitDate = new Date(dashboard.sumitDate); // Replace string birthdate with Date object
        dashboard.resolvedDate = new Date(dashboard.resolvedDate);
        return dashboard;
    });
}

// Account: Post to reimbursement table  ************
export const createUser = async (reimburse: any) => {
let reader = new FileReader();
reader.readAsDataURL(reimburse.reciept);
const promise = new Promise((resolve, reject)=>{
  
    reader.onload = async ()=>{
        reimburse.reciept = await reader.result;
        console.log('AXIOS', reimburse.reciept);
        const response = await internalAxios.post('/employees/reimburse', reimburse);
      resolve(response);
    }
  });
  return promise;
}



// Authenication:request token
export const createToken = async (login: Authenticate) => {
    const response = await internalAxios.post('/authentication/login', login);
    return response; //console.log(response);
}


// Authenication: get user data with token
export const getAllUserTable = async () => {
    const response = await authAxios.get<User[]>('/users');
    return response.data.map(user => {
        return user;
    });
}