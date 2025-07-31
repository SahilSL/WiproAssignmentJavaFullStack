package com.wipro.practice;
/*
 The following are the superclass Bank and its subclasses Saving and Current.
Super class : Bank
public class Bank 
{
String accNo;  //customer account number with Bank
String custName; //customer name
int custGender;  //customer gender 1 = Male, 2 =Female
String custJob;  //customer job positions
double curBal;  //customer balance in the bank account
public String toString();
public abstract double calcBalance();
}

Subclass : Saving
public class Saving 
{
double savRate;  //percent interest rate per year
}

Subclass : Current
public class Current
{
boolean fixedDep;  //whether the customer keeps the fixed// deposit with the bank of not
double curRate;  //percent interest rate per year
}

The  above  classes  show  that  Bank  can  have  two  different  types  of  account  which  are Saving  and  Current  account.
  The  balance amount  in the  bank for  each account  is basedon the following calculation :

Saving :Balance =  current balance + (savRate * current balance)
Current :Balance = current balance + (curRate * current balance)

If the customer has a fixed deposit with the bank, then the bank will charge RM150for the service fee.  
The amount will be deducted automatically yearly.

a)  Write a method of calcBalance() for both subclasses.
b)  Search  a  customer  based  on  the  account  number  entered  then  display  detailinformation  of  him/her.  If  the  customer  account  number  is  not  found,  display  anappropriate message.
c)  Count how many customers that have the current account with the bank and the totalbalance.  

 
 */
public class Assignment19 {
 // check - Folder is created for Assignment 19
}
