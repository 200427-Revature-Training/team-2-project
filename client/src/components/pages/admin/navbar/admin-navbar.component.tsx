import React, { useEffect, useState } from 'react';
import { Link, withRouter, RouteComponentProps } from 'react-router-dom';
import './admin-navbar.component.css';
import { Tickets } from '../../../../models/Tickets';
import * as adminRemote from '../../../../remote/admin.remote';
import anim0 from '../../../../temppics/aa0.png';
import { useHistory } from 'react-router';


const testPayload = [{
    ticketId: 1,
    title: 'title',
    datePosted: '12-12-1220',
    dateResolved: '12-12-1220',
    userFirstName: 'Andrew',
    userLastName: 'Adminguy',
    userImage: anim0, //!implement img storage
    message: 'message',
    ticketStatus: 1,
    adminId: 1
}];

const NavbarComponent: React.FC<RouteComponentProps> = (props) => {
    
    const history = useHistory(); // Access history for redirect

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

    const logOut = () => {
        // localStorage.removeItem('accessToken');
        localStorage.clear();
        history.push('/');
    }

    
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
            <h1 className="departmentName">Ask IT</h1>
            <section className='breakout'>
                {/* <a href='../'>
                    <div className="button left">Logout</div>
                </a> */}
                <div className="button left" onClick={() => logOut()}>Logout</div>

                <div className="right">
                    {/**Remove mapping */} {testPayload.map(u => {
                        return (
                            <tr key={u.ticketId}>
                                <td className="imgTD"><img src={u.userImage} width="50.5%" alt='0' /></td> {/* <td className="imgTD"><img src={localStorage.getItem('userImage')} width="50.5%" alt='0'</td> */} 
                                <tr>
                                    <td className='top'>{u.userFirstName}&nbsp;{u.userLastName}</td> {/* <td className='top'>{localStorage.getItem('firstName')}&nbsp;{localStorage.getItem('lastName')}</td> */}
                                </tr>
                                <tr>
                                    <td className='bottom'>Web Admin</td>
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