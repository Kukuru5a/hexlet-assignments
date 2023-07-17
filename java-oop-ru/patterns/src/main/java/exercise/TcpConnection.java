package exercise;
import exercise.connections.Connection;
import exercise.connections.Disconnected;

// BEGIN
public class TcpConnection implements Connection {
    private String ipAdress;
    private int port;
    private Connection connection;

    public TcpConnection(String ipAdress, int port) {
        this.ipAdress = ipAdress;
        this.port = port;
        this.connection = new Disconnected(this);
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public String getCurrentState() {
        return connection.getCurrentState();
    }

    public void connect() {
        connection.connect();
    }
    public void disconnect() {
        connection.disconnect();
    }
    public Connection getStat() {
        return connection;
    }
    @Override
    public void write(String data) {
        this.getStat().write(data);
    }
}
// END
