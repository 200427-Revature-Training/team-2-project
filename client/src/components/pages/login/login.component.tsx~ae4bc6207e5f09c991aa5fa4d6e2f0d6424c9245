import React, { useState, useEffect } from 'react';

import * as accountRemote from '../../../remote/account.remote';
import './login.component.css';
import { useHistory } from 'react-router';
import Form from 'react-bootstrap/Form';
import Button from 'react-bootstrap/Button';
import Modal from 'react-bootstrap/Modal';
import Row from 'react-bootstrap/Row';
import Col from 'react-bootstrap/Col';
import Alert from 'react-bootstrap/Alert';
import Spinner from 'react-bootstrap/Spinner';



export const LoginComponent:React.FC = ()=>{

    const history = useHistory(); // Access history for Login redirect


    const [inputLoginUsertName, setLoginUsertName] = useState('');
    const [inputLoginPassword, setLoginPassword] = useState('');

    
    const [inputRegisterFirstName, setRegisterFirstName] = useState ('');
    const [inputRegisterLastName, setRegisterLastName] = useState ('');
    const [inputRegisterEmail, setRegisterEmail] = useState ('');
    const [inputRegisterUsername, setRegisterUsername] = useState('');
    const [inputRegisterPassword, setRegisterPassword] = useState('');
    
    const [showRegister, setShowRegister] = useState(false);
    const [showAlert, setShowAlert] =useState(false);
    const [showLoading, SetShowLoading] = useState(false);

    const [validated, setValidated] = useState(false);

    // useEffect(() => {
    //     loadCredentails();
    // }, []);


    /**Register User */
    const registerUser = async () => {
        const payload = {
            firstName: inputRegisterFirstName,
            lastName: inputRegisterLastName,
            email: inputRegisterEmail,
            userName: inputRegisterUsername,
            userPassword: inputRegisterPassword
        };

        console.log(payload);
        const response = await accountRemote.createUser(payload); //SEnd POST
        setLoginUsertName(''); //clear fields
        setLoginPassword('');

        // loadCredentails();
    };


    /**Login User */
    const loginUser = async () => {
        const payload = {
            userName: inputLoginUsertName,
            userPassword: inputLoginPassword
        };
     
        if (localStorage.getItem('userRole') === 'Employee'){
            history.push('/employee');
        }else if(localStorage.getItem('userRole') === 'Admin'){
            history.push('/administrator');
        }


        const response = await accountRemote.createToken(payload); //SEnd POST
        
        setLoginUsertName(''); //clear fields
        setLoginPassword('');

        const userName = response.data.userName;
        const firstName = response.data.firstName;
        const lastName = response.data.lastName;
        const userRole = response.data.userRole;
        const userImage = response.data.userImage;
        const accessToken = response.data.jwt;

        localStorage.setItem('userName', userName);
        localStorage.setItem('firstName', firstName);
        localStorage.setItem('lastName', lastName);
        localStorage.setItem('userRole', userRole);
        localStorage.setItem('userImage', userImage);
        localStorage.setItem('accessToken', accessToken);

        if (localStorage.getItem('userRole') === 'Employee'){
            history.push('/employee');
        }else if(localStorage.getItem('userRole') === 'Admin'){
            history.push('/administrator');
        }

        // loadCredentails();
    };

    // const loadCredentails = () => {


    //    usersRemote.getAllUserTable().then(user => { 
    //     setReimbursements(user);
    //     console.log('Recieved authentication request: ', user);
    //     });

    // };


    const registerSubmit = () => {
        if (inputRegisterFirstName && inputRegisterLastName && inputRegisterEmail && inputRegisterUsername && inputRegisterPassword) {
            registerUser();
            registerClose();
        } else {
            setShowAlert(true);
        }
        // create new user object here to send to database (need user model)
        
        // SetShowLoading(true);
    };

    const registerShow = () => setShowRegister(true);
    const registerClose = () => {
        setShowRegister(false);
        setShowAlert(false);
    }

    return(
        <div>

            {/* Main Login Page */}
            <h1>Welcome to Posticket</h1>
            <h2>Please login</h2>
            <Form>
            <Form.Group controlId="formUsername">
                <Form.Label>Username</Form.Label>
                <Form.Control type="text" placeholder="Username" name="text" value={inputLoginUsertName} onChange={e => setLoginUsertName(e.target.value)} />
                <Form.Text className="text-muted">
                </Form.Text>
            </Form.Group>
            <Form.Group controlId="formPassword">
                <Form.Label>Password</Form.Label>
                <Form.Control type="password" placeholder="Password" name="password" value={inputLoginPassword} onChange={e => setLoginPassword(e.target.value)}/>
            </Form.Group>
            </Form>
            <Button variant="primary" type="submit" onClick={() => loginUser()}>Sign In</Button>
            <h2>New User?</h2>
            <Button variant="primary" type="submit" onClick={registerShow}>Sign Up</Button>

            {/* User Registration Modal */}
            <Modal show={showRegister} onHide={registerClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Register</Modal.Title>
                </Modal.Header>
                <Modal.Body>


                    {/* "Incomplete Form" Alert */}
                    <Alert show={showAlert} variant="danger">
                        <Alert.Heading id="registerwarning">Please Complete Registration</Alert.Heading>
                        <p>All fields are required.</p>
                        <hr />
                        <div className="d-flex justify-content-end">
                        </div>
                    </Alert>


                    <Form>
                        <Form.Group controlId="formNewUsername">
                            <Form.Label>Username</Form.Label>
                            <Form.Control type="text" placeholder="Username" name="text" value={inputRegisterUsername} onChange={e => setRegisterUsername(e.target.value)} />
                            <Form.Text className="text-muted">
                            </Form.Text>
                        </Form.Group>
                        <Form.Group controlId="formName">
                            <Form.Label>Name</Form.Label>
                            <Row>
                            <Col><Form.Control type="text" placeholder="First Name" name="First Name" value={inputRegisterFirstName} onChange={e => setRegisterFirstName(e.target.value)}/></Col>
                            <Col><Form.Control type="text" placeholder="Last Name" name="Last Name" value={inputRegisterLastName} onChange={e => setRegisterLastName(e.target.value)}/></Col>
                            </Row>
                        </Form.Group>
                        <Form.Group controlId="formEmail">
                            <Form.Label>Email</Form.Label>
                            <Form.Control type="email" placeholder="Email" name="email" value={inputRegisterEmail} onChange={e => setRegisterEmail(e.target.value)}/>
                        </Form.Group>
                        <Form.Group controlId="formPassword">
                            <Form.Label>Password</Form.Label>
                            <Form.Control type="password" placeholder="Password" name="password" value={inputRegisterPassword} onChange={e => setRegisterPassword(e.target.value)}/>
                            </Form.Group>
                    </Form>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={registerClose}>Cancel</Button>
                    <Button variant="primary" type="submit" onClick={registerSubmit}>Register</Button>
                </Modal.Footer>
            </Modal>
        </div>
    );
};