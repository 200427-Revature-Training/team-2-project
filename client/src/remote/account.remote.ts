import { internalAxios } from './internal-axios';
import { Authenticate } from '../../src/models/login/Authenticate';
import { Authorize } from '../../src/models/login/Authorize';
import { Users } from '../models/Users';
import { Tickets } from '../models/Tickets';

// Login:request token & user payload
export const createUser = async (login: Authorize) => {
    const response = await internalAxios.post('/user', login); //Comeback to this
    return response; //console.log(response);
}

// Login:create token & request user payload
export const createToken = async (login: Authenticate) => {
    const response = await internalAxios.post('/user/login', login); //Comeback to this
    return response; //console.log(response);
}



// Login:create token & request user payload
export const getbyId = async (ticketId: number) => {
    const response = await internalAxios.get(`/administrator/tickets/${ticketId}`); //Comeback to this
    return response; //console.log(response);
}