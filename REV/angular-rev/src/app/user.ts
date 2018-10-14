export class User {

    firstName: string;
    lastName: string;
    email: string;
    password: string;
    city: string;
    state: string;
    clientCompany: string;
    batchId: number;
    position: string;

    constructor(first: string, last: string, email: string, pass: string, city: string, state: string,
         client: string, batch: number, pos: string) {
             this.firstName = first;
             this.lastName = last;
             this.email = email;
             this.password = pass;
             this.city = city;
             this.state = state;
             this.clientCompany = client;
             this.batchId = batch;
             this.position = pos;
    }
}
