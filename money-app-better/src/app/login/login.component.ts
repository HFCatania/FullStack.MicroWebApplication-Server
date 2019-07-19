import { Component, OnInit, Input } from '@angular/core';
import { User } from 'src/model/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  emailString: string = "what is in the email field will go here when you press test";

  @Input('loginStatus') loggedIn: boolean;

  user: User;

  constructor() { }

  ngOnInit() {
  }
login():void{
  let emailstring: string = (document.getElementById('email') as HTMLInputElement).value;
  let passwordstring: string = (document.getElementById('password') as HTMLInputElement).value;

  this.user = {id: '',
  firstName: '',
  lastName: '',
  userName: '',
  passwordHash: passwordstring,
  email: emailstring};

// next line needs to be directed to correct method for user login
// this.userService.createUser(this.user);
}



  login():void{
    this.emailString = (<HTMLInputElement>document.getElementById("email")).value;
  }

}