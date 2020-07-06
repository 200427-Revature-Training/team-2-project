import React, { useEffect, useState } from 'react';
import './recent-ticket.component.css';
import * as adminRemote from '../../../../remote/admin.remote';
import { Tickets } from '../../../../models/Tickets'; //Global Model
import { UpdateTickets } from '../../../../models/admin/UpdateTickets';
import { Replies } from '../../../../models/Replies'; //Global Model
import { Modal, Button, Form } from 'react-bootstrap';

//Test Object if server not working
const testPayload = [{ 
    ticketId: 1,
    title: 'this is a title',
    datePosted: '12-12-12-12-12-12',
    dateResolved: '12-12-12-12-12-12',
    userFirstName: 'first',
    userLastName: 'last',
    img: 'image.png', //!implement img storage
    message: 'this is a message',
    ticketStatus: 1,
    adminId: 1
}, { 
    ticketId: 2,
    title: 'title',
    datePosted: '12-12-12-12-12-12',
    dateResolved: '12-12-12-12-12-12',
    userFirstName: 'first',
    userLastName: 'last',
    img: 'image.png', //!implement img storage
    message: 'this is a message that does not contain nuts of any kind. It is gluten-free, and dairy-free. It\'s even free of any fat or protein.',
    ticketStatus: 2,
    adminId: 1
}, { 
    ticketId: 3,
    title: 'title',
    datePosted: '12-12-12-12-12-12',
    dateResolved: '12-12-12-12-12-12',
    userFirstName: 'first',
    userLastName: 'last',
    img: 'image.png', //!implement img storage
    message: 'this is a message that does not contain nuts of any kind. It is gluten-free, and dairy-free. It\'s no fun at all. But it does contain one goodie. It has the monkey attack code',
    ticketStatus: 2,
    adminId: 1
}, { 
    ticketId: 4,
    title: 'Cowcow',
    datePosted: '12-12-12-12-12-12',
    dateResolved: '12-12-12-12-12-12',
    userFirstName: 'first',
    userLastName: 'last',
    img: 'image.png', //!implement img storage
    message: 'this is a message that does not contain nuts of any kind. It is gluten-free, and dairy-free. It\'s no fun at all. But it does have 3 fingers and seven toes',
    ticketStatus: 2,
    adminId: 1
}, { 
    ticketId: 5,
    title: 'title',
    datePosted: '12-12-12-12-12-12',
    dateResolved: '12-12-12-12-12-12',
    userFirstName: 'first',
    userLastName: 'last',
    img: 'image.png', //!implement img storage
    message: 'this is a message that does not contain nuts of any kind. It is gluten-free, and dairy-free. It\'s no fun at all.',
    ticketStatus: 2,
    adminId: 1
}, { 
    ticketId: 6,
    title: 'title',
    datePosted: '12-12-12-12-12-12',
    dateResolved: '12-12-12-12-12-12',
    userFirstName: 'first',
    userLastName: 'last',
    img: 'image.png', //!implement img storage
    message: 'this is a message that does not contain nuts of any kind. It is gluten-free, and dairy-free. It\'s no fun at all.',
    ticketStatus: 2,
    adminId: 1
}];

export const RecentTicketsComponent: React.FC = ()=> {

    // All tickets from Global Model
    const [allTickets, setAllTickets] = useState<Tickets[]>([]);

    // All replies from Global Model
    const [allReplies, setAllReplies] = useState<Replies[]>([]); 

    // Populate Modal from selected ticket
    const [allRecentTickets, setAllRecentTickets] = useState<UpdateTickets>({
        ticketId: 0,
        title: '',
        dateResolved: '',
        userFirstName: '',
        userLastName: '',
        message: '',
        ticketStatus: 0,
        adminId: 0
    });


    const [modalVisible, setModalVisible] = useState(false); //Modal Set to default [Off]
    const [inputTicketID, setInputTicketID] = useState(0); //Update status by ticket id
    const [inputStatusID, setInputStatusID] = useState(0); //Update Status



    useEffect(() => {
    loadTables(); //Refresh page   
    }, [])

    const updateTicket = async () => {
    let SetDate = new Date(); /**Set Current Date */
    const payload = { 
        ticketId: inputTicketID,
        dateResolved: SetDate,
        ticketStatus: inputStatusID,
        adminId: 1
    };

    await adminRemote.updateTicketStatus(payload); /**Send UPDATE REQUEST */
    setModalVisible(false) //Close Modal
    loadTables(); /**read GET REQUEST  */
}

    /**Load ticket-card data */ 
    const loadTables = () => {  
        adminRemote.getRepliesById().then(replies => {
            setAllReplies(replies);
        });

        adminRemote.getRecentTickets().then(tickets => {
            setAllTickets(tickets);
        });
    };

    /**View Ticket Button */
    const loadModal = (a: any)=> {
        setAllRecentTickets(a); //load modal with ticket data
        setModalVisible(true); //Open Modal
    }

    return(
        <div>
            {/* Recent Tickets Cards*/}
            <section>
            {/* NOTE: Using BootStrap Table for testing.
            Replace table with Ticket/Cards aligning horizontally as shown in wireframes. 
            Data should be populating from global Ticket.ts model as its currently doing so now */}
            <header>
                <h2 id="accounts-header" className="dark">Recent Tickets</h2>
            </header>
                {/* <table className="table table-striped">
                    <thead className="thead-dark">
                        <tr>
                            <th scope="col"># ID: </th>
                            <th scope="col">Post: </th>
                            <th scope="col">Request Date: </th>
                            <th scope="col">Status: </th>
                        </tr>
                    </thead>
                    <tbody>
                        {allTickets.map(a => {
                            return (
                                <tr key={a.ticketId}>
                                    <th scope="row">{a.ticketId}</th>
                                    <td>{a.title}</td> */}
                                    {/* <td>{typeof a.datePosted == 'string' ? a.datePosted : a.datePosted.toDateString()}</td> */}
                                    {/* <td>{a.ticketStatus}</td>

                                    <button className="btn btn-success"
                                        onClick={() => loadModal(a)}>
                                        View Ticket
                                </button>
                                </tr>
                            )
                        })}
                    </tbody>
                </table> */}
            {/* {allTickets.map(a => {
                return (
                    <div className='recentCard'>
                        <div className='recentTop'>
                            <p>ID: {allRecentTickets.ticketId}</p>
                            <p>{allRecentTickets.title}</p>
                            <p>{allRecentTickets.message}</p>
                        </div>
                        <div className='recentBottom'>
                            <p>Pending</p>

                            <button className="btn btn-success"
                                onClick={() => loadModal(a)}>
                                View Ticket
                            </button>
                        </div>
                    </div>
                    )
                })} */}


                {allTickets.map(a => {
                    return (
                        <div className='recentContainer'>
                            <div className='allRecent'>
                                <div className='recentCard'>
                                    <div className='recentTop'>
                                        <p className='colorize'>
                                            ID: {a.ticketId}
                                            <span className='bold'>
                                                <span className='line'> | </span>
                                                {a.title}
                                            </span>
                                        </p>
                                        {/* <p className='boldIt'>{a.title}</p> */}
                                        <p className="message">{a.message}</p>
                                    </div>
                                    <div className='recentBottom'>
                                        <p>Pending</p>

                                        <button id="open" className="btn btn-light"
                                            onClick={() => loadModal(a)}>
                                            Accept
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        
                    )
                })}
            </section>
                

            <section>
                {/* Note: using react-bootstrap modal for testing.
                Currently ticket id, status, and close modal button are seperate and will need to be combined during styling to execute at once when button is clicked.
                Data should be populating from updatetickets model & global replies model as its currently doing so now.  */}
                <Modal show={modalVisible} onHide={() => setModalVisible(false)}  >
                    <Modal.Header>
                        <Modal.Title>Recent Ticket</Modal.Title>    
                    </Modal.Header>
                    <Modal.Body>
                        <Form>
                            <Form.Group>  
                                <Form.Label># ID::</Form.Label>
                                    <p> {allRecentTickets.ticketId} </p>
                            </Form.Group>
                            <Form.Group>
                                <Form.Label>Employee::</Form.Label>
                                <p> {allRecentTickets.userFirstName} {allRecentTickets.userLastName} </p>
                            </Form.Group>
                            <Form.Group>
                                <Form.Label>Content::</Form.Label>
                                <p> {allRecentTickets.message} </p>
                            </Form.Group>
                            <Form.Group>
                                <Form.Label>Status::</Form.Label>
                                <p> {allRecentTickets.ticketStatus} </p>
                            </Form.Group>
                                {allReplies.map(b => {
                                    return(
                                        <Form.Group>
                                            <Form.Label>Comments:</Form.Label>
                                            <p> {b.date} </p>
                                            {/* <p> {b.ticketPostId} </p> */}
                                            <p> {b.userFirstName} </p>
                                            <p> {b.userLastName} </p>
                                            <p> {b.replies} </p>
                                            </Form.Group>
                                        )
                                    })}
                            {/* get ticket id for update request */}
                            <Form.Group> 
                                <Form.Label> Select this ticket:</Form.Label>
                                <input id="select-this-ticket" value={allRecentTickets.ticketId} onChange={(e) => setInputTicketID(+e.target.value)} type="radio"/>
                            </Form.Group>
                            {/* change ticket status for update request */}
                            <Form.Group>
                                <Form.Label> Accept:</Form.Label>
                                <input id="accept" value="2" onChange={(e) => setInputStatusID(+e.target.value) }  type="radio"  name="status"/>
                            </Form.Group>
                        </Form>
                    </Modal.Body>
                    <Modal.Footer>
                        <Button id="close" onClick={() => setModalVisible(false)}>Close</Button>
                        <Button id="update" onClick={() => updateTicket()}>Update</Button>                            
                    </Modal.Footer>
                </Modal>
            </section>
        </div>
    );
};