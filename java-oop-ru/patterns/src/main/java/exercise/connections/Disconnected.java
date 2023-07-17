package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Disconnected implements Connection{
    private TcpConnection tcpConnection;

    public Disconnected(TcpConnection tcpConnection) {
        this.tcpConnection = tcpConnection;
    }

    @Override
    public String getCurrentState() {
        return "disconnected";
    }

    @Override
    public void connect() {
        TcpConnection con = this.tcpConnection;
        con.setConnection(new Connected(con));
        System.out.println("Connected");
    }

    @Override
    public void disconnect() {
        System.out.println("Error ! This ip is already disconnected");
    }

    @Override
    public void write(String data) {
        System.out.println("Error" + data);
    }
}
// END
