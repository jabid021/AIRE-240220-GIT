export class Todo {
    public id?: number;
    public title?: string;
    public completed?: boolean;
    public userId?: number;

    constructor(id?: number, title?: string, completed?: boolean,  userId?: number) {
        this.id = id;
        this.title = title;
        this.completed = completed ;
        this.userId = userId;
    }
}