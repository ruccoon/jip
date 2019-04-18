package com.cejv456.jip.dao;

import com.cejv456.jip.data.DBBean;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * this class get database connection parameter from jar properties file, then
 * get connection from database
 *
 * @author Jianyu Feng
 */
public final class JipDBConnection {

    private Logger logger;
    private String propertiesFileName;
    private DBBean dbBean;
    private static JipDBConnection instance = null;
    public Connection connection;

    /**
     * use singleton to generate db connection<br> private constructor to avoid the
     * JipDBConnection class to be instantiated directly
     *
     * @throws IOException
     * @throws SQLException
     */
    private JipDBConnection() throws IOException, SQLException {
        super();

        logger = LoggerFactory.getLogger(this.getClass().getName());

        // load db properties
        propertiesFileName = "jardb.properties";
        dbBean = loadJarDBProperties(propertiesFileName);
        logger.info("Database connection properties loaded.");

        // generate db connection
        connection = DriverManager.getConnection(dbBean.getUrl(), dbBean.getUser(), dbBean.getPassword());
        logger.info("Database connection instantiated.");

    }

    /**
     * load jar db connection properties file
     *
     * @param propertiesFileName
     * @return
     */
    private DBBean loadJarDBProperties(String propertiesFileName) throws IOException {

        Properties prop = new Properties();

        DBBean dbb = new DBBean();

        // Throws NullPointerException if properties file is not found
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        InputStream stream = loader.getResourceAsStream(propertiesFileName);
        prop.load(stream);
        logger.info("jar db properties file loaded");

        dbb.setUrl(prop.getProperty("url"));
        dbb.setUser(prop.getProperty("user"));
        dbb.setPassword(prop.getProperty("password"));

        return dbb;
    }

    /**
     * get db connection
     *
     * @return
     * @throws SQLException
     */
    public static JipDBConnection getConnection() throws IOException, SQLException {
        if (instance == null) {
            JipDBConnection instance = new JipDBConnection();
            return instance;
        } else {
            return instance;
        }

    }
}
