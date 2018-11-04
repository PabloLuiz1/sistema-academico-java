
import java.sql.*;

public class BD {
    public static void main(String[] args){
        try{
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            Connection con = DriverManager.getConnection("jdbc:ucanaccess://c:/Intel/SA.accdb");
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery("select * from Alunos");
            while(rs.next()){
                System.out.println(rs.getString(1));//numero da coluna - começa em 1
            }
            
	    //st.executeUpdate("INSERT into Alunos (Matricula, Nome, Endereco, Curso) values ('1', 'Luciano', 'Fatec', 'ADS')");
            //st.executeUpdate("DELETE from Alunos where Matricula = '1'");
            //st.executeUpdate("UPDATE Alunos SET Nome = 'Carvalho' where Matricula = '1'");
            con.close();
        }catch(Exception e){e.printStackTrace();}  
    }
}