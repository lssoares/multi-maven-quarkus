package org.acme;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import org.h2.tools.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author leandrosoares
 */
@ApplicationScoped
public class ApplicationMonitor {

    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationMonitor.class);

    Server server;

    void onStart(@Observes StartupEvent event) {

        try {
            starth2();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    void onStop(@Observes ShutdownEvent event) {
        server.stop();
    }


    private void starth2() throws SQLException, ClassNotFoundException {
        server = Server.createTcpServer("-tcpAllowOthers").start();
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.
                getConnection("jdbc:h2:tcp://localhost/mem:test", "sa", "as");
        LOGGER.info("Connection Established: "
                + conn.getMetaData().getDatabaseProductName() + "/" + conn.getCatalog());

        Statement stat;
        stat = conn.createStatement();
        stat.execute(
                "create table example(id int primary key, code varchar) " +
                        "as select x, 'Example - '||x from system_range(1, 100)");

    }


}