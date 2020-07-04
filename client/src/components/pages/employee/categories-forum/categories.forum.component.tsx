import React, { useState } from 'react';
import './categories.forum.component.css';
import { CategoryAllComponent } from '../category-views/category-all/category.all.component';
import { CategoryPostComponent } from '../category-views/category-post/category.post.component';
import { CategoryPendingComponent } from '../category-views/category-pending/category.pending.component';
import { CategoryAcceptedComponent } from '../category-views/category-accepted/category.accepted.component';
import { CategoryResolvedComponent } from '../category-views/category-resolved/category.resolved.component';

// Take in views
export const childViews = {
    all: 'ALL',
    categoryPost: 'CATEGORY_POST',
    categoryPending: 'CATEGORY_PENDING',
    categoryAccepted: 'CATEGORY_ACCEPTED',
    categoryResolved: 'CATEGORY_RESOLVED'
};

// This component just takes in all the category views and loads them here.
export const CategoriesForumComponent: React.FC = () => {

    // View state is initialized here
    const [view, setView] =
        useState<'CATEGORY_POST' | 'CATEGORY_PENDING' | 'CATEGORY_ACCEPTED' | 'CATEGORY_RESOLVED' | 'ALL'>('ALL');
 
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
        <div className='marginLeft'>
            <header>
                <h2 id="accounts-header" className="dark">
                    Employee Dashboard
                </h2>
            </header>
            <main className='posts'>
                {getCurrentView()}
            </main>
        </div>
    )
}