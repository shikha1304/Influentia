export class ticketDTO{
    public ticketId: Number;
    public raisedByUserName: String;
    public createdOn: Date;
    public expectedResolutionOn: Date;
    public ticketSummary: String;
    public ticketDetails: String;
    public ticketStatus: String;
    public ticketType: String;

    constructor(ticketId: Number, raisedByUserName: String, createdOn: Date, expectedResolutionOn: Date, ticketSummary: String, ticketDetails: String, ticketStatus: String, ticketType: String){
        this.ticketId = ticketId;
        this.raisedByUserName = raisedByUserName;
        this.createdOn = createdOn;
        this.expectedResolutionOn = expectedResolutionOn;
        this.ticketSummary = ticketSummary;
        this.ticketDetails = ticketDetails;
        this.ticketStatus = ticketStatus;
        this.ticketType = ticketType;
    }
}