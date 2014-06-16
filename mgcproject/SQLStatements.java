/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mgcproject;

import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;

/**
 *
 * @author 3106909413
 */
public class SQLStatements {
    
    public static CachedRowSet getProductList (int jobID) throws SQLException {
        String statement = ("SELECT * FROM product WHERE job_id = " + jobID);
        return Query.readFromTable(statement);
    }
    
    public static String getJobList () throws SQLException {
        String statement = ("SELECT * FROM job");
        return statement;
    }
}
