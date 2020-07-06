import React, { useEffect, useState } from 'react';
import './accepted-tickets.component.css';
import * as adminRemote from '../../../../remote/admin.remote';
import { Tickets } from '../../../../models/Tickets'; //Global Model
import { UpdateTickets } from '../../../../models/admin/UpdateTickets';
import { Replies } from '../../../../models/Replies'; //Global Model
import { Modal, Button, Form } from 'react-bootstrap';
import anim0 from '../../../../temppics/aa0.png';
import anim1 from '../../../../temppics/aa1.png';
import anim2 from '../../../../temppics/aa2.png';
import anim3 from '../../../../temppics/aa3.png';

//Test Object if server not working
const testPayload = [{ 
    ticketId: 1,
    title: 'title',
    datePosted: '12-12-12',
    dateResolved: '12-12-12',
    userFirstName: 'first',
    userLastName: 'last',
    img: <img src={anim2} width="50.5%" alt='0' />, //!implement img storage
    message: 'message',
    ticketStatus: 1,
    adminId: 1
}, {
    ticketId: 2,
    title: 'titleistitle',
    datePosted: '12-48-65',
    dateResolved: '12-56-09',
    userFirstName: 'Charlie',
    userLastName: 'Adminman',
    img: <img src={anim1} width="50.5%" alt='0' />, //!implement img storage
    message: 'message',
    ticketStatus: 1,
    adminId: 1
}, {
    ticketId: 3,
    title: 'This is the title of a ticket',
    datePosted: '1-2-2004',
    dateResolved: '12-15-2021',
    userFirstName: 'Anna',
    userLastName: 'Hardy',
    img: <img src={anim2} width="50.5%" alt='0' />, //!implement img storage
    message: 'Hello World',
    ticketStatus: 1,
    adminId: 1
}, {
    ticketId: 4,
    title: 'This is the title of a ticket that has carried on for far too long.',
    datePosted: '1-2-2225',
    dateResolved: '12-15-1985',
    userFirstName: 'Zorp',
    userLastName: 'Bardeny',
    img: <img src={anim3} width="50.5%" alt='0' />, //!implement img storage
    message: 'This might be a message.',
    ticketStatus: 1,
    adminId: 1
}, {
    ticketId: 5,
    title: 'The wind is blowing the wifi away.',
    datePosted: '5-23-2020',
    dateResolved: '',
    userFirstName: 'the',
    userLastName: 'boss',
    img: <img src={anim1} width="50.5%" alt='0' />, //!implement img storage
    message: 'Wind blows away my wifi when I leave the building.',
    ticketStatus: 1,
    adminId: 1
}];

export const AcceptedTicketsComponent: React.FC = ()=> {


    // All tickets from Global Model
    const [allTickets, setAllTickets] = useState<Tickets[]>([]);

    // All replies from Global Model
    const [allReplies, setAllReplies] = useState<Replies[]>([]); 

    // Populate Modal from selected ticket
    const [allAcceptedTickets, setAllAcceptedTickets] = useState<UpdateTickets>({
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

        adminRemote.getAcceptedTickets().then(tickets => {
            setAllTickets(tickets);
        });
    };

    /**View Ticket Button */
    const loadModal = (a: any)=> {
        setAllAcceptedTickets(a); //load modal with ticket data
        setModalVisible(true); //Open Modal
    };



    return(
        <div>
            {/* Ticket-Card */}
            <section>
                {/* NOTE: Using BootStrap Table for testing.
                Replace table with Ticket/Cards aligning horizontally as shown in wireframes. 
                ticket-cards will need to be styled slightly smaller with less data as shown in "AdminDashoard2.png"
                Data should be populating from global Ticket.ts model as its currently doing so now */}
                <header>
                    <h2 id="accounts-header" className="dark">Accepted Tickets</h2>
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
                        {testPayload.map(a => {
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
                        })} */}
                {/* </tbody>
                </table> */}
                {allTickets.map(a => {
                    return (
                        <div className='acceptedContainer'>
                            <div className='allAccepted'>
                                <div className='acceptedCard'>
                                    <div className='acceptedTop'>
                                        <div className='resize'><img id='iconAccpeted' src={a.userImage} width="50.5%" alt='0' /></div>
                                        {/* <div className='resize'>{a.img}</div> */}
                                        <div className='boldIt'>{a.title}</div>
                                    </div>
                                    <div className='acceptedBottom'>
                                        <button id="view" className="btn btn-light"
                                            onClick={() => loadModal(a)}>
                                            Resolve
                                        </button>
                                        <div className='date'>
                                            {a.datePosted}
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    
                    )
                })}
            </section>
                {/* <tr key={a.ticketId}>
                        <th scope="row">{a.ticketId}</th>
                        <td>{a.title}</td>
                        { }/* <td>{typeof a.datePosted == 'string' ? a.datePosted : a.datePosted.toDateString()}</td> */}
                        {/* <td>{a.ticketStatus}</td>
                            
                        <button className="btn btn-success"
                            onClick={() => loadModal(a)}>
                            View Ticket
                        </button>
                    </tr> */}

            <section>
             {/* Note: using react-bootstrap modal for testing.
            Currently ticket id, status, and close modal button are seperate and will need to be combined during styling to execute at once when button is clicked.
            Data should be populating from updatetickets model & global replies model as its currently doing so now.  */}
                <Modal show={modalVisible} onHide={() => setModalVisible(false)}  >
                    <Modal.Header>
                        <Modal.Title>Accepted Ticket</Modal.Title>  
                    </Modal.Header>
                    <Modal.Body>
                        <Form>
                            <Form.Group>  
                                <Form.Label># ID::</Form.Label>
                                <p> {allAcceptedTickets.ticketId} </p>
                            </Form.Group>
                            <Form.Group>
                                <Form.Label>Employee::</Form.Label>
                                <p> {allAcceptedTickets.userFirstName} {allAcceptedTickets.userLastName} </p>
                            </Form.Group>
                            <Form.Group>
                                <Form.Label>Content::</Form.Label>
                                <p> {allAcceptedTickets.message} </p>
                            </Form.Group>
                            <Form.Group>
                                <Form.Label>Status::</Form.Label>
                                <p> {allAcceptedTickets.ticketStatus} </p>
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
                                    <input id="select-this-ticket" value={allAcceptedTickets.ticketId} onChange={(e) => setInputTicketID(+e.target.value)} type="radio"/>
                            </Form.Group>
                            {/* change ticket status for update request */}
                            <Form.Group>  
                                <Form.Label> Resolved:</Form.Label>
                                <input id="accept" value="3" onChange={(e) => setInputStatusID(+e.target.value) }  type="radio"  name="status"/>
                            </Form.Group>
                        </Form>
                    </Modal.Body>
                    <Modal.Footer>
                        <Button id="close-modal" onClick={() => setModalVisible(false)}>Close</Button>
                        <Button id="update-ticket" onClick={() => updateTicket()}>Update</Button>                            
                    </Modal.Footer>
                </Modal>
            </section>
        </div>
    );
};