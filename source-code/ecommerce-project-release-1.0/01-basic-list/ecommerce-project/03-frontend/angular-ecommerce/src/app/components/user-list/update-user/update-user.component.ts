import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Users } from 'src/app/common/users';
import { UserService } from 'src/app/services/user.service';
import { HttpClient } from '@angular/common/http';
import { Roles } from 'src/app/common/roles';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
})
export class UpdateUserComponent implements OnInit {
  @Input() props: any;

  user: any;
  role:any;
  // user: Users = new Users(0, '', '', '', '', '', false, []);
  errorMessage: String = '';
  message: string = '';

  constructor(
    private userService: UserService,
    private route: ActivatedRoute,
    private router: Router,
    private http: HttpClient,
    private activeModal: NgbActiveModal
  ) {}

  ngOnInit(): void {
    console.log('PROPS = ', this.props);

    this.user = this.props.user;
    console.log('updated PROPS = ', this.user);
  }

  close() {
    this.activeModal.close();
  }

  updateUser(): void {
    this.activeModal.close(this.user);
  }
}
