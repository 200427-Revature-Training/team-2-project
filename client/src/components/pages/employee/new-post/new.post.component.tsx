import React, { useState, useEffect } from 'react';
import './new.post.component.css';
import * as employeeRemote from '../../../../remote/employee.remote';
import { Modal, Button, Form } from 'react-bootstrap';
import { Tickets } from '../../../../models/Tickets';

export const NewPostComponent: React.FC = () => {

    // All tickets from Global Model
    const [allTickets, setAllTickets] = useState<Tickets[]>([]);

     // Post/Ticket Creation Modal
    const [inputTitle, setInputTitle] = useState(''); // Forum post title
    const [inputUserId, setInputUserId] = useState(1); // Set user id
    // const [inputUsername, setInputUsername] = useState(0); // Post username, may be needed later
    const [inputDatePosted, setDatePosted] = useState('');
    const [inputMessage, setInputMessage] = useState(''); // Forum post body
    const [inputStatusId, setInputStatusId] = useState(0); // Set whether you want to make ticket
    const [modalVisible, setModalVisible] = useState(false); // Modal view

    useEffect(() => {
        loadPosts();
    }, [])

    // Creating a new post function that makes the axios call
    const createPost = async () => {
        let SetDate = new Date(); /**SET DATE HERE */
        const payload = { 
            statusId: inputStatusId,
            userId: inputUserId,
            datePosted: SetDate,
            title: inputTitle,
            message: inputMessage
        };
    
        await employeeRemote.createPost(payload);  /**SEND REQUEST HERE */
        setInputStatusId(0);
        setInputUserId(1);
        setDatePosted('');
        setInputTitle('');
        setInputMessage('');
        setModalVisible(false); /*CLOSE Modal*/
        loadPosts(); /**GET REQUEST HERE */
    }
    
    // Load modal when you click to make a new post
    const loadModal = (a: any)=> {
        setModalVisible(true); //Open Modal
    };

    // Loads posts after submitting ticket/post
    const loadPosts = () => {
        employeeRemote.getAllTickets().then(tickets => {
            setAllTickets(tickets);
        });
    }

    return(
        <div>
            {/* This section contains the new post button that will appear on the right side of the
            page like seen on the wireframe. */}
            <section className='rightBar'>
                <h2>Your Posts / Tickets</h2>
                <Button className='floatRight' onClick={() => loadModal(true)}>
                    New Post
                </Button>
            </section>
            <section>
                {/* This is the new post modal that'll appear when the button is clicked. It's the box
                on the far right of the employee dashboard wireframe separate from the rest of the page */}
                <Modal show={modalVisible} onHide={() => setModalVisible(false)}>
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
                        {/* Note that the submit button won't do anything at this point unless it's hooked up
                        to the dummy server. If it is, nothing new will appear on the page but the new post
                        will populate the card table in the database. You can use the close button above if
                        you need to exit the modal for now. */}
                        <Button onClick={() => createPost()}>Submit</Button>                            
                    </Modal.Footer>
                </Modal>
            </section>
        </div>
    )
}