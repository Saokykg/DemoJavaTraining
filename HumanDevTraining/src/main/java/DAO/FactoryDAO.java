package DAO;


public class FactoryDAO {
    public static AbstractDAO getDAO() {
        String database = "3";
        if (database.equals("1")) {
            return new MySQLDAO();
        }
        if (database.equals("2")) {
            return new PostgreDAO();
        }
        if (database.equals("3")) {
            return new MSSQLDAO();
        }
        return null;
    }
}