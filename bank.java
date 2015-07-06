package bank;
import java.io.BufferedReader;
import java.io.InputStreamReader;


class  bank
{
    public static void main(String args[]) 
    {
        String str;
        int choice,check_acct=1,quit=0;
        choice=0;

         checkin_acc chk_obj = new checkin_acc();
         Sav_acc sav_obj = new Sav_acc();
         business_acc bus_obj=new  business_acc();

         System.out.println("\n....WELLCOME....\n");


while( quit!=1)
{
        try{
           BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
           System.out.println("Type 1 for Checkin Account  ");
           System.out.println("Type 2 for Savings Account ");
           System.out.println("Type 3 for Business Account ");
           System.out.println("Enter your choice:");
           System.out.flush();
           str=obj.readLine();
           check_acct=Integer.parseInt(str);
           }
           catch(Exception e) {}

    if(check_acct==1)
     {
        do//For Check in Account
        {
        System.out.println("\n\nChoose Your Choices:");
        System.out.println("1) New Record Entry ");
        System.out.println("2) Display Record Details ");
        System.out.println("3) Deposit");
        System.out.println("4) Withdraw");
        System.out.println("5) Quit");
         System.out.print("Enter your choice :  ");
        System.out.flush();
              try{
                   BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
                   str=obj.readLine();
                   choice=Integer.parseInt(str);

                          switch(choice)
                           {
                            case 1 :  //New Record Entry
                                            chk_obj.newEntry();
                                           break;
                            case 2 :  //Displaying Record Details
                                           chk_obj.display();
                                           break;
                            case 3 : //Deposit...
                                            chk_obj.deposit();
                                           break;
                            case 4 : //Withdraw...
                                            chk_obj.withdraw();
                                            break;
                            case 5  :  System.out.println("\n\n.....Closing Checkin Account.....");
                                            break;
                            default : System.out.println("\nInvalid Choice \n\n");
                          }
                    }
                catch(Exception e)
                {}
            }while(choice!=5);
    }
else
	if(check_acct==2)
  {
      do //For Saving Account
        {
        System.out.println("Choose Your Choices");
        System.out.println("1) New Record Entry ");
        System.out.println("2) Display Record Details ");
        System.out.println("3) Deposit");
        System.out.println("4) Withdraw");
        System.out.println("5) Quit");
         System.out.print("Enter your choice :  ");
        System.out.flush();
              try{
                   BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
                   str=obj.readLine();
                   choice=Integer.parseInt(str);

                          switch(choice)
                           {
                            case 1 :  //New Record Entry
                                            sav_obj.newEntry();
                                           break;
                            case 2 :  //Displaying Record Details
                                           sav_obj.display();
                                           break;
                            case 3 : //Deposit...
                                            sav_obj.deposit();
                                           break;
                            case 4 : //Withdraw...
                                            sav_obj.withdraw();
                                            break;
                            case 5  :  System.out.println("\n\n.....Closing Saving Account.....");
                                            break;
                            default : System.out.println("\nInvalid Choice \n\n");
                          }
                    }
                catch(Exception e)
                {}
            }while(choice!=5);
      }
	else
		if(check_acct==3)
	{
			 do//For business Account
		        {
		        System.out.println("\n\nChoose Your Choices:");
		        System.out.println("1) New Record Entry ");
		        System.out.println("2) Display Record Details ");
		        System.out.println("3) Deposit");
		        System.out.println("4) Withdraw");
		        System.out.println("5) Quit");
		         System.out.print("Enter your choice :  ");
		        System.out.flush();
		              try{
		                   BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
		                   str=obj.readLine();
		                   choice=Integer.parseInt(str);

		                          switch(choice)
		                           {
		                            case 1 :  //New Record Entry
		                                            bus_obj.newEntry();
		                                           break;
		                            case 2 :  //Displaying Record Details
		                                          bus_obj.display();
		                                           break;
		                            case 3 : //Deposit...
		                                            bus_obj.deposit();
		                                           break;
		                            case 4 : //Withdraw...
		                                           bus_obj.withdraw();
		                                            break;
		                            case 5  :  System.out.println("\n\n.....Closing Business Account.....");
		                                            break;
		                            default : System.out.println("\nInvalid Choice \n\n");
		                          }
		                    }
		                catch(Exception e)
		                {}
		            }while(choice!=5);
		    }
			
			
}
    
    
    
    
try{
BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
System.out.print("\nEnter 1 for Exit : ");
System.out.flush();
str=obj.readLine();
quit=Integer.parseInt(str);
}catch (Exception e){}
}
    }
   



