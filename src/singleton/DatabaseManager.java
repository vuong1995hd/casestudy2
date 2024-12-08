package singleton;

public class DatabaseManager {
    private static DatabaseManager instance;

    private DatabaseManager() {
        // Khởi tạo kết nối cơ sở dữ liệu hoặc các tài nguyên chung ở đây
    }

    public static DatabaseManager getInstance() {
        if (instance == null) {
            instance = new DatabaseManager();
        }
        return instance;
    }

    public void connect() {
        System.out.println("Kết nối đến cơ sở dữ liệu...");
    }

    public void disconnect() {
        System.out.println("Ngắt kết nối cơ sở dữ liệu...");
    }
}

