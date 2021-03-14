package org.jiaopi.conf.mysql;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.stereotype.Component;

@Component
public class MySQLUpperCaseStrategy extends PhysicalNamingStrategyStandardImpl {
    private static final long serialVersionUID = 2206104154134014828L;

    public Identifier toPhysicalTableName (Identifier name, JdbcEnvironment context) {
        String tableName = name.getText().toLowerCase();
        return Identifier.toIdentifier(tableName);
    }
}
