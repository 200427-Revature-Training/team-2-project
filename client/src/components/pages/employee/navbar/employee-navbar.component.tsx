import React, { useEffect, useState } from 'react';
import { Link, withRouter, RouteComponentProps } from 'react-router-dom';
import './employee-navbar.component.css';
import { Tickets } from '../../../../models/Tickets';
import * as adminRemote from '../../../../remote/admin.remote';
import anim0 from '../../../../temppics/aa0.png';


const testPayload = [{
    ticketId: 1,
    title: 'title',
    datePosted: '12-12-1220',
    dateResolved: '12-12-1220',
    userFirstName: 'Erin',
    userLastName: 'Employeelady',
    img: <img src={anim0} width="50.5%" alt='0' />, //!implement img storage
    message: 'message',
    ticketStatus: 1,
    adminId: 1
}];

const NavbarComponent: React.FC<RouteComponentProps> = (props) => {

    const renderOnCurrentPath = (path: string) => {
        console.log(props.location.pathname);
    };

    const [adminInfo, setAdminInfo] = useState<Tickets[]>([]);

    useEffect(() => {
        loadTables(); //Refresh page   
    }, [])

    /**Load ticket-card data */
    const loadTables = () => {
        adminRemote.getAllTickets().then(tickets => {
            setAdminInfo(tickets);
        });
    };

    
    return (
        <div className="infoStrip">
            {/* <nav className="navbar navbar-dark bg-primary">
                <a className="navbar-brand" href="#">Bank of Money</a>
                <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarNav">
                    <ul className="navbar-nav">
                        <li className="nav-item">
                            <Link to="/template">Template {renderOnCurrentPath('/template') }</Link>
                        </li>
                    </ul>
                </div>
            </nav> */}
        
            <section className='breakout'>
                <a href='../'>
                    <div className="button left">Logout</div>
                </a>
                <div className="right">
                    {testPayload.map(u => {
                        return (
                            <tr key={u.ticketId}>
                                <td className="imgTD">{u.img}</td>
                                <tr>
                                    <td className='top'>{u.userFirstName}&nbsp;{u.userLastName}</td>
                                </tr>
                                <tr>
                                    <td className='bottom'>Employee</td>
                                </tr>
                            </tr>
                        )
                    })}
                </div>
            </section>
            
        </div>
   );
};
export default withRouter(NavbarComponent);