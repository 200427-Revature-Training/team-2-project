export class PostForum {
    postId: number;
    userFirstName: string;
    userLastName: string;
    title: string;
    message: string;
    statusId: number;
    datePosted: Date | string;
    dateResolved: Date | string;
    adminId: number

    static from(obj:PostForumRow): PostForum {
        const postForum = new PostForum(
            obj.card_id,
            obj.first_name,
            obj.last_name,
            obj.title,
            obj.message,
            obj.ticket_status,
            new Date(obj.entry_time),
            new Date(obj.date_resolved),
            obj.admin_id
        );
        return postForum;
    }

    constructor(
        postId: number,
        userFirstName: string,
        userLastName: string,
        title: string,
        message: string,
        statusId: number,
        datePosted: Date,
        dateResolved: Date,
        adminId: number
    )
    {
    this.postId = postId;
    this.userFirstName = userFirstName;
    this.userLastName = userLastName;
    this.title = title;
    this.message = message;
    this.statusId = statusId;
    this.datePosted = datePosted;
    this.dateResolved = dateResolved;
    this.adminId = adminId;
    }
}

export interface PostForumRow {
    card_id: number;
    first_name: string,
    last_name: string,
    title: string;
    message: string;
    ticket_status: number;
    entry_time: Date | string;
    date_resolved: Date | string;
    admin_id: number;
}