import React, { useState, useEffect } from 'react';
import './categories.forum.component.css';
import * as employeeRemote from '../../../../remote/employee.remote';
import { CategoryAllComponent } from '../category-views/category-all/category.all.component';
import { CategoryPostComponent } from '../category-views/category-post/category.post.component';
import { CategoryPendingComponent } from '../category-views/category-pending/category.pending.component';
import { CategoryAcceptedComponent } from '../category-views/category-accepted/category.accepted.component';
import { CategoryResolvedComponent } from '../category-views/category-resolved/category.resolved.component';
import { CategoryListComponent } from '../category-views/category-list/category.list.component';
import { Tickets } from '../../../../models/Tickets';
import { Replies } from '../../../../models/Replies';
import { Modal, Button, Form, Card } from 'react-bootstrap';

/*  Take render functions and the category component props and put them into a category list component.
    Implement the render functions in the category list component.
*/


// take in views
export const childViews = {
    all: 'ALL',
    categoryPost: 'CATEGORY_POST',
    categoryPending: 'CATEGORY_PENDING',
    categoryAccepted: 'CATEGORY_ACCEPTED',
    categoryResolved: 'CATEGORY_RESOLVED'
};

// interface CategoryComponentProps {
//     view: (str: 'ALL' | 'CATEGORY_POST' | 'CATEGORY_PENDING' | 'CATEGORY_ACCEPTED' | 'CATEGORY_RESOLVED') => void;
// };

export const CategoriesForumComponent: React.FC = () => {

    // second part for categories
    const [view, setView] =
        useState<'CATEGORY_POST' | 'CATEGORY_PENDING' | 'CATEGORY_ACCEPTED' | 'CATEGORY_RESOLVED' | 'ALL'>('ALL');
 
    // Passing DOWN the data to the parent, no need to pass back up the tree
    // Put in 
    // Put each seperate component into the switch statement
    // Put the List component in 

    // Stateless component - or a functional component
    const getCurrentView = () => {
          // Returning a view based on the value of the state 'view'
          switch (view) {
            case childViews.all: return <CategoryAllComponent setView = {setView}/>
            case childViews.categoryPost: return <CategoryPostComponent setView = {setView}/>
            case childViews.categoryPending: return <CategoryPendingComponent  setView = {setView}/>
            case childViews.categoryAccepted: return <CategoryAcceptedComponent  setView = {setView}/>
            case childViews.categoryResolved: return <CategoryResolvedComponent setView = {setView}/>
            default: return <CategoryAllComponent setView = {setView}/>
        }
    }

    return (
        <div>
            <header>
                <h2 id="accounts-header" className="dark">
                    Employee Dashboard
                </h2>
            </header>
            <main>
                {getCurrentView()}
            </main>
        </div>
    )
}

// Test objects if data is needed
// const testTicketsPost: Tickets[] = [{ 
//     ticketId: 1,
//     title: 'title',
//     datePosted: '12-12-12-12-12-12',
//     dateResolved: '12-12-12-12-12-12',
//     userFirstName: 'first',
//     userLastName: 'last',
//     img: undefined, //!implement img storage
//     message: 'message',
//     ticketStatus: 0,
//     adminId: 1
// }];

// const testTicketsPending: Tickets[] = [{
//         ticketId: 2,
//         title: 'title',
//         datePosted: '12-12-12-12-12-12',
//         dateResolved: '12-12-12-12-12-12',
//         userFirstName: 'first',
//         userLastName: 'last',
//         img: undefined, //!implement img storage
//         message: 'message',
//         ticketStatus: 1,
//         adminId: 1
// }];

// const testTicketsAccepted: Tickets[] = [{
//     ticketId: 3,
//     title: 'title',
//     datePosted: '12-12-12-12-12-12',
//     dateResolved: '12-12-12-12-12-12',
//     userFirstName: 'first',
//     userLastName: 'last',
//     img: undefined, //!implement img storage
//     message: 'message',
//     ticketStatus: 2,
//     adminId: 1
// }];

// const testTicketsResolved: Tickets[] = [{
//     ticketId: 4,
//     title: 'title',
//     datePosted: '12-12-12-12-12-12',
//     dateResolved: '12-12-12-12-12-12',
//     userFirstName: 'first',
//     userLastName: 'last',
//     img: undefined, //!implement img storage
//     message: 'message',
//     ticketStatus: 3,
//     adminId: 1
// }];

// const testTicketsAll: Tickets[] = [
//     { 
//         ticketId: 1,
//         title: 'title',
//         datePosted: '12-12-12-12-12-12',
//         dateResolved: '12-12-12-12-12-12',
//         userFirstName: 'first',
//         userLastName: 'last',
//         img: undefined, //!implement img storage
//         message: 'message',
//         ticketStatus: 0,
//         adminId: 1
//     },
//     {
//         ticketId: 2,
//         title: 'title',
//         datePosted: '12-12-12-12-12-12',
//         dateResolved: '12-12-12-12-12-12',
//         userFirstName: 'first',
//         userLastName: 'last',
//         img: undefined, //!implement img storage
//         message: 'message',
//         ticketStatus: 1,
//         adminId: 1
//     },
//     {
//         ticketId: 3,
//         title: 'title',
//         datePosted: '12-12-12-12-12-12',
//         dateResolved: '12-12-12-12-12-12',
//         userFirstName: 'first',
//         userLastName: 'last',
//         img: undefined, //!implement img storage
//         message: 'message',
//         ticketStatus: 2,
//         adminId: 1
//     },
//     {
//     ticketId: 4,
//     title: 'title',
//     datePosted: '12-12-12-12-12-12',
//     dateResolved: '12-12-12-12-12-12',
//     userFirstName: 'first',
//     userLastName: 'last',
//     img: undefined, //!implement img storage
//     message: 'message',
//     ticketStatus: 3,
//     adminId: 1
// }];

// const [ticketsAll, setTicketsAll] = useState<Tickets[]>(testTicketsAll);
    // const [ticketsPost, setTicketsPost] = useState<Tickets[]>(testTicketsPost);
    // const [ticketsPending, setTicketsPending] =useState<Tickets[]>(testTicketsPending);
    // const [ticketsAccepted, setTicketsAccepted] = useState<Tickets[]>(testTicketsAccepted);
    // const [ticketsResolved, setTicketsResolved] = useState<Tickets[]>(testTicketsResolved);

    // Populate Posts
// const [allPosts, setAllPosts] = useState<Tickets[]>([]);
 
// // Show Replies
// const [showReplies, setShowReplies] = useState<Replies[]>([]);

// // Modal to see post
// const [showModal, setShowModal] = useState(false);

// useEffect(() => {
//     loadPosts();
// }, []);

// const loadPosts = () => {
//         employeeRemote.getAllPosts().then(posts => {
//             setAllPosts(posts);
//         });
//     };

// const loadReplies = () => {
//     employeeRemote.getAllReplies().then(posts => {
//         setShowReplies(posts);
//     });
// }   