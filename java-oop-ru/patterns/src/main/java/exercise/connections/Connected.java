package exercise.connections;

import exercise.TcpConnection;

// BEGIN
public class Connected implements Connection {
    private TcpConnection tcpConnection;

    public Connected(TcpConnection tcpConnection) {
        this.tcpConnection = tcpConnection;
    }

    @Override
    public String getCurrentState() {
        return "connected" ;
    }

    @Override
    public void connect() {
        System.out.println("Error The connection is already established");
    }

    @Override
    public void disconnect() {
        TcpConnection con = this.tcpConnection;
        con.setConnection(new Disconnected(con));
        System.out.println("Disconnected");
    }

    @Override
    public void write(String data) {
        System.out.println(data + " was added");
    }
}
// END
