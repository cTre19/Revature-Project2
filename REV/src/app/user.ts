export class User {

    firstName: string;
    lastName: string;
    email: string;
    password: string;
    city: string;
    state: string;
    client: string;
    batch_id: number;
    position: string;

    constructor(email: string, pass: string) {
        this.email = email;
        this.password = pass;
    }

}
