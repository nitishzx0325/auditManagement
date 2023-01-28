import { ChecklistService } from "./../CheckList/checklist.service";
import { Router } from "@angular/router";
import { SecurityService } from "./../Services/security.service";
import { Component, OnInit } from "@angular/core";
import { SeverityService } from "../Services/severity.service";
import { AuditResponse } from "../Models/AuditResponse";

@Component({
  selector: "app-severity",
  templateUrl: "./severity.component.html",
  styleUrls: ["./severity.component.css"],
})
export class SeverityComponent implements OnInit {
  status: string = "";
  auditResponse: AuditResponse = {
    auditId: 0,
    managerName: "",
    projectExecutionStatus: "",
    projectName: "",
    remedialActionDuration: "",
  };

  constructor(
    private service: SeverityService,
    private router: Router,
    private securityService: SecurityService,
    private checklistService: ChecklistService
  ) {}

  getExecutionStatus(): void {
    let fetch: AuditResponse;
    this.service.executionStatus().subscribe(
      (data) => {
        fetch = data;
        //console.log(data);
        if (data.auditId == 0) {
          //valid check
          this.router.navigate(["backToLogin"]);
        }
      },
      (err) => {
        alert(err);
      },
      () => {
        this.auditResponse = fetch;
        this.status = this.auditResponse.projectExecutionStatus;
      }
    );
  }

  ngOnInit(): void {
    this.status = "";
    this.securityService.healthCheck().subscribe(
      (data) => {},
      (err) => {
        this.router.navigate(["error"]);
      },
      () => {
        this.service.auditHealthCheck().subscribe(
          (data) => {},
          (err) => {
            this.router.navigate(["error"]);
          },
          () => {
            this.securityService.checkAuthFromLocal("severity", "backToLogin");
            if (localStorage.getItem("auditToken") != null) {
              console.log("00");
              if (
                this.securityService.getLoginStatus() &&
                !this.securityService.getSpecialFlag()
              ) {
                console.log("!!111");
                this.getExecutionStatus();
              } else if (
                this.securityService.getLoginStatus() ||
                !this.securityService.getSpecialFlag()
              ) {
                console.log("!!222");
                this.securityService.turnOnSpecialFlag();
                this.router.navigate(["checklist"]);
              } else {
                console.log("!!33");
                this.router.navigate(["backToLogin"]);
              }
            } else {
              console.log("!!44");
              this.router.navigate(["backToLogin"]);
            }
          }
        );
      }
    );
  }
}
