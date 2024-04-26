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

export class Utilisateur {
    public id?: number;
    public nom?: string;
    public prenom?: string;
    public login?: string;
    public password?: string;
    public disabled?: boolean;

    constructor(id?: number, nom?: string, prenom?: string,  login?: string, password?: string, disabled?: boolean) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom ;
        this.login = login;
        this.password = password;
        this.disabled = disabled;
    }
}

export class Liste {
    id?: number;
    nom?: string;
    todos: Array<Todo> = new Array<Todo>();

    constructor(id?: number, nom?: string) {
        this.id = id;
        this.nom = nom;
    }
}
