package org.sda;

public class Menu {
    private InputReader inputReader=new InputReader();
    private final int GET_LOCATION_OPTION= 1;
    private final int GET_PEOPLE_OPTION=2;
    private final IssApiService issApiService= new IssApiService();
    public void startUp(){
        printHeader();
        printOptions();
    }
    public  void printHeader(){
        System.out.println("***************");
        System.out.println("****ISS APP****");
        System.out.println("***************");
    }
    public void printOptions(){
        System.out.println("1. Get ISS Location");
        System.out.println("2. Get People in Space");
        System.out.println("Select Option:   ");
        int input = inputReader.readInput();
        handleUserInput(input);
    }
    public void handleUserInput(int input){
        if (input== GET_LOCATION_OPTION){
            // go to get iss location and print
            getAndPrintIssLocation();
        }else if (input==GET_PEOPLE_OPTION){
            //go to get people in space
            getAndPrintPeopleInSpace();
        }else {
            // handle invalid option
            System.out.println("\n Select valid option.\n");
            //return to menu to select option
            printOptions();
        }
    }
    public void getAndPrintIssLocation (){
        Location location= issApiService.getIssLocation();
        System.out.println("Latitude "+ location.getIss_position().getLatitude());
        System.out.println("Longitude "+ location.getIss_position().getLongitude());
        printOptions();
    }
    public void getAndPrintPeopleInSpace(){
        IssSpaceship issSpaceship= issApiService.getPeopleInIss();
        System.out.println("Number of people in space : "+ issSpaceship.getNumber());
        System.out.println("People in space : "+ issSpaceship.getPeople());
        printOptions();
    }
}
