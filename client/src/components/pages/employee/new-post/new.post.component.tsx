import React, { useState, useEffect } from 'react';
import './new.post.component.css';
import * as employeeRemote from '../../../../remote/employee.remote';
import { Modal, Button, Form, Card } from 'react-bootstrap';
import { PostForum } from '../../../../models/employee/PostForum';
import { Tickets } from '../../../../models/Tickets';

const testPayload = [{ 
    ticketId: 1,
    title: 'title',
    datePosted: '12-12-12-12-12-12',
    dateResolved: '12-12-12-12-12-12',
    userFirstName: 'first',
    userLastName: 'last',
    img: 'image.png', //!implement img storage
    message: 'message',
    ticketStatus: 1,
    adminId: 1
},
{
    ticketId: 2,
    title: 'title',
    datePosted: '12-12-12-12-12-12',
    dateResolved: '12-12-12-12-12-12',
    userFirstName: 'first',
    userLastName: 'last',
    img: 'image.png', //!implement img storage
    message: 'message',
    ticketStatus: 2,
    adminId: 1
}];

export const NewPostComponent: React.FC = () => {

    // Populate Posts
    const [allPosts, setAllPosts] = useState<Tickets[]>([]);

     // Post/Ticket Creation Modal
    const [inputTitle, setInputTitle] = useState(''); // Forum post title
    // const [inputUsername, setInputUsername] = useState(1); // Post username
    const [inputMessage, setInputMessage] = useState(''); // Forum post body
    const [inputStatusId, setInputStatusId] = useState(0); // Set whether you want to make ticket
    const [modalVisible, setModalVisible] = useState(false); // Modal view

    const loadModal = (a: any)=> {
        setModalVisible(true); //Open Modal
    };

    const loadPosts = () => {
        employeeRemote.getAllTickets().then(tickets => {
            setAllPosts(tickets);
        });
    }

    const createPost = async () => {
            let SetDate = new Date(); /**SET DATE HERE */
            const payload = { 
                statusId: inputStatusId,
                // userId: inputUsername,
                adminId: null,
                datePosted: SetDate,
                title: inputTitle,
                message: inputMessage
            };
    
            await employeeRemote.createPost(payload);  /**SEND REQUEST HERE */
            setModalVisible(false); /*CLOSE Modal*/
            loadPosts(); /**GET REQUEST HERE */
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
                        <input value={inputTitle} type="text" 
                        onChange={(e) => setInputTitle(e.target.value)} />
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Message</Form.Label>
                        <input value={inputMessage} type="text" 
                        onChange={(e) => setInputMessage(e.target.value)} />
                    </Form.Group>
                    <Form.Group>
                        <Form.Label>Ticket?</Form.Label>
                        <input value={inputStatusId} onChange={(e) => setInputStatusId(+e.target.value)} 
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