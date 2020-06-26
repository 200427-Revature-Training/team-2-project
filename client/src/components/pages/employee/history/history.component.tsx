import React, { useState } from 'react';
import './history.component.css';
import { Tickets } from '../../../../models/Tickets';
import { HistoryPost } from '../../../../models/employee/HistoryPost';

export const HistoryComponent: React.FC = () => {

    // See History Post
    const [historyPost, setHistoryPost] = useState<HistoryPost[]>([]);

    return (
        <div>
            History post goes here.
        </div>
    )
}