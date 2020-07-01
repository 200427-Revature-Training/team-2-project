import React, { useState, useEffect } from 'react';
import './category.pending.component.css';
import { Tickets } from '../../../../../models/Tickets';
import { Replies } from '../../../../../models/Replies';
import { Form, Modal, Button, ButtonGroup } from 'react-bootstrap';
import * as employeeRemote from '../../../../../remote/employee.remote';

interface CategoryPendingComponentProps {
    setView: (str: 'CATEGORY_POST' | 'CATEGORY_PENDING' | 'CATEGORY_ACCEPTED' | 'CATEGORY_RESOLVED' | 'ALL') => void;
}

const testTicketsPending: Tickets[] = [{
        ticketId: 2,
        title: 'title',
        datePosted: '12-12-12-12-12-12',
        dateResolved: '12-12-12-12-12-12',
        userFirstName: 'first',
        userLastName: 'last',
        img: undefined, //!implement img storage
        message: 'message',
        ticketStatus: 1,
        adminId: 1
}];

const testRepliesPending : Replies[] = [{
    rid: 1,
    ticketPostId: 1,
    timestamp: 'a date',
    userId: 1,
    replies: 'jdfalk;sjdfkal;sfdjl;ksdafj;lksad'
}];


export const CategoryPendingComponent: React.FC<CategoryPendingComponentProps> = (props) => {

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
            img: '',
            message: '',
            ticketStatus: 0,
            adminId: 0
            });

       useEffect(() => {
        loadPosts();
    }, []);

    /**Load ticket-card data */ 
    const loadPosts = () => {  
        employeeRemote.getRepliesById().then(replies => {
            setAllReplies(replies);
        });
    
        employeeRemote.getTicketByPendingCategory().then(tickets => {
            setAllTickets(tickets);
        });
    };
    
    /**View Ticket Button */
    const loadModal = (a: any)=> {
        setTicketById(a); //load modal with ticket data
        setModalVisible(true); //Open Modal
    };
    
    return (
        <div>
            <section>
                <ButtonGroup aria-label="Basic example">
                    <Button variant="secondary" onClick={() => props.setView('ALL')}>All</Button>
                    <Button variant="secondary" onClick={() => props.setView('CATEGORY_POST')}>Post</Button>
                    <Button variant="secondary" onClick={() => props.setView('CATEGORY_PENDING')}>Pending</Button>
                    <Button variant="secondary" onClick={() => props.setView('CATEGORY_ACCEPTED')}>Accepted</Button>
                    <Button variant="secondary" onClick={() => props.setView('CATEGORY_RESOLVED')}>Resolved</Button>
                </ButtonGroup>
                <table>
                    <thead>
                        <tr>
                            <th scope="col"># ID: </th>
                            <th scope="col">Post: </th>
                            <th scope="col">Request Date: </th>
                            <th scope="col">Resolved Date: </th>
                            <th scope="col">Status: </th>
                        </tr>
                    </thead>
                    <tbody>
                        {testTicketsPending.map(a => {
                            return (
                            <tr key={a.ticketId}>
                                <th scope="row">{a.ticketId}</th>
                                <td>{a.title}</td>
                                <td>{typeof a.datePosted == 'string' ? a.datePosted : a.datePosted.toDateString()}</td>
                                <td>{typeof a.dateResolved == 'string' ? a.dateResolved : a.dateResolved.toDateString()}</td>
                                <td>{a.ticketStatus}</td>  
                                <button className="btn btn-success"
                                    onClick={() => loadModal(a)}>
                                    View Ticket/Post
                                </button>
                            </tr>
                            )
                        })}
                    </tbody>
                </table>
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
                                {testRepliesPending.map(b => {
                                    return(
                                        <Form.Group>
                                            <Form.Label>Comments:</Form.Label>
                                            <p> {b.timestamp} </p>
                                            <p> {b.ticketPostId} </p>
                                            <p> {b.userId} </p>
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