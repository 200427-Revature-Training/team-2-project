// Post Category
import React, { useState, useEffect } from 'react';
import './category.post.component.css';
import '../category-views.component.css';
import { Tickets } from '../../../../../models/Tickets';
import { Replies } from '../../../../../models/Replies';
import { Form, Modal, Button, ButtonGroup } from 'react-bootstrap';
import * as employeeRemote from '../../../../../remote/employee.remote';
import anim0 from '../../../../../temppics/aa0.png';
import anim1 from '../../../../../temppics/aa1.png';
import anim2 from '../../../../../temppics/aa2.png';
import anim3 from '../../../../../temppics/aa3.png';

// Used to switch views between categories
interface CategoryPostComponentProps {
    setView: (str: 'CATEGORY_POST' | 'CATEGORY_PENDING' | 'CATEGORY_ACCEPTED' | 'CATEGORY_RESOLVED' | 'ALL') => void;
}

// Test objects if data is needed
const testTicketsPost: Tickets[] = [{ 
    ticketId: 1,
    title: 'title',
    datePosted: '12-12-12-12-12-12',
    dateResolved: '12-12-12-12-12-12',
    userFirstName: 'first',
    userLastName: 'last',
    userImage: 'image.png',
    message: 'message',
    ticketStatus: 0,
    adminFirstName: 'Mom',
    adminLastName: 'Mom'
}];

const testRepliesPost : Replies[] = [{
    rid: 1,
    ticketPostId: 1,
    date: 'a date',
    userFirstName: 'some guy',
    userLastName: 'anotherguy',
    userImage: 'image.png',
    replies: 'jdfalk;sjdfkal;sfdjl;ksdafj;lksad'
}];

export const CategoryPostComponent: React.FC<CategoryPostComponentProps> = (props) => {

    // All tickets from Global Model
    const [allTickets, setAllTickets] = useState<Tickets[]>([]);

    // All replies from Global Model
    const [allReplies, setAllReplies] = useState<Replies[]>([]);

    // Modal to see post
    const [modalVisible, setModalVisible] = useState(false);

    // Populate Modal from selected ticket
    const [ticketById, setTicketById] = useState<Tickets>({
        ticketId: 0,
        title: '',
        datePosted: '',
        dateResolved: '',
        userFirstName: '',
        userLastName: '',
        userImage: 'image.png',
        message: '',
        ticketStatus: 0,
        adminFirstName: '',
        adminLastName: ''
    });

    useEffect(() => {
        loadPosts();
    }, []);

    /**Load ticket-card data */ 
    const loadPosts = () => {  
        employeeRemote.getRepliesById().then(replies => {
                setAllReplies(replies);
        });
    
        employeeRemote.getTicketByPostCategory().then(tickets => {
            setAllTickets(tickets);
        });
    };
    
    /**View Ticket Button */
    const loadModal = (a: any)=> {
        setTicketById(a); //load modal with ticket data
        setModalVisible(true); //Open Modal
    };
    
    return (
        // Button Group Bar for categories should be universal for each category component
        <div>
            <section>
                <div className='viewButtons'>
                    <ButtonGroup aria-label="Basic example">
                        <Button variant="light" onClick={() => props.setView('ALL')}>All</Button>
                        <Button variant="light" onClick={() => props.setView('CATEGORY_POST')}>Post</Button>
                        <Button variant="light" onClick={() => props.setView('CATEGORY_PENDING')}>Pending</Button>
                        <Button variant="light" onClick={() => props.setView('CATEGORY_ACCEPTED')}>Accepted</Button>
                        <Button variant="light" onClick={() => props.setView('CATEGORY_RESOLVED')}>Resolved</Button>
                    </ButtonGroup>
                </div>
                {/* NOTE: Using regular Table for testing.
                Replace table to best reflect wireframe table.
                Data should be populating from global Ticket.ts model as its currently doing so now */}
                {/* <table>
                    <thead>
                        <tr>
                            <th scope="col"># ID: </th>
                            <th scope="col">Post: </th>
                            <th scope="col">Request Date: </th>
                            <th scope="col">Resolved Date: </th>
                            <th scope="col">Status: </th>
                        </tr>
                    </thead>
                    <tbody> */}
                    {allTickets.map(a => {
                        return (
                            <div className='allContainers'>
                                <div className='allAccepted'>
                                    <div className='allAcceptedCard'>
                                        <div className='allTop'>
                                            <div className='resize'>{<img src={a.userImage} width="20%" alt='0' />}</div>
                                            {/* <div className='resize'>{a.userImage}</div> */}
                                            <div className='topOfCard'>Posted By: {a.userFirstName} {a.userLastName}</div>
                                            <div className='topOfCard'>{a.datePosted}</div>
                                            </div>
                                            <div className='middleOfCard'>{a.title}</div>
                                            <div className='middleOfCardText'>{a.message}</div>
                                            <div className='allBottom'>
                                            {/* <button className="btn btn-primary resolveSpace"
                                                onClick={() => loadModal(a)}>
                                                Resolve
                                            </button> */}
                                                <div className='downLeft'>Save</div>
                                            <button className="btn btn-light"
                                                onClick={() => loadModal(a)}>
                                                View Ticket/Post
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            /* <tr key={a.ticketId}>
                            <td>{a.userImage}</td>
                            <th scope="row">{a.ticketId}</th>
                            <td>{a.title}</td>
                            <td>{typeof a.datePosted == 'string' ? a.datePosted : a.datePosted.toDateString()}</td>
                            <td>{typeof a.dateResolved == 'string' ? a.dateResolved : a.dateResolved.toDateString()}</td>
                            <td>{a.ticketStatus}</td>  
                            <button className="btn btn-success"
                                onClick={() => loadModal(a)}>
                                View Ticket/Post
                            </button>
                            </tr> */
                        )
                    })}
                    {/* </tbody>
                </table> */}
            </section>
            <section>
                <Modal show={modalVisible} onHide={() => setModalVisible(false)}  >
                    <Modal.Header>
                        <Modal.Title>
                            Ticket/Post Entry
                        </Modal.Title>
                    </Modal.Header>
                    <Modal.Body>
                        <Form>
                            <Form.Group>  
                                <Form.Label># ID::</Form.Label>
                                <p> {ticketById.ticketId} </p>
                            </Form.Group>
                            <Form.Group>
                                <Form.Label>Employee::</Form.Label>
                                <p> {ticketById.userFirstName} {ticketById.userLastName} </p>
                            </Form.Group>
                            <Form.Group>
                                <Form.Label>Title::</Form.Label>
                                <p> {ticketById.title} </p>
                            </Form.Group>
                            <Form.Group>
                                <Form.Label>Content::</Form.Label>
                                <p> {ticketById.message} </p>
                            </Form.Group>
                            <Form.Group>
                                <Form.Label>Status::</Form.Label>
                                <p> {ticketById.ticketStatus} </p>
                            </Form.Group>
                            {allReplies.map(b => {
                                return(
                                    <Form.Group>
                                        <Form.Label>Comments:</Form.Label>
                                        <p> {b.date} </p>
                                        <p> {b.ticketPostId} </p>
                                        <p> {b.userFirstName} </p>
                                        <p> {b.userLastName} </p>
                                        <p> {b.replies} </p>
                                    </Form.Group>
                                )
                            })}
                        </Form>
                        <Modal.Footer>
                            <Button onClick={() => setModalVisible(false)}>Close</Button>
                        </Modal.Footer>
                    </Modal.Body>
                </Modal>
            </section>    
        </div>
    )   
}