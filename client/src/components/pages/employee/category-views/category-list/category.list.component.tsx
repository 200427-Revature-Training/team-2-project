import React from 'react';
import { Tickets } from '../../../../../models/Tickets';
import { CategoryAllComponent } from '../category-all/category.all.component';
import { CategoryPostComponent } from '../category-post/category.post.component';
import { CategoryPendingComponent } from '../category-pending/category.pending.component';
import { CategoryAcceptedComponent } from '../category-accepted/category.accepted.component';
import { CategoryResolvedComponent } from '../category-resolved/category.resolved.component';
import './category.list.component.css';
import { ButtonGroup, Button } from 'react-bootstrap';
// import { updateTicketStatus } from '../../../../../remote/admin.remote';

// Move to category forum
interface CategoryListComponentProps {
    setView: (str: 'ALL' | 'CATEGORY_POST' | 'CATEGORY_PENDING' | 'CATEGORY_ACCEPTED' | 'CATEGORY_RESOLVED') => void;
    tickets: Tickets[];
}

export const CategoryListComponent: React.FC<CategoryListComponentProps> = (props) => {

    // const renderAllCategoryComponent = () => {
    //     return props.tickets.map(ticket => {
    //         return (<CategoryAllComponent key={ticket.ticketStatus} ticket={ticket} />)
    //     })
    // }

    // // move to post component
    // const renderPostCategoryComponent = () => {
    //     return props.tickets.map(ticket => {
    //         return (<CategoryPostComponent key={ticket.ticketStatus} ticket={ticket} />)
    //     })
    // }

    // const renderPendingCategoryComponent = () => {
    //     return props.tickets.map(ticket => {
    //         return (<CategoryPendingComponent key={ticket.ticketStatus} ticket={ticket} />)
    //     })
    // }

    // const renderAcceptedCategoryComponent = () => {
    //     return props.tickets.map(ticket => {
    //         return (<CategoryAcceptedComponent key={ticket.ticketStatus} ticket={ticket} />)
    //     })
    // }

    // const renderResolvedCategoryComponent = () => {
    //     return props.tickets.map(ticket => {
    //         return (<CategoryResolvedComponent key={ticket.ticketStatus} ticket={ticket} />)
    //     })
    // }

// employee remote get by id (equal to status id) 

    return(
        <div>
            <ButtonGroup aria-label="Basic example">
                <Button variant="secondary" onClick={() => props.setView('ALL')}>All</Button>
                <Button variant="secondary" onClick={() => props.setView('CATEGORY_POST')}>Post</Button>
                <Button variant="secondary" onClick={() => props.setView('CATEGORY_PENDING')}>Pending</Button>
                <Button variant="secondary" onClick={() => props.setView('CATEGORY_ACCEPTED')}>Accepted</Button>
                <Button variant="secondary" onClick={() => props.setView('CATEGORY_RESOLVED')}>Resolved</Button>
            </ButtonGroup>
            <section>
                {renderAllCategoryComponent()}
            </section>
            <section>
                {/* {props.setView('CATEGORY_POST') ?
                    renderPostCategoryComponent() : renderAllCategoryComponent()} */}
                {renderPostCategoryComponent()}
            </section>
            <section>
                {renderPendingCategoryComponent()}
            </section>
            <section>
                {renderAcceptedCategoryComponent()}
            </section>
            <section>
                {renderResolvedCategoryComponent()}
            </section>
        </div>
    )
}