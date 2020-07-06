import React, { useEffect, useState } from 'react';
import './all-tickets.component.css';
import { Tickets } from '../../../../models/Tickets';
import * as adminRemote from  '../../../../remote/admin.remote';
import anim0 from '../../../../temppics/aa0.png';
import anim1 from '../../../../temppics/aa1.png';
import anim2 from '../../../../temppics/aa2.png';
import anim3 from '../../../../temppics/aa3.png';

//Test Object if server not working
const testPayload = [{ 
    ticketId: 1,
    title: 'title',
    datePosted: '12-12-1220',
    dateResolved: '12-12-1220',
    userFirstName: 'first',
    userLastName: 'last',
    userImage: <img src={anim0} width="50.5%" alt='0' />, //!implement img storage
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
    userImage: <img src={anim1} width="50.5%" alt='0' />, //!implement img storage
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
    userImage: <img src={anim2} width="50.5%" alt='0' />, //!implement img storage
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
    userImage: <img src={anim3} width="50.5%" alt='0' />, //!implement img storage
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

export const AllTicketsComponent: React.FC = ()=> {

    // All tickets from Global Model
    const [allTickets, setAllTickets] = useState<Tickets[]>([]);

    useEffect(() => {
        loadTables(); //Refresh page   
    }, [])

    /**Load ticket-card data */ 
    const loadTables = () => { 
        adminRemote.getAllTickets().then(tickets => {
            setAllTickets(tickets);
        });
    };

    return(
        <div>
        <h2 id="accounts-header" className="dark">
            All Tickets 
        </h2>
        <div className='fullTable'>
            <h2 className="history">
                History
            </h2>
            <section>
                 {/* NOTE: Using BootStrap Table for testing.
                Replace table to best reflect wireframe table.
                Data should be populating from global Ticket.ts model as its currently doing so now */}
                <header>
                </header>
                <table className="alternating table-striped">
                    <tbody>
                        {allTickets.map(u => {
                            return (
                                <tr key={u.ticketId}>
                                    <td className="imgTD">{<img src={u.userImage} width="50.5%" alt='0' />}</td>
                                    {/* <td className="imgTD">{u.userImage}</td> */}
                                    <tr className="top">
                                        <td className="first">ID Ticket:</td>
                                        <td className="second">| {u.ticketId}</td>
                                        <td className="first">Admin:</td>
                                        <td className="second">| {u.userFirstName}</td>
                                        <td className="first">History:</td>
                                        <td className="second">| {u.datePosted}</td>
                                        <td className="first">Poster:</td>
                                        <td className="second">| {u.userFirstName}</td>
                                    </tr>
                                    <tr className="bottom">
                                        <td className="first">Description:</td>
                                        <td className="second long">| {u.title}</td>
                                        <td className="first"></td>
                                        <td className="second">| {u.userLastName}</td>
                                        <td className="first"></td>
                                        <td className="second"></td>
                                        <td className="first"></td>
                                        <td className="second">| {u.userLastName}</td>
                                    </tr>
                                </tr>
                            )
                        })}
                    </tbody>
                </table>

                <br />

                {/* <table className="table table-striped">
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
                        {testPayload.map(u => {
                            return (<tr key={u.ticketId}>
                                <td>{u.img}</td>
                                <th scope="row">{u.ticketId}</th>
                                <td>{u.title}</td>
                                { *//* <td>{typeof u.datePosted == 'string' ? u.datePosted : u.datePosted.toDateString()}</td> *//* }</section>
                                <td>{u.userFirstName} {u.userLastName}</td>
                                </tr>
                            )
                        })}
                    </tbody>
                </table> */}
            </section>
        </div>
        </div>
    );
};
