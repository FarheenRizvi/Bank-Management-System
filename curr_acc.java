package bank;
import java.io.*;

interface account {
	 final int max_limit=20;
     final  int min_limit=1;
     final double min_bal=500;
       String name[]=new String[20];
      int accNo[]=new int[20];
       String accType[]=new String[20];
      double balAmt[]=new double[20];
     
	  
	}
class checkin_acc implements account      //Check in Account Class
{
        	static  int totRec=0;
        //Initializing Method
         public void initialize()
        {
             for(int i=0;i<max_limit;i++)
             {
                name[i]="";
                accNo[i]=0;
                accType[i]="";
                balAmt[i]=0.0;
            }
        }

        
        
        //TO  ADD NEW RECORD
        public void newEntry()
        {
               String str;
              
               boolean permit;
                permit=true;

               if (totRec>max_limit)
               {
                    System.out.println("\n\n\nSorry we cannot admit you in our bank...\n\n\n");
                    permit=false;
               }

               if(permit = true)   //Allows to create new entry
               {
               totRec++;         // Incrementing Total Record               
               System.out.println("\n\n\n==RECORDING NEW ENTRY==");
               try{
                          accNo[totRec]=totRec;    //Created  AutoNumber  to accNo so no invalid id occurs
                        System.out.println("Account Number :  "+accNo[totRec]);
                        
                     BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
                     System.out.print("Enter Name :  ");
                     System.out.flush();
                     name[totRec]=obj.readLine();

                     accType[totRec]="Checkin Account";
                     System.out.println("Account Type : "+accType[totRec]);                     
                    
                     
                     System.out.print("Enter Initial  Amount to be deposited : ");
                     System.out.flush();
                     str=obj.readLine();
                     balAmt[totRec]=Double.parseDouble(str);
                     
                     if(balAmt[totRec]<min_bal)//Validation that minimum amount must be 500
                     {
                    	
                    	 System.out.println("Amount less than 500 is not allowed");
                     }
               
                     else
                     {
                         

                    	 System.out.println("\n \n ");
                         
                     }
               }
                catch(Exception e)
                {}
            }
        }

        
        
        //TO DISPLAY DETAILS OF RECORD
        public void display()
        {
              String str;
              int acno=0;
              boolean valid=true;
                           
              System.out.println("\n\n==DISPLAYING DETAILS OF CUSTOMER==\n");
              try{
                 BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
                 System.out.print("Enter Account number : ");
                 System.out.flush();
                 str=obj.readLine();
                 acno=Integer.parseInt(str);
                  if (acno<min_limit  || acno>totRec)   //To check whether accNo is valid or Not
                     {
                          System.out.println("\n\n\nInvalid Account Number \n\n");
                          valid=false;
                     }

                    if (valid==true)
                      {     
                        System.out.println("\n\nAccount Number : "+accNo[acno]);
                        System.out.println("Name : "+name[acno]);
                        System.out.println("Account Type : "+accType[acno]);
                        System.out.println("Balance Amount : "+balAmt[acno]+"\n\n\n");
                      }
                 }
            catch(Exception e)
            {}
        }



          //TO DEPOSIT AN AMOUNT
        public void deposit()
        {
              String str;
              double amt;
              int acno;
              boolean valid=true;
              System.out.println("\n\n\n=====DEPOSIT AMOUNT=====");
              
              try{
                   //Reading deposit value
                   BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));

                        System.out.print("Enter Account No : ");
                        System.out.flush();
                        str=obj.readLine();
                        acno=Integer.parseInt(str);
                         if (acno<min_limit || acno>totRec)   //To check whether accNo is valid or Not
                         {
                              System.out.println("\n\n\nInvalid Account Number \n\n");
                              valid=false;
                         }
           
                        if (valid==true)
                       {
                            System.out.print("Enter Amount you want to Deposit  : ");
                            System.out.flush();
                            str=obj.readLine();
                            amt=Double.parseDouble(str);

                            balAmt[acno]=balAmt[acno]+amt;

                            //Displaying Depsit Details
                            System.out.println("\nAfter Updation...");
                            System.out.println("Account Number :  "+acno);
                            System.out.println("Balance Amount :  "+balAmt[acno]+"\n\n\n");
                        }
                 }
            catch(Exception e)
            {}
       }




     //TO WITHDRAW BALANCE
        public void withdraw()
        {
              String str;
              double amt,checkamt,penalty;
              int acno;
              boolean valid=true;
              System.out.println("\n\n\n=====WITHDRAW AMOUNT=====");
              
              try{
                   //Reading deposit value
                   BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
                   
                        System.out.print("Enter Account No : ");
                        System.out.flush();
                        str=obj.readLine();
                        acno=Integer.parseInt(str);

                          if (acno<min_limit || acno>totRec)   //To check whether accNo is valid or Not
                             {
                                System.out.println("\n\n\nInvalid Account Number \n\n");
                                valid=false;
                            }

                        if (valid==true)
                        {
                                System.out.println("Balance is : "+balAmt[acno]);
                                System.out.print("Enter Amount you want to withdraw  : ");
                                System.out.flush();
                                str=obj.readLine();
                                amt=Double.parseDouble(str);

                                checkamt=balAmt[acno]-amt;

                                if(checkamt >= min_bal)
                                 {
                                    balAmt[acno]=checkamt;
                                    //Displaying Deposit Details
                                    System.out.println("\nAfter Updation...");
                                    System.out.println("Account Number :  "+acno);
                                    System.out.println("Balance Amount :  "+balAmt[acno]+"\n\n\n");
                                }
                                else
                                 {
                                    System.out.println("\n\nYour Balance has gone down and so penalty is calculated");
                                   
                                    //Bank policy is to charge 20% on total difference of balAmt and min_bal to be maintain
                                    penalty=((min_bal - checkamt)*20)/100;
                                    balAmt[acno]=balAmt[acno]-(amt+penalty);
                                    System.out.println("Now your balance revels : "+balAmt[acno]+"\n\n\n");
                                }
                        }
                 }
            catch(Exception e)
            {}
       }

}



class Sav_acc implements account        //SAVING ACCOUNT CLASS
{
   
	static  int totRec=0;
        //Initializing Method
	public 	void initialize()
        {
             for(int i=0;i<max_limit;i++)
             {
                name[i]="";
                accNo[i]=0;
                accType[i]="";
                balAmt[i]=0.0;
            }
        }

        
        
        //TO  ADD NEW RECORD
        public void newEntry()
        {
               String str;
               boolean permit;
                permit=true;

               if (totRec>max_limit)
               {
                    System.out.println("\n\n\nSorry we cannot admit you in our bank...\n\n\n");
                    permit=false;
               }

               if(permit = true)   //Allows to create new entry
               {
               totRec++;         // Incrementing Total Record               
               System.out.println("\n\n\n=====RECORDING NEW ENTRY=====");
               try{
                          accNo[totRec]=totRec;    //Created  AutoNumber  to accNo so no invalid id occurs
                        System.out.println("Account Number :  "+accNo[totRec]);
                        
                     BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
                     System.out.print("Enter Name :  ");
                     System.out.flush();
                     name[totRec]=obj.readLine();

                     accType[totRec]="Saving Account";   
                     System.out.println("Account Type : "+accType[totRec]);

                     System.out.print("Enter Initial  Amount to be deposited : ");
                     System.out.flush();
                     str=obj.readLine();
                     balAmt[totRec]=Double.parseDouble(str);
                     
                     if(balAmt[totRec]<min_bal)//Validation that minimum amount must be 500
                     {
                    	
                    	 System.out.println("Amount less than 500 is not allowed");
                     }
               
                     else
                     {
                         

                    	 System.out.println("\n \n ");
                         
                     }
               }
                catch(Exception e)
                {}
            }
        }

        
        
        //TO DISPLAY DETAILS OF RECORD
        public void display()
        {
              String str;
              int acno=0;
              boolean valid=true;
                           
              System.out.println("\n\n=====DISPLAYING DETAILS OF CUSTOMER=====\n");
              try{
                 BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
                 System.out.print("Enter Account number : ");
                 System.out.flush();
                 str=obj.readLine();
                 acno=Integer.parseInt(str);
                  if (acno<min_limit  || acno>totRec)   //To check whether accNo is valid or Not
                     {
                          System.out.println("\n\n\nInvalid Account Number \n\n");
                          valid=false;
                     }

                    if (valid==true)
                      {     
                        System.out.println("\n\nAccount Number : "+accNo[acno]);
                        System.out.println("Name : "+name[acno]);
                        System.out.println("Account Type : "+accType[acno]);
                        
                        //Bank policy is to give 10% interest on Net balance amt
                        balAmt[acno]=balAmt[acno]+(balAmt[acno]/10);
                        System.out.println("Balance Amount : "+balAmt[acno]+"\n\n\n");
                      }
                 }
            catch(Exception e)
            {}
        }



          //TO DEPOSIT AN AMOUNT
        public void deposit()
        {
              String str;
              double amt;
              int acno;
              boolean valid=true;
              System.out.println("\n\n\n=====DEPOSIT AMOUNT=====");
              
              try{
                   //Reading deposit value
                   BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));

                        System.out.print("Enter Account No : ");
                        System.out.flush();
                        str=obj.readLine();
                        acno=Integer.parseInt(str);
                         if (acno<min_limit || acno>totRec)   //To check whether accNo is valid or Not
                         {
                              System.out.println("\n\n\nInvalid Account Number \n\n");
                              valid=false;
                         }
           
                        if (valid==true)
                       {
                            System.out.print("Enter Amount you want to Deposit  : ");
                            System.out.flush();
                            str=obj.readLine();
                            amt=Double.parseDouble(str);

                            balAmt[acno]=balAmt[acno]+amt;

                            //Displaying Deposit Details
                            System.out.println("\nAfter Updation...");
                            System.out.println("Account Number :  "+acno);
                            System.out.println("Balance Amount :  "+balAmt[acno]+"\n\n\n");
                        }
                 }
            catch(Exception e)
            {}
       }



     //TO WITHDRAW BALANCE
        public void withdraw()
        {
              String str;
              double amt,checkamt;
              int acno;
              boolean valid=true;
              System.out.println("\n\n\n=====WITHDRAW AMOUNT=====");
              
              try{
                   //Reading deposit value
                   BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
                   
                        System.out.print("Enter Account No : ");
                        System.out.flush();
                        str=obj.readLine();
                        acno=Integer.parseInt(str);

                          if (acno<min_limit || acno>totRec)   //To check whether accNo is valid or Not
                             {
                                System.out.println("\n\n\nInvalid Account Number \n\n");
                                valid=false;
                            }

                        if (valid==true)
                        {
                                System.out.println("Balance is : "+balAmt[acno]);
                                System.out.print("Enter Amount you want to withdraw  : ");
                                System.out.flush();
                                str=obj.readLine();
                                amt=Double.parseDouble(str);

                                checkamt=balAmt[acno]-amt;

                                if(checkamt >= min_bal)
                                 {
                                    balAmt[acno]=checkamt;
                                    //Displaying Deposit Details
                                    System.out.println("\nAfter Updation...");
                                    System.out.println("Account Number :  "+acno);
                                    System.out.println("Balance Amount :  "+balAmt[acno]+"\n\n\n");
                                }
                                else
                                 {
                                    System.out.println("\n\nAs per Bank Rule you should maintain minimum balance of Rs 500\n\n\n");
                                }
                        }
                 }
            catch(Exception e)
            {}
       }
        
}
class business_acc implements account      //Business ACCOUNT CLASS
{
        	static  int totRec=0;
        //Initializing Method
         public void initialize()
        {
             for(int i=0;i<max_limit;i++)
             {
                name[i]="";
                accNo[i]=0;
                accType[i]="";
                balAmt[i]=0.0;
            }
        }

        
        
        //TO  ADD NEW RECORD
        public void newEntry()
        {
               String str;
              
               boolean permit;
                permit=true;

               if (totRec>max_limit)
               {
                    System.out.println("\n\n\nSorry we cannot admit you in our bank...\n\n\n");
                    permit=false;
               }

               if(permit = true)   //Allows to create new entry
               {
               totRec++;         // Incrementing Total Record               
               System.out.println("\n\n\n==RECORDING NEW ENTRY==");
               try{
                          accNo[totRec]=totRec;    //Created  AutoNumber  to accNo so no invalid id occurs
                        System.out.println("Account Number :  "+accNo[totRec]);
                        
                     BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
                     System.out.print("Enter Name :  ");
                     System.out.flush();
                     name[totRec]=obj.readLine();

                     accType[totRec]="Business Account";
                     System.out.println("Account Type : "+accType[totRec]);                     

                     System.out.print("Enter Initial  Amount to be deposited : ");
                     System.out.flush();
                     str=obj.readLine();
                     balAmt[totRec]=Double.parseDouble(str);
                     
                     if(balAmt[totRec]<min_bal)//Validation that minimum amount must be 500
                     {
                    	
                    	 System.out.println("Amount less than 500 is not allowed");
                     }
               
                     else
                     {
                         

                    	 System.out.println("\n \n ");
                         
                     }
               }
                catch(Exception e)
                {}
            }
        }

        
        
        //TO DISPLAY DETAILS OF RECORD
        public void display()
        {
              String str;
              int acno=0;
              boolean valid=true;
                           
              System.out.println("\n\n==DISPLAYING DETAILS OF CUSTOMER==\n");
              try{
                 BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
                 System.out.print("Enter Account number : ");
                 System.out.flush();
                 str=obj.readLine();
                 acno=Integer.parseInt(str);
                  if (acno<min_limit  || acno>totRec)   //To check whether accNo is valid or Not
                     {
                          System.out.println("\n\n\nInvalid Account Number \n\n");
                          valid=false;
                     }

                    if (valid==true)
                      {     
                        System.out.println("\n\nAccount Number : "+accNo[acno]);
                        System.out.println("Name : "+name[acno]);
                        System.out.println("Account Type : "+accType[acno]);
                        System.out.println("Balance Amount : "+balAmt[acno]+"\n\n\n");
                      }
                 }
            catch(Exception e)
            {}
        }



          //TO DEPOSIT AN AMOUNT
        public void deposit()
        {
              String str;
              double amt;
              int acno;
              boolean valid=true;
              System.out.println("\n\n\n=====DEPOSIT AMOUNT=====");
              
              try{
                   //Reading deposit value
                   BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));

                        System.out.print("Enter Account No : ");
                        System.out.flush();
                        str=obj.readLine();
                        acno=Integer.parseInt(str);
                         if (acno<min_limit || acno>totRec)   //To check whether accNo is valid or Not
                         {
                              System.out.println("\n\n\nInvalid Account Number \n\n");
                              valid=false;
                         }
           
                        if (valid==true)
                       {
                            System.out.print("Enter Amount you want to Deposit  : ");
                            System.out.flush();
                            str=obj.readLine();
                            amt=Double.parseDouble(str);

                            balAmt[acno]=balAmt[acno]+amt;

                            //Displaying Deposit Details
                            System.out.println("\nAfter Updation...");
                            System.out.println("Account Number :  "+acno);
                            System.out.println("Balance Amount :  "+balAmt[acno]+"\n\n\n");
                        }
                 }
            catch(Exception e)
            {}
       }




     //TO WITHDRAW BALANCE
        public void withdraw()
        {
              String str;
              double amt,checkamt,penalty;
              int acno;
              boolean valid=true;
              System.out.println("\n\n\n=====WITHDRAW AMOUNT=====");
              
              try{
                   //Reading deposit value
                   BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
                   
                        System.out.print("Enter Account No : ");
                        System.out.flush();
                        str=obj.readLine();
                        acno=Integer.parseInt(str);

                          if (acno<min_limit || acno>totRec)   //To check whether accNo is valid or Not
                             {
                                System.out.println("\n\n\nInvalid Account Number \n\n");
                                valid=false;
                            }

                        if (valid==true)
                        {
                                System.out.println("Balance is : "+balAmt[acno]);
                                System.out.print("Enter Amount you want to withdraw  : ");
                                System.out.flush();
                                str=obj.readLine();
                                amt=Double.parseDouble(str);

                                checkamt=balAmt[acno]-amt;

                                if(checkamt >= min_bal)
                                 {
                                    balAmt[acno]=checkamt;
                                    //Displaying Deposit Details
                                    System.out.println("\nAfter Updation...");
                                    System.out.println("Account Number :  "+acno);
                                    System.out.println("Balance Amount :  "+balAmt[acno]+"\n\n\n");
                                }
                                else
                                 {
                                    System.out.println("\n\nYour Balance has gone down and so penalty is calculated");
                                   
                                    //Bank policy is to charge 20% on total difference of balAmt and min_bal to be maintain
                                    penalty=((min_bal - checkamt)*20)/100;
                                    balAmt[acno]=balAmt[acno]-(amt+penalty);
                                    System.out.println("Now your balance revels : "+balAmt[acno]+"\n\n\n");
                                }
                        }
                 }
            catch(Exception e)
            {}
       }

}



