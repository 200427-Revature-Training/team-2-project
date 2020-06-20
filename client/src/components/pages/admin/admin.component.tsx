import React, { useEffect } from 'react';
import './admin.component.css';
import * as userRemote from '../../../remote/test.remote';
import { Administrator } from '../../../models/Administrators';
import { Modal, Button, Form } from 'react-bootstrap';

export const AdminComponent: React.FC = () => {
    const [administrator, setAdministrator] = useState<Administrator[]>([]); //Set data to page

    // const [inputReimbID, setInputeimbID] = useState(0);
    const [inputTicketID, setInputTicketID] = useState(0);
    const [inputAmount, setInputAmount] = useState(0);
    const [inputAmount, setInputAmount] = useState(0);
    const [inputAmount, setInputAmount] = useState(0);
    const [inputAmount, setInputAmount] = useState(0);

    const [modalVisible, setModalVisible] = useState(false); /**MODAL HERE */

    useEffect(() => {
        loadAdmins();   
    }, [])

    const addUser = async () => {
        const payload = { //!Change schema properties here
            ticket_id: number; 
            description: string;
            adminName: string;
            resolvedDate: Date | string;
            employeeName: string;

            // reimbId: inputReimbID,
            amount: inputAmount,
            sumitDate: inputSumitDate
        };

        await userRemote.updateStatus(payload);  /**SEND REQUEST HERE */
        // setInputeimbID(''); //clear fields
        setInputAmount(0); //clear fields
        setInputSumitDate(''); 
        

        setModalVisible(false) /*CLOSE HERE*/

        loadAdmins(); /**GET REQUEST HERE */
    }

    const loadAdmins = () => {  /**REFRESH PAGE HERE */
        userRemote.getAllTicketTable().then(administrator => {
            setAdministrator(administrator);
        });        
    };
    
    return (
        <div>
            {/* NavPanel */}
            <nav> NavPanel Here</nav>
            <main>
                {/* Recent Tickets */}
                <section> Recent Tickets</section>
                
                {/* All Tickets Table */}
                <section>
                    ///test table
                     {/* BootStrap Table */}
            <header>
                <h2 id="accounts-header" className="dark">Accounts Section 
                    <button 
                        className="btn btn-success"
                        onClick={() => setModalVisible(true)} /*OPEN MODAL HERE*/
                        >Add Person</button>
                </h2>
            </header>

            <table className="table table-striped">
                <thead className="thead-dark">
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Amount</th>
                        <th scope="col">Submission</th>
                        <th scope="col">Resolved</th>
                        <th scope="col">Description</th>
                        <th scope="col">First Name</th>
                        <th scope="col">Last Name</th>
                        <th scope="col">Status</th>
                        <th scope="col">type</th>
                    </tr>
                </thead>
                <tbody>
                    {administrator.map(u => {
                        return (<tr key={u.reimbId}>
                            <th scope="row">{u.reimbId}</th>
                            <td>{u.amount}</td>
                            <td>{typeof u.sumitDate == 'string' ? u.sumitDate : u.sumitDate.toDateString()}</td>
                            <td>{typeof u.resolvedDate == 'string' ? u.resolvedDate : u.resolvedDate.toDateString()}</td>
                            <td>{u.description}</td>
                            <td>{u.authorId}</td>
                            <td>{u.resolverId}</td>
                            <td>{u.statusId}</td>
                            <td>{u.type}</td>
                        </tr>)
                    })}
                </tbody>
            </table>
                </section>

                {/* Modal */}
                <section>
                    {/* react-bootstrap components  */}
                    <Modal show={modalVisible} onHide={() => setModalVisible(false)}>
                        <Modal.Header>
                            <Modal.Title>New User</Modal.Title>
                        </Modal.Header>
                        <Modal.Body>
                            <Form>
                            {/* <Form.Group>  
                                    <Form.Label> ReimbID:::</Form.Label>
                                    <Form.Control type="number" value={inputReimbID} onChange={(e) => setInputeimbID(+e.target.value) } />
                                </Form.Group> */}
                                <Form.Group>
                                    <Form.Label> Amount:</Form.Label>
                                    <Form.Control type="number" value={inputAmount} onChange={(e) => setInputAmount(+e.target.value) } />
                                </Form.Group>
                                <Form.Group>
                                    <Form.Label>Submission:</Form.Label>
                                    <Form.Control type="date" value={inputSumitDate} onChange={(e) => setInputSumitDate(e.target.value) } />
                                </Form.Group>
                                <Form.Group>
                                    <Form.Label>resolved::</Form.Label>
                                    <Form.Control type="date" value={inputResolvedDate} onChange={(e) => setInputResolvedDate(e.target.value) } />
                                </Form.Group>
                                <Form.Group>
                                    <Form.Label>Description:</Form.Label>
                                    <Form.Control type="text" value={inputDescription} onChange={(e) => setInputDescription(e.target.value) } />
                                </Form.Group>
                                <Form.Group>
                                    <Form.Label>Reciept:</Form.Label>
                                    <Form.Control type="text" value={inputReciept} onChange={(e) => setInputReciept(e.target.value) } />
                                </Form.Group>
                                <Form.Group>
                                    <Form.Label>authorId::</Form.Label>
                                    <Form.Control type="number" value={inputAuthorID} onChange={(e) => setInputAuthorID(+e.target.value) } />
                                </Form.Group>
                                <Form.Group>
                                    <Form.Label>resolverId::</Form.Label>
                                    <Form.Control type="number" value={inputResolverID} onChange={(e) => setInputResolverID(+e.target.value) } />
                                </Form.Group>
                                <Form.Group>
                                    <Form.Label>statusId::</Form.Label>
                                    <Form.Control type="number" value={inputStatusID} onChange={(e) => setInputStatusID(+e.target.value) } />
                                </Form.Group>
                                <Form.Group>
                                    <Form.Label>Type:</Form.Label>
                                    <Form.Control type="number" value={inputType} onChange={(e) => setInputType(+e.target.value) } />
                                </Form.Group>
                            </Form>
                        </Modal.Body>
                        <Modal.Footer>
                            <Button onClick={() => setModalVisible(false)}>Close</Button>
                            <Button onClick={() => addUser()}>Submit</Button>
                        </Modal.Footer>
                    </Modal>
                </section>
            </main>
        </div>
    );
};