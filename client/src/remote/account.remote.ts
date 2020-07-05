import { internalAxios } from './internal-axios';
import { Authenticate } from '../../src/models/login/Authenticate';
import { Authorize } from '../../src/models/login/Authorize';
import { Users } from '../models/Users';

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
export const getbyId = async (userId: number | string | null) => {
    const response = await internalAxios.get<Users>(`/user/login/${userId}`); //Comeback to this
    return response; //console.log(response);
}