package modelo;
import connectionMySql.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AtualizaDados extends PropriedadesSensor {
    
     public boolean Salvar (PropriedadesSensor t,PropriedadesSensor h,PropriedadesSensor c){
        
        PropriedadesSensor prop = new PropriedadesSensor();
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            
            stmt = con.prepareStatement("UPDATE dados SET valortemp = ? ,valorhumi = ? ,valorchuva = ? WHERE iddados = 1 ");
            stmt.setDouble(1, t.getValortemp());
            stmt.setDouble(2, h.getValorhumi());
            stmt.setString(3, c.getValorchuva());

            stmt.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            
            System.out.println("Erro ao Salvar"+ex);
            
                return false;      
        }
        finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
}
