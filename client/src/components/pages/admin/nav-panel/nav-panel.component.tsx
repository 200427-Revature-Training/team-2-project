import React from 'react';
import './nav-panel.component.css';
import { faHome, faChartLine, faCalendar, faBusinessTime, faCog } from "@fortawesome/free-solid-svg-icons";
import { FontAwesomeIcon } from "@fortawesome/react-fontawesome";

//NavPanel Here
export const NavPanelComponent: React.FC = () => {

    return (

        <div className='centerize'>
            <a href='./'>
                <div className='button'>
                    New Ticket
                </div>
            </a>
            <div className='button-dashboard'>
                <FontAwesomeIcon icon={faHome} />
                Dashboard
            </div>
            <div>
                <p className="links">
                <FontAwesomeIcon icon={faCalendar} />
                    Calendar
                    <br />
                    <br />
                    <FontAwesomeIcon icon={faBusinessTime} />
                    Timeline
                    <br />
                    <br />
                    <FontAwesomeIcon icon={faChartLine} />
                    Activity Log
                    <br />
                    <br />
                    <FontAwesomeIcon icon={faCog} />
                    Settings
                </p>  
            </div>
        </div>
                
        
    );
};