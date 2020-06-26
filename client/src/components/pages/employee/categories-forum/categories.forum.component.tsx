import React, { useState, useEffect } from 'react';
import './categories.forum.component.css';
import * as employeeRemote from '../../../../remote/employee.remote';
import { Tickets } from '../../../../models/Tickets';
import { Replies } from '../../../../models/Replies';
import { Categories } from '../../../../models/employee/Categories';
import { Modal, Button, Form, Card } from 'react-bootstrap';

// Test object if data is needed
const testPayload = [{ 
    ticketId: 1,
    title: 'title',
    datePosted: '12-12-12-12-12-12',
    dateResolved: '12-12-12-12-12-12',
    userFirstName: 'first',
    userLastName: 'last',
    img: 'image.png', //!implement img storage
    message: 'message',
    ticketStatus: 1,
    adminId: 1
},
{
    ticketId: 2,
    title: 'title',
    datePosted: '12-12-12-12-12-12',
    dateResolved: '12-12-12-12-12-12',
    userFirstName: 'first',
    userLastName: 'last',
    img: 'image.png', //!implement img storage
    message: 'message',
    ticketStatus: 2,
    adminId: 1
}
];


const categories = [{
    tid: 1,
    ticketStatus: 2
}];

export const CategoriesForumComponent: React.FC = () => {

    // Category Filter
    const [filterCategory, setFilterCategory] = useState(0);

    // Show Replies
    const [showReplies, setShowReplies] = useState<Replies[]>([]);

    // Populate Posts
    const [allPosts, setAllPosts] = useState<Tickets[]>([]);

    // Modal to see post
    const [showModal, setShowModal] = useState(false);

    useEffect(() => {
        loadPosts();
    }, []);
    
    const filterByCategory = async (category: number) => {
        setFilterCategory(category);
        };

    const loadPosts = () => {
            employeeRemote.getAllPosts().then(posts => {
                setAllPosts(posts);
            });
        };

    const loadReplies = () => {
        employeeRemote.getAllReplies().then(posts => {
            setShowReplies(posts);
        });
    }

    return (
        <div>
            <header>
                <h2 id="accounts-header" className="dark">
                    Employee Dashboard 
                </h2>
            </header>
            <Form>
                <Form.Label>Regular Post</Form.Label>
                <input value={0} onChange={(e) => setFilterCategory(+e.target.value)} type="radio" name="category" /> 

                <Form.Label>Ticket Pending</Form.Label>
                <input value={1} onChange={(e) => setFilterCategory(+e.target.value)} type="radio" name="category" />

                <Form.Label>Ticket Accepted</Form.Label>
                <input value={2} onChange={(e) => setFilterCategory(+e.target.value)} type="radio" name="category" />

                <Form.Label>Ticket Resolved</Form.Label>
                <input value={3} onChange={(e) => setFilterCategory(+e.target.value)} type="radio" name="category" />
                <Card>
                    {testPayload.map(u =>{
                        return(
                            <Card.Body>
                                <Card.Title>{u.title}</Card.Title>
                                <Card.Subtitle>{u.img}</Card.Subtitle>
                                <Card.Subtitle>{u.userFirstName} {u.userLastName}</Card.Subtitle>
                                <Card.Subtitle>{u.datePosted} {u.dateResolved}</Card.Subtitle>
                                <Card.Subtitle>{u.ticketStatus}</Card.Subtitle>
                                <Card.Text>{u.message}</Card.Text>
                            </Card.Body>
                        )
                    })}
                </Card>
            </Form>
        </div>
    )
}