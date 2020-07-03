import React from 'react';
import './admin.component.css';
import { NavPanelComponent } from './nav-panel/nav-panel.component';
import { AllTicketsComponent } from './all/all-tickets.component';
import { RecentTicketsComponent } from './recent/recent-ticket.component';
import { AcceptedTicketsComponent } from './accepted/accepted-tickets.component';


export const AdminComponent: React.FC = () => {
    
    return (
        <div className='primary'>

            <div className='nav'>
                <NavPanelComponent />
            </div>
            
            <div className='main'>
                <RecentTicketsComponent />

                <AcceptedTicketsComponent />

                <AllTicketsComponent />
            </div>
        </div>
    );
};