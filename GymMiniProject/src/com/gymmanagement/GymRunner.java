package com.gymmanagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Scanner;

public class GymRunner 
{
	public static void main(String[] args) {
		Connection con = null;

		PreparedStatement ps_mins = null, ps_upd = null, ps_del = null, ps_sel = null,ps_ser=null,ps_btw=null;
		ResultSet rs = null;

		Scanner sc1 = new Scanner(System.in);
		Scanner sc2 = new Scanner(System.in);
		
		
		Boolean exit=true;
		
		String password = "s";

		System.out.println("---------------------WELCOME ADMIN---------------------");										// login
		System.out.println("\nSome people want it to happen, some wish it would happen, others make it happen. – Michael Jordan");

		System.out.println();
		System.out.println("Please Enter your password to Continue");
		String pass = sc1.nextLine();
		System.out.println();

		if (pass.equals(password)) { // validation
			try {
				con = JDBCHelper.getConnection();			

				if (con == null) // connection validation
					System.out.println("Sorry connection could not be Established....");

				else {
					// con.setAutoCommit(false);
					System.out.println("Established connection= " + con);
					System.out.println("You have been successfully logged in");
						
					
					while (exit) { 															// selecting trainer/member
						TrainerService trainer=new TrainerService();
						MemberService member=new MemberService();
						System.out.println();
						System.out.println("---------------------WELCOME---------------------");

						System.out.println();

						System.out.println("Please Select your prefered option");				//no Error
						System.out.println("1.Trainer");
						System.out.println("2.Members");
						System.out.println("3.Exit");
						int op = sc2.nextInt();

						switch (op) {

						case 1:
							trainer.trainerMenu();
							break;
						case 2:
							member.memberMenu();
							
									break;
											
						case 3:
							System.out.println();
							System.out.println("Exiting..............");
							exit=false;
							break;
						}
					}
						}
				}
			

			catch (Exception e) {
				// TODO: handle exception
				try {
					con.rollback();
				} catch (SQLException e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
				e.printStackTrace();
			} 
			
			finally {
				JDBCHelper.close(rs);
				JDBCHelper.close(ps_mins);
				JDBCHelper.close(ps_upd);
				JDBCHelper.close(ps_del);																//no Error
				JDBCHelper.close(ps_sel);
				JDBCHelper.close(ps_ser);
				JDBCHelper.close(ps_btw);
				sc1.close();
			    sc2.close();
			   
			    JDBCHelper.close(con);

			}

		} 
		
		else {
			System.out.println("Authentification Failed");
			System.out.println("Incorrect password");
		}
	}
}
		
	