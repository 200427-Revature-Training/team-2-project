import React, { useEffect, useState } from 'react';
import './admin.component.css';
import * as adminRemote from '../../../remote/admin.remote';
import { Tickets } from '../../../models/Tickets';
import { Replies } from '../../../models/Replies';
import { Modal, Button, Form } from 'react-bootstrap';

export const AdminComponent: React.FC = () => {

    //Populate Comments Data
    const [allReplies, setAllReplies] = useState<Replies[]>([]); 

    // Recent Tickets
    const [allRecentTickets, setAllRecentTickets] = useState<Tickets[]>([]); //Populate Ticket Data
    const [modal1Visible, setModal1Visible] = useState(false);  //Modal

    // Accepted Tickets
    const [allAcceptedTickets, setAllAcceptedTickets] = useState<Tickets[]>([]); //Populate Ticket Data
    const [modal2Visible, setModal2Visible] = useState(false);   //Modal
    
    // Shared by Recent Tickets & Accepted Tickets
    const [inputTicketID, setInputTicketID] = useState(0); //Update status by id
    const [inputStatusID, setInputStatusID] = useState(0); //Update Status

    // All tickets
    const [allTickets, setAllTickets] = useState<Tickets[]>([]); //Populate Ticket Data


    useEffect(() => {
        loadTables();   
    }, [])

    const updateTicket = async () => {
        let SetDate = new Date(); /**SET DATE HERE */
        const payload = { 
            ticketId: inputTicketID,
            ticketStatus: inputStatusID,
            adminId: 1
        };

        await adminRemote.updateTicketStatus(payload);  /**SEND REQUEST HERE */
        
        setModal1Visible(false) /*CLOSE Modal*/
        setModal2Visible(false) /*CLOSE Modal*/

        loadTables(); /**GET REQUEST HERE */
    }

    /**REFRESH PAGE based on state */ 
    const loadTables = () => {  
        adminRemote.getAllReplies().then(tickets => {
            setAllReplies(tickets);
        });

        adminRemote.getAllRecentTickets().then(tickets => {
            setAllRecentTickets(tickets);
        });

        adminRemote.getAllRecentTickets().then(tickets => {
            setAllAcceptedTickets(tickets);
        });

        adminRemote.getAllTickets().then(tickets => {
            setAllTickets(tickets);
        });
    };
    
    return (
        <div>
            {/* NavPanel */}
            <nav> NavPanel Here</nav>
            <main>

                {/* Recent Tickets */}
                <section>
                     {/* BootStrap Table */}
                    <header>
                        <h2 id="accounts-header" className="dark">Recent Tickets 
                            <button 
                                className="btn btn-success"
                                onClick={() => setModal1Visible(true)} /*OPEN MODAL HERE*/
                                >View</button>
                        </h2>
                    </header>

                    <table className="table table-striped">
                        <thead className="thead-dark">
                            <tr>
                                <th scope="col"># ID: </th>
                                <th scope="col">Post: </th>
                                <th scope="col">Request Date: </th>
                                <th scope="col">Status: </th>
                            </tr>
                        </thead>
                        <tbody>
                            {allRecentTickets.map(u => {
                                return (<tr key={u.ticketId}>
                                    <th scope="row">{u.ticketId}</th>
                                    <td>{u.title}</td>
                                    <td>{typeof u.datePosted == 'string' ? u.datePosted : u.datePosted.toDateString()}</td>
                                    <td>{u.ticketStatus}</td>
                                </tr>)
                            })}
                        </tbody>
                    </table>
                </section>
                
                 {/* Recent Tickets Modal */}
                 <section>
                    {/* react-bootstrap components  */}
                   
                    <Modal show={modal1Visible} onHide={() => setModal1Visible(false)}>
                        <Modal.Header>
                            <Modal.Title>New User</Modal.Title>
                            
                        </Modal.Header>
                        <Modal.Body>
                        {allRecentTickets.map(u => {
                            return(
                                <Form>
                                <Form.Group>  
                                        <Form.Label># ID</Form.Label>
                                        <p> {u.ticketId} </p>
                                    </Form.Group>
                                    <Form.Group>
                                        <Form.Label>Employee</Form.Label>
                                        <p> {u.userFirstName} {u.userLastName} </p>
                                    </Form.Group>
                                    <Form.Group>
                                        <Form.Label>Content</Form.Label>
                                        <p> {u.message} </p>
                                    </Form.Group>
                                    <Form.Group>
                                        <Form.Label>Status:</Form.Label>
                                        <p> {u.ticketStatus} </p>
                                    </Form.Group>
                                        {allReplies.map(m => {
                                            return(
                                                <Form.Group>
                                                <Form.Label>Comments:</Form.Label>
                                                    <p> {m.timestamp} </p>
                                                    <p> {m.ticketPostId} </p>
                                                    <p> {m.userId} </p>
                                                    <p> {m.replies} </p>
                                                </Form.Group>)
                                            })}
                                    <Form.Group>
                                        <Form.Label> Accept:</Form.Label>
                                        <input value="3" onChange={(e) => setInputStatusID(+e.target.value) }  type="radio"  name="status"/>
                                    </Form.Group>
                                </Form>)
                        })}
                        </Modal.Body>
                        <Modal.Footer>
                            <Button onClick={() => setModal1Visible(false)}>Close</Button>
                            <Button onClick={() => updateTicket()}>Accept</Button>
                            <input value={inputTicketID} onChange={(e) => setInputTicketID(+e.target.value)} type="radio"/>
                            
                        </Modal.Footer>
                    </Modal>
                    
                </section>


                {/* Accepted Tickets */}
                <section>
                     {/* BootStrap Table */}
                    <header>
                        <h2 id="accounts-header" className="dark">Recent Tickets 
                            <button 
                                className="btn btn-success"
                                onClick={() => setModal2Visible(true)} /*OPEN MODAL HERE*/
                                >View</button>
                        </h2>
                    </header>

                    <table className="table table-striped">
                        <thead className="thead-dark">
                            <tr>
                                <th scope="col"># ID: </th>
                                <th scope="col">Post: </th>
                                <th scope="col">Request Date: </th>
                                <th scope="col">Status: </th>
                            </tr>
                        </thead>
                        <tbody>
                            {allAcceptedTickets.map(u => {
                                return (<tr key={u.ticketId}>
                                    <th scope="row">{u.ticketId}</th>
                                    <td>{u.title}</td>
                                    <td>{typeof u.datePosted == 'string' ? u.datePosted : u.datePosted.toDateString()}</td>
                                    <td>{u.ticketStatus}</td>
                                </tr>)
                            })}
                        </tbody>
                    </table>
                </section>
                
                 {/* Accepted Tickets Modal */}
                 <section>
                    {/* react-bootstrap components  */}
                    <Modal show={modal2Visible} onHide={() => setModal2Visible(false)}>
                        <Modal.Header>
                            <Modal.Title>New User</Modal.Title>
                        </Modal.Header>
                        <Modal.Body>
                            {allAcceptedTickets.map(u => {
                                return(
                                    <Form>
                                <Form.Group>  
                                        <Form.Label># ID</Form.Label>
                                        <p> {u.ticketId} </p>
                                    </Form.Group>
                                    <Form.Group>
                                        <Form.Label>Employee</Form.Label>
                                        <p> {u.userFirstName} {u.userLastName} </p>
                                    </Form.Group>
                                    <Form.Group>
                                        <Form.Label>Content</Form.Label>
                                        <p> {u.message} </p>
                                    </Form.Group>
                                    <Form.Group>
                                        <Form.Label>Status:</Form.Label>
                                        <p> {u.ticketStatus} </p>
                                    </Form.Group>
                                    {allReplies.map(m => {
                                        return(
                                            <Form.Group>
                                            <Form.Label>Comments:</Form.Label>
                                            <p> {m.timestamp} </p>
                                            <p> {m.ticketPostId} </p>
                                            <p> {m.userId} </p>
                                            <p> {m.replies} </p>
                                        </Form.Group>
                                        )
                                        
                                     })}
                                </Form>
                                )
                                
                            })}
                        </Modal.Body>
                        <Modal.Footer>
                            <Button onClick={() => setModal2Visible(false)}>Close</Button>
                            <Button onClick={() => updateTicket()}>Resolve</Button>
                            <input value={inputTicketID} onChange={(e) => setInputTicketID(+e.target.value)} type="radio"/>
                        </Modal.Footer>
                    </Modal>
                </section>




                {/* All Tickets Table */}
                <section>
                     {/* BootStrap Table */}
                    <header>
                        <h2 id="accounts-header" className="dark">All Tickets 
                        </h2>
                    </header>

                    <table className="table table-striped">
                        <thead className="thead-dark">
                            <tr>
                                <th scope="col">ID Ticket: </th>
                                <th scope="col">Description: </th>
                                <th scope="col">Admin</th>
                                <th scope="col">History</th>
                                <th scope="col">Poster</th>
                            </tr>
                        </thead>
                        <tbody>
                            {allTickets.map(u => {
                                return (<tr key={u.ticketId}>
                                    <td>{u.img}</td>
                                    <th scope="row">{u.ticketId}</th>
                                    <td>{u.title}</td>
                                    <td>{typeof u.datePosted == 'string' ? u.datePosted : u.datePosted.toDateString() }</td>
                                    <td>{u.userFirstName} {u.userLastName}</td>
                                </tr>)
                            })}
                        </tbody>
                    </table>
                </section>

                <section>logout</section>

            </main>
        </div>
    );
};