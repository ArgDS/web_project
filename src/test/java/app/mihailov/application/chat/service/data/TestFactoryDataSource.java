package app.mihailov.application.chat.service.data;


import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by ִלטענטי
 * Date: 22.10.2015.
 */

public class TestFactoryDataSource {

    @BeforeClass
    public static void initBefore(){
        FactoryDataSource.init("com.mysql.jdbc.Driver","mysql","localhost","3306","jdbc_example","jdbc_password","store_db");
    }

    @AfterClass
    public static void destroyAfter(){
        FactoryDataSource.destroy();
    }

    @Test
    public void getStatement(){
        Statement statement = FactoryDataSource.getStatement();
        Assert.assertNotNull(statement);
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getPreparedStatement(){
        PreparedStatement preparedStatement = FactoryDataSource.getPraperedStatement("select * from category");
        try {
            Assert.assertNotNull(preparedStatement);
            boolean execute = preparedStatement.execute();
            Assert.assertEquals(execute, true);
            ResultSet resultSet = preparedStatement.getResultSet();
            Assert.assertNotNull(resultSet);
            resultSet.close();
            preparedStatement.close();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
