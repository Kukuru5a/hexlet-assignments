package exercise.repository;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

import exercise.model.Product;

import java.sql.SQLException;
import java.sql.Statement;

public class ProductsRepository extends BaseRepository {

    // BEGIN
    public static void save(Product product) throws SQLException {
        var sql = "INSERT INTO products (title, price) VALUES (?, ?)";
        try(var conn = dataSource.getConnection();
            var prepSt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            prepSt.setString(1, product.getTitle());
            prepSt.setInt(2, product.getPrice());
            prepSt.executeUpdate();
            var generateKeys = prepSt.getGeneratedKeys();
            if(generateKeys.next()) {
                product.setId(generateKeys.getLong(1));
            } else {
                throw new SQLException("DB have not returned an id after saving an entity");
            }
        }
    }

    public static Optional<Product> find (Long id) throws SQLException {
        var sql = "SELECT * FROM products WHERE id = ?";
        try (var conn = dataSource.getConnection();
        var stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            var resSet = stmt.executeQuery();
            if (resSet.next()) {
                var title = resSet.getString("title");
                var price = resSet.getInt("price");
                var product = new Product(title, price);
                product.setId(id);
                return Optional.of(product);
            }
            return Optional.empty();
        }
    }

    public static List<Product> getEntities () throws SQLException {
        var sql = "SELECT * FROM products";
        try(var conn = dataSource.getConnection();
        var stmt = conn.prepareStatement(sql)) {
            var resSet = stmt.executeQuery();
            var res = new ArrayList<Product>();

            while (resSet.next()) {
                var id = resSet.getLong("id");
                var title = resSet.getString("title");
                var price = resSet.getInt("price");
                var product = new Product(title, price);
                product.setId(id);
                res.add(product);
            }
            return res;
        }
    }
    // END
}
