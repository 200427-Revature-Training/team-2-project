import React, { useState, useEffect } from 'react';
import './history.component.css';
import { Tickets } from '../../../../models/Tickets';
import * as employeeRemote from '../../../../remote/employee.remote';
import { Form, Modal, Button } from 'react-bootstrap';
import anim0 from '../../../../temppics/aa0.png';
import anim1 from '../../../../temppics/aa0.png';
import anim2 from '../../../../temppics/aa0.png';
import anim3 from '../../../../temppics/aa0.png';

const testPayload: Tickets[]  = [{
    ticketId: 1,
    title: 'A Post',
    datePosted: '12-12-12-12-12-12',
    dateResolved: '12-12-12-12-12-12',
    userFirstName: 'Joe',
    userLastName: 'Smith',
    userImage: 'image.png',
    message: 'asfasd',
    ticketStatus: 2,
    adminFirstName: "Bob",
    adminLastName: "Smith"
    }];

export const HistoryComponent: React.FC = () => {

    // See History Post
    const [historyPost, setHistoryPost] = useState<Tickets[]>([])
    
    const [modalVisible, setModalVisible] = useState(false); //Modal Set to default [Off]

    const [historyPostById, setHistoryPostById] = useState<Tickets>({
        ticketId: 0,
        title: '',
        datePosted: '',
        dateResolved: '',
        userFirstName: '',
        userLastName: '',
        userImage: 'Image.png',
        message: '',
        ticketStatus: 0,
        adminFirstName: '',
        adminLastName: ''
    });

    useEffect(() => {
        loadPosts();
    }, []);


    const loadPosts = () => {
        employeeRemote.getAllHistoryPosts().then(posts => {
            setHistoryPost(posts);
        });
    }

    /**View Ticket Button */
    const loadModal = (a: any)=> {
        setHistoryPostById(a); //load modal with ticket data
        setModalVisible(true); //Open Modal
    };

    return (
        /* This section will be on the right side of the page right under the new post button
            as seen on the main section of the employee dashboard wireframe.*/
        <div className='historyTable'>
            <section className='rightUnderBar'>
                <table>
                    {<thead>
                        {/* <tr>
                            <th scope="col"># ID: </th>
                            <th scope="col">Post: </th>
                            <th scope="col">Request Date: </th>
                            <th scope="col">Resolved Date: </th>
                            <th scope="col">Status: </th>
                        </tr> */}
                    </thead>}
                    <tbody>
                        {historyPost.map(a => {
                            return (
                              <div className="padBottom">
                                <tr key={a.ticketId}>
                                  <th scope="row">{a.ticketId}</th>
                                  <td>Title: {a.title}</td>
                                </tr>
                                <tr>
                                  <td>Date Posted:</td>
                                  <td>Date Resolved:</td>
                                </tr>
                                <tr>
                                  {/* <td>{typeof a.datePosted == 'string' ? a.datePosted : a.datePosted.toDateString()}</td>
                                    <td>{typeof a.dateResolved == 'string' ? a.dateResolved : a.dateResolved.toDateString()}</td> */}

                                  <td>{a.datePosted}</td>
                                  <td>{a.dateResolved}</td>
                                </tr>
                                <tr>
                                  <td>{a.ticketStatus}</td>
                                  <button
                                    className="btn btn-light"
                                    onClick={() => loadModal(a)}
                                  >
                                    View Past Ticket/Post
                                  </button>
                                </tr>
                              </div>
                            );
                        })}
                    </tbody>
                </table>
            </section>
            <section>
                {/* The modal below appears when the user clicks on the button
                above to see an individual post from the history post table.
                It should look more or less the same as the ones on the catgories pages. */}
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
                            <p> {historyPostById.ticketId} </p>
                        </Form.Group>
                        <Form.Group>
                            <Form.Label>Employee::</Form.Label>
                                <p> {historyPostById.userFirstName} {historyPostById.userLastName}</p>
                            </Form.Group>
                            <Form.Group>
                            <Form.Label>Title::</Form.Label>
                                <p> {historyPostById.title} </p>
                            </Form.Group>
                            <Form.Group>
                                <Form.Label>Content::</Form.Label>
                                <p> {historyPostById.datePosted} </p>
                            </Form.Group>
                            <Form.Group>
                                <Form.Label>Content::</Form.Label>
                                <p> {historyPostById.dateResolved} </p>
                            </Form.Group>
                            <Form.Group>
                                <Form.Label>Status::</Form.Label>
                                <p> {historyPostById.ticketStatus} </p>
                            </Form.Group>
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