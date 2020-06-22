export interface Posts {
    postId: number;
    userFirstName?: string,
    userLastName?: string,
    title?: string;
    message?: string;
    statusID: number;
    datePosted: Date | string;
    dateResolved: Date | string;
    adminFirstName?: string;
    adminLastName?: string;
}