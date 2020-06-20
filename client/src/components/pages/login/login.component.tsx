import React, { useState, useEffect } from 'react';
import * as usersRemote from '../../../remote/test.remote';
import { User } from '../../../models/test-models/User';
import './login.component.css'
import { useHistory } from 'react-router';


export const LoginComponent:React.FC = ()=>{
   
    const history = useHistory(); // Access history for Login redirect
    
    const [reimbursements, setReimbursements] = useState<User[]>([]); /**SET PAGE DATA HERE */

    const [inputUsertName, setInputUsertName] = useState('');
    const [inputPassword, setinputPassword] = useState('');

    useEffect(() => {
        loadCredentails();
    }, []);


    const addUser = async () => {
        const payload = {
            userID: undefined, 
            userRole: undefined,
            userName: inputUsertName,
            userPassword: inputPassword
        };
        history.push('/employee');
        
      console.log('Sending authentication request: ', payload);
      const response = await usersRemote.createToken(payload); //SEnd POST
        // setInputUsertName(''); //clear fields
        // setinputPassword('');
        const userName = response.data.userName;
        const accessToken = response.data.accessToken;
       
        localStorage.setItem('userName', userName);
        localStorage.setItem('accessToken', accessToken); 
        


        loadCredentails(); 
    };


     const loadCredentails = () => {   

       usersRemote.getAllUserTable().then(user => { 
        setReimbursements(user);
        console.log('Recieved authentication request: ', user);
        });        
    };

    return(
        <div>
            <label>username</label><input type="text" name="text" value={inputUsertName} onChange={e => setInputUsertName(e.target.value)}/>
            <label>password</label><input type="password" name="password" value={inputPassword} onChange={e => setinputPassword(e.target.value)}/>
            <button onClick={() => addUser()}>Submit</button>
        </div>
    );
};