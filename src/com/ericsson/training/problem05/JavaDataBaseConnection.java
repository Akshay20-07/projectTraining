package com.ericsson.training.problem05;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import com.ericsson.training.common.*;

import java.sql.Connection;

/**
 * This class is used for accessing database organisation and doing operations
 * on it. throw the methods.we have insert,delete ,update,selectdataand
 * connection method in it.
 * 
 * @author ezaksch
 * @see Statement,Date,Connection,PreparedStatement,DriverManager,Resultset.
 */
public class JavaDataBaseConnection {
	static Logger logger=Logger.getLogger(JavaDataBaseConnection.class.getName());
	public static FileHandler fileHandle;

	/**
	 * To call methods such as getConnection() ,insertRow(), updateRow()
	 * ,deleteRow() ,selectData().
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		fileHandle = new FileHandler(ConstantFile.JDBC_LOG_FILE);
		logger.addHandler(fileHandle);
		fileHandle.setFormatter(new SimpleFormatter());
		logger.setUseParentHandlers(true); 
		JavaDataBaseConnection builObject = new JavaDataBaseConnection();
		builObject.makeConnection();
		//builObject.insertRow(ConstantFile.INSERTION_SQL);
		//builObject.updateRow(ConstantFile.UPDATE_SQL);
		//builObject.deleteRow(ConstantFile.DELETE_SQL);
		//builObject.selectData(ConstantFile.SELECTION_SQL);
		builObject.select_Data("select * from  callredirect_configuration");
	}

	/**
	 * Building a connection object conn between mysql and java. It will call
	 * database organisation from mysql.
	 * 
	 * @return conn connection object.
	 * @throws ClassNotFoundException,SQLException.
	 * @exception in case connection build up time out.
	 * @see Connection,getConnection
	 */
	public Connection makeConnection() {
		try {
			/// establishing connection
			
			//String database = ConstantFile.DATABASE;
			String database = "call_redirect_configuration";
			String userName = ConstantFile.USER_NAME;
			String password = ConstantFile.PASSWORD;
			Class.forName(ConstantFile.DRIVER);
			Connection conn = DriverManager.getConnection(ConstantFile.URL + database, userName, password);
			return conn;

		} catch (ClassNotFoundException | SQLException e) {
			logger.warning(e.getMessage());
		}
		return null;
	}

	/**
	 * It will insert a row into organisation database and also gives the result of
	 * number of rows executed.
	 * 
	 * @param  sqlInsertion a sql statement with parameters
	 * @return int number of rows inserted
	 * @throws SQLException
	 * @see makeConnection,prepareStatement
	 */
	public int insertRow(String sqlInsertion) {
		Connection connection = makeConnection();
		logger.config("connected");
		// insertion of rows
		String sql =sqlInsertion;
		int rowInserted=0;
		try {
			PreparedStatement sqlStatement = connection.prepareStatement(sql);
			// stmt.setInt(1,2);
			sqlStatement.setString(1,ConstantFile.GRADE);
			sqlStatement.setString(2,ConstantFile.JOBSTAGE);
			sqlStatement.setString(3,ConstantFile.SEX);
			sqlStatement.setInt(4, 28);
			sqlStatement.setString(5,ConstantFile.DEPARTMENT);
			sqlStatement.setString(6,ConstantFile.MANAGER);
			sqlStatement.setString(7,ConstantFile.ADDRESS);
			sqlStatement.setDate(8,ConstantFile.Date_OF_JOINING);
			rowInserted = sqlStatement.executeUpdate();
			if (rowInserted > 0) {
				logger.info("no of rows updated: " + rowInserted);
				//System.out.println("no of rows updated: " + rowInserted);
			}
		} catch (SQLException e) {
			logger.warning(e.getMessage());
		}
		return rowInserted;

	}

	/**
	 * It will select data from organisation database and show it's output in
	 * console.It will show the entire table in organisation.
	 * 
	 * @param sqlSelection a sql statement without parameters
	 * @return String output of the sqlQuery
	 * @throws SQLException
	 * @see makeConnection,createStatement,stringFormat,executeQuery
	 */
public String select_Data(String sqlSelection) {
		Connection connection = makeConnection();
		//logger.config("connected");
		// To show the data
		String stringOutput=null;
		try {
			Statement sqlstatement = connection.createStatement();
			ResultSet result = sqlstatement.executeQuery(sqlSelection);
			
			while (result.next()) {
				/*int empid = result.getInt(1);
				String grade = result.getString(2);
				String jobstage = result.getString(3);
				String sex = result.getString(4);
				int age = result.getInt(5);
				String dept = result.getString(6);
				String mg = result.getString(7);
				String adrs = result.getString(8);
				Date doj = result.getDate(9);

				String output = ("employee #%d %s %s %s %d %s  %s %s %s ");// format specifiers %d :decimal ,integer
																	// ,%s:String values
				stringOutput=String.format(output, empid, grade, jobstage, sex, age, dept, mg, adrs, doj);
				*/
				String confkey=result.getString(1);
				String confvalue=result.getString(2);
				String confdesc=result.getString(3);
				String output = ("%s ");
				String output1 = (" %s ");
				String output2 = ("%s ");
				System.out.println(String.format(output,confkey));
				System.out.println(String.format(output1,confvalue));
				System.out.println(String.format(output2,confdesc));
				//logger.info(stringOutput);
				
				//System.out.println(String.format(output, empid, grade, jobstage, sex, age, dept, mg, adrs, doj));
			}
		} catch (SQLException e) {
			logger.warning(e.getMessage());

		}
		return stringOutput;

	}

	/**
	 * It will update row in organisation database and will respond with number of
	 * updated rows on console.
	 * 
	 * @param sqlSelection a sql statement with parameters
	 * @return int number of rows updated
	 * @throws SQLException
	 * @see makeConnection,prepareStatement,executeUpdate
	 */
	public int updateRow(String sqlUpdate) {
		Connection connection = makeConnection();
		logger.config("connected");
		int rowUpdated=0;
		try {
			PreparedStatement sqlStatment = connection.prepareStatement(sqlUpdate);

			sqlStatment.setInt(3, 2);
			sqlStatment.setString(1,ConstantFile.SD);
			sqlStatment.setString(2,ConstantFile.ADAPTATION);
			rowUpdated = sqlStatment.executeUpdate();

			if (rowUpdated > 0) {
				logger.info("rows updated: " + rowUpdated);
				//System.out.println("rows updated: " + rowUpdated);
			}
		} catch (SQLException e) {
			logger.warning(e.getMessage());
		}
		return rowUpdated;

	}

	/**
	 * It will delete row from the database and show result on console about number
	 * of rows deleted.
	 * 
	 * @param sqlSelection a sql statement with parameters
	 * @return int number of rows deleted
	 * @throws SQLException
	 * @see makeConnection,prepareStatement,executeUpdate
	 */
	public int deleteRow(String sqlDelete) {
		Connection connection = makeConnection();
		logger.config("connected");
		int rowsDeleted=0;
		try {
			PreparedStatement sqlStatement = connection.prepareStatement(sqlDelete);
			sqlStatement.setInt(1, 28);
			rowsDeleted = sqlStatement.executeUpdate();
			if (rowsDeleted > 0) {
				logger.info("Rows deleted: " + rowsDeleted);
				//System.out.println("Rows deleted: " + rowsUpdated);
			}
		} catch (SQLException e) {
			logger.warning(e.getMessage());
		}
		return rowsDeleted;

	}

}
