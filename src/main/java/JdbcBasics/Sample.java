package JdbcBasics;

import JDBCHelpers.*;

public class Sample {
    private static void runner(){
        Connections connections = new Connections();
        if(connections.open("localhost:3306/sem5", "root","")){

            if(connections.executeDDL("CREATE TABLE `TES` (\n" +
                    "  `ano` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `holder` VARCHAR(100) DEFAULT NULL,\n" +
                    "  `password` VARCHAR(100) DEFAULT NULL,\n" +
                    "  `amount` FLOAT(20),\n" +
                    "  PRIMARY KEY (`ano`)\n" +
                    ")")){
                System.out.println("Table created.");
            }
            System.out.println("Inserted "+
                    connections.executeDML("INSERT INTO `TES` (`holder`, `password`, `amount`) \n" +
                    "VALUES\n" +
                    "('A5', 'password',500),\n" +
                    "('TES', 'something',1500),\n" +
                    "('Harshang', 'strong_password',500),\n" +
                    "('Leo', 'wonderful_password',1500)\n" +
                    ";") + " rows.");

            if(connections.executeResult("SELECT * FROM `TES`")) {
                System.out.println("ResultSet has been generated");
            }

            System.out.println(connections.executeDML("UPDATE `TES` SET PASSWORD = 'new_stronger_p@ssword' WHERE ano = 1;")+" rows updated.");

            if(connections.executeResult("SELECT * FROM `TES`")) {
                System.out.println("ResultSet has been generated");
            }

            if(connections.executeDDL("DROP TABLE `TES`;")){
                System.out.println("Table dropped.");
            }

            connections.setCurrentResultSetIndex(0);
            connections.printCurrentResultSetData("Table before updating");
            connections.setCurrentResultSetIndex(1);
            connections.printCurrentResultSetData("Table after updating");
        }
    }
    public static void main(String[] args) {
        Sample.runner();
    }
}
