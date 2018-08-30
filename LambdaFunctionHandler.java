package com.amazonaws.lambda.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaFunctionHandler implements RequestHandler<InputClass, OutputClass> {

	@Override
    public OutputClass handleRequest(InputClass request, Context context) {
        
        OutputClass response = new OutputClass();
        
      
        try {
        	  Connection conn = DriverManager.getConnection(
      				"jdbc:mysql://retailbanking.cu1eaqjaoadd.us-east-2.rds.amazonaws.com/Retail", "pgupta1312",
      				"pgupta1312");
        	
			if(request==null) {
				request = new InputClass(1500000010);
			}
			int input = request.getCin();
			context.getLogger().log("Input: " + input);
			response.setCin(input);

			
			// 3 SQL Statements to be executed from here

			// SQL 1: To get total discounted
			String sql = null;

			// input= "1500000014";
			sql = "select account_number " + 
					"from account " + 
					"where (CIN=" + input+")";

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			// context.getLogger().log("Account Number Query Executed");

			while (rs.next()) {
				response.setAccount_number(rs.getInt(1));

			}
			
			int accno = response.getAccount_number();

			// SQL 2: To get last month discounted
			sql = "select balance " + 
					"from account " + 
					"where (CIN=" + input+")";

			rs = stmt.executeQuery(sql);

			// context.getLogger().log("Last Month Query Executed");

			// transactions
			
			while (rs.next()) {
				response.setBalance(rs.getDouble(1));
			}
			
			sql = "select total_debit " + 
					"from account " + 
					"where (CIN=" + input+")";

			rs = stmt.executeQuery(sql);

			// context.getLogger().log("Last Month Query Executed");

			// transactions
			
			while (rs.next()) {
				response.setTotal_debit(rs.getDouble(1));
			}
			
			sql = "select total_credit " + 
					"from account " + 
					"where (CIN=" + input+")";

			rs = stmt.executeQuery(sql);

			// context.getLogger().log("Last Month Query Executed");

			// transactions
			
			while (rs.next()) {
				response.setTotal_credit(rs.getDouble(1));
			}
			
			sql = "select transaction_id , type , amount , date " + 
					"from transactions " + 
					"where (account_number=" + accno+")";

			rs = stmt.executeQuery(sql);

			// context.getLogger().log("Last Month Query Executed");

			int i=0;
			while (rs.next()) {
				
				 TransactionClass trans = new TransactionClass();
				 
				 trans.setTransaction_id(rs.getInt(1));
				 trans.setType(rs.getString(2));
				 trans.setAmount(rs.getDouble(3));
				 trans.setDate(rs.getString(4));
				 
				 response.t[i++]=trans;
			}
			




        }catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		context.getLogger().log(response.toString());
		return response;

    }
}
