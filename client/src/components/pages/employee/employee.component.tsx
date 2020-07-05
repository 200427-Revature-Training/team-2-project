import React from 'react';
import '../employee/employee.component.css';
import { CategoriesForumComponent } from '../employee/categories-forum/categories.forum.component';
import { HistoryComponent } from '../employee/history/history.component';
import { NewPostComponent } from '../employee/new-post/new.post.component';

export const EmployeeComponent:React.FC = () => {

    return (
        <div className='bgColor'>
            <section className='rightColumn'>
                <NewPostComponent />
                <HistoryComponent />
            </section>
            <section>
                <CategoriesForumComponent />
            </section>
        </div>
    )
}