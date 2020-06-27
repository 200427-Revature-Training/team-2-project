import React, { useState, useEffect } from 'react';
import './history.component.css';
// import { Tickets } from '../../../../models/Tickets';
import { HistoryPost } from '../../../../models/employee/HistoryPost';
import * as employeeRemote from '../../../../remote/employee.remote';
import { Modal, Button } from 'react-bootstrap';

const testPayload = [{
    userId: 1,
    ticketId: 1,
    title: 'A Post',
    datePosted: new Date(),
    dateResolved: new Date(),
    ticketStatus: 2
}]

export const HistoryComponent: React.FC = () => {

    // See History Post
    const [historyPost, setHistoryPost] = useState<HistoryPost[]>([])
    const [modalVisible, setModalVisible] = useState(false); //Modal Set to default [Off]

    useEffect(() => {
        loadTables();
    }, [])

    const loadTables = () => {
        employeeRemote.getAllHistoryPosts().then(posts => {
            setHistoryPost(posts);
        })
    }
    /**View Ticket Button */
    const loadModal = (a: any)=> {
        setHistoryPost(a); //load modal with ticket data
        setModalVisible(true); //Open Modal
    };

    return (
        <div>
            <section>
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
                        {testPayload.map(a => {
                            return (
                            <tr key={a.ticketId}>
                                <th scope="row">{a.ticketId}</th>
                                <td>{a.title}</td>
                                <td>{typeof a.datePosted == 'string' ? a.datePosted : a.datePosted.toDateString()}</td>
                                <td>{typeof a.dateResolved == 'string' ? a.dateResolved : a.dateResolved.toDateString()}</td>
                                <td>{a.ticketStatus}</td>  
                                <button className="btn btn-success"
                                    onClick={() => loadModal(a)}>
                                    View Past Ticket/Post
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
                        <table>
                            <thead>
                                <tr>
                                    <th scope="col"># ID: </th>
                                    <th scope="col">Post: </th>
                                    <th scope="col">Request Date: </th>
                                    <th scope="col">Date Resolved: </th>
                                    <th scope="col">Status: </th>
                                </tr>
                            </thead>
                            <tbody>
                                {testPayload.map(a => {
                                    return (
                                    <tr key={a.ticketId}>
                                        <th scope="row">{a.ticketId}</th>
                                        <td>{a.title}</td>
                                        <td>{typeof a.datePosted == 'string' ? a.datePosted : a.datePosted.toDateString()}</td>
                                        <td>{typeof a.dateResolved == 'string' ? a.dateResolved : a.dateResolved.toDateString()}</td>
                                        <td>{a.ticketStatus}</td>
                                    </tr>
                                    )
                                })}      
                            </tbody>
                        </table>
                        <Modal.Footer>
                            <Button onClick={() => setModalVisible(false)}>Close</Button>
                        </Modal.Footer>
                    </Modal.Body>
                </Modal>
            </section>    
        </div>
    )
}