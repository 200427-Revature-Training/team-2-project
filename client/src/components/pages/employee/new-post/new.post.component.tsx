import React, { useState, useEffect } from 'react';
import './new.post.component.css';
import * as employeeRemote from '../../../../remote/employee.remote';
import { Modal, Button, Form } from 'react-bootstrap';
import { Tickets } from '../../../../models/Tickets';

export const NewPostComponent: React.FC = () => {

    // All tickets from Global Model
    const [allTickets, setAllTickets] = useState<Tickets[]>([]);

    // For Post Modal
    // const [postTicket, setPostTicket] = useState<PostForum[]>([]);

     // Post/Ticket Creation Modal
    const [inputTitle, setInputTitle] = useState(''); // Forum post title
    const [inputUserId, setInputUserId] = useState(0); // Set user id
    const [inputUsername, setInputUsername] = useState(0); // Post username
    const [inputMessage, setInputMessage] = useState(''); // Forum post body
    const [inputStatusId, setInputStatusId] = useState(0); // Set whether you want to make ticket
    const [modalVisible, setModalVisible] = useState(false); // Modal view

    useEffect(() => {
        loadPosts();
    }, [])

    const createPost = async () => {
            let SetDate = new Date(); /**SET DATE HERE */
            const payload = { 
                statusId: inputStatusId,
                userId: inputUsername,
                adminId: null,
                datePosted: SetDate,
                title: inputTitle,
                message: inputMessage
            };
    
            await employeeRemote.createPost(payload);  /**SEND REQUEST HERE */
            setInputTitle('');
            setInputMessage('');
            setInputStatusId(0);
            setInputUsername(0);
            setInputUserId(0);
            setModalVisible(false); /*CLOSE Modal*/
            loadPosts(); /**GET REQUEST HERE */
    }

    const loadModal = (a: any)=> {
        setModalVisible(true); //Open Modal
    };

    const loadPosts = () => {
        employeeRemote.getAllTickets().then(tickets => {
            setAllTickets(tickets);
        });
    }

    return(
        <div>
            <section>
                <Button onClick={() => loadModal(true)}>
                    New Post
                </Button>
            </section>
            <section>
            <Modal show={modalVisible} onHide={() => setModalVisible(false)}  >
                <Modal.Header>
                    <Modal.Title>New Post/Ticket</Modal.Title>  
                </Modal.Header>
                <Form>
                    <Form.Group>
                        <Form.Label>Title</Form.Label>
                        <Form.Control value={inputTitle} type="text" 
                        onChange={(e) => setInputTitle(e.target.value)} />
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Message</Form.Label>
                        <Form.Control value={inputMessage} type="text" 
                        onChange={(e) => setInputMessage(e.target.value)} />
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Ticket?</Form.Label>
                        <Form.Control value={inputStatusId} onChange={(e) => setInputStatusId(+e.target.value)} 
                        type="checkbox"  name="status"/>
                    </Form.Group>
                </Form>
                <Modal.Footer>
                    <Button onClick={() => setModalVisible(false)}>Close</Button>
                    <Button onClick={() => createPost()}>Submit</Button>                            
                </Modal.Footer>
            </Modal>
        </section>
    </div>
    )}