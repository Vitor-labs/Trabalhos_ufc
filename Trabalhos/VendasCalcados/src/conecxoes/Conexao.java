package conecxoes;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {

    private String driver = "org.postgresql.Driver";
    private Connection connection = null;
    private boolean status = false;
    private Statement stm;
    private ResultSet result;

    // private String server = "chunee.db.elephantsql.com";
    // private String database = "jpnlijin";
    private String url = "jdbc:postgresql://chunee.db.elephantsql.com:5432/jpnlijin";
    private String username = "jpnlijin";
    private String password = "SODuY14QG0lDYReNQ58SuXLjKgEmSMU2";

    public Connection getCon() {
        return connection;
    }

    public Statement getStatement() {
        return stm;
    }

    public void setCon(Connection connection) {
        this.connection = connection;
    }

    public void setStatement(Statement stm) {
        this.stm = stm;
    }

    public ResultSet getResult() {
        return result;
    }

    public void setResult(ResultSet result) {
        this.result = result;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Connection conectar() {
        try {
            Class.forName(driver);
            this.setCon((Connection) DriverManager.getConnection(url, username, password));
            this.status = true;
            // JOptionPane.showMessageDialog(null, "Conectado Com sucesso");
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR: ", JOptionPane.ERROR_MESSAGE);
        }
        return this.getCon();
    }

    public boolean executeSQL(String sql) {
        try {
            this.setStatement(getCon().createStatement());
            this.setResult(getStatement().executeQuery(sql));

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean executeUpdateDelete(String sql) {
        try {
            this.setStatement(getCon().createStatement());
            getStatement().executeUpdate(sql);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean insertSQL(String sql) {
        int aux = 0;
        try {
            this.setStatement(getCon().createStatement());
            this.getStatement().executeUpdate(sql);
            this.setResult(this.getStatement().executeQuery("SELECT last_insert_id()"));
            while (this.getResult().next()) {
                aux = this.getResult().getInt(1);
            }
            if (aux > 0) {
                status = true;
            } else {
                status = false;
            }
            return status;

        } catch (Exception e) {
            e.printStackTrace();
            return this.getStatus();
        }
    }

    public boolean fecharConexao() {
        try {
            if ((this.getResult() != null) && (this.getStatement() != null)) {
                this.getResult().close();
                this.getStatement().close();
            }
            this.getCon().close();
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return false;
    }

    public static void main(String[] args) {
        new Conexao().conectar();
    }
}
