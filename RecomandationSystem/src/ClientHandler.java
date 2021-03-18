
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.*;

// ClientHandler class
class ClientHandler implements Runnable {
    private final Socket clientSocket;

    // Constructor
    public ClientHandler(Socket socket)
    {
        this.clientSocket = socket;
    }

    public String getConnectMessage(String username,String password)
    {
        try{
            Connection conn = DriverManager.getConnection("jdbc:sqlite:DatabaseRecomandationSystem.db");
            Statement stmt = conn.createStatement();
            // Crearea interogarii
            String sql = "SELECT * FROM users WHERE username=";
            sql=sql+username+" AND password=";
            sql=sql+password+" ;";
            //System.out.println("SQL= "  + sql);

            ResultSet rs = stmt.executeQuery(sql);
            int iVal = rs.getInt("username");
            if (rs.wasNull()) {
                return "Not Connected";
            }else{
                return "Connected";
            }
        }catch (SQLException e) {
            System.out.println(e.getMessage());
            return "Not Connected";
        }
    }

    public void run()
    {
        try{
            PrintWriter out = new PrintWriter( clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader( new InputStreamReader( clientSocket.getInputStream()));
            String user = in.readLine();
            String pass = in.readLine();
            String msg = getConnectMessage(user,pass);
            out.println(msg);
            if(msg.compareTo("Connected")==0) {
                String line;
                int exitStatus=1;
                while (exitStatus == 1) {
                    line = in.readLine();
                    if(line!=null) {
                        System.out.printf("Sent from the client: %s\n", line);
                        if(line.equals("exit"))
                        {
                            System.out.println("Goodbye !");
                            out.println("Goodbye");
                            exitStatus=0;
                            in.close();
                        }
                    }
                }
            }else{
                 out.close();
            }
        }catch(IOException a){
            System.out.println("IOException");
        }
    }
}