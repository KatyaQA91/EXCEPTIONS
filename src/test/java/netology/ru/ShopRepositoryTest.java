package netology.ru;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShopRepositoryTest {

    Product product1 = new Product(021, "Футболка", 35);
    Product product2 = new Product(013, "Книга", 20);
    Product product3 = new Product(011, "Кепка", 30);

    Product product4 = new Product(021, "Футболка", 50);




    @Test
    public void removingTheProductTest(){
        ShopRepository repo = new ShopRepository();

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        repo.remove(013);
        Product[] expected = {product1, product3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);

    }
    @Test
    public void TestProduct() {
        ShopRepository repo = new ShopRepository();

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Product[] expected = {product1, product2, product3};
        Product[] actual = repo.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void TestRemovingNotExistentTheProduct(){  //+
        ShopRepository repo = new ShopRepository();

        repo.add(product1);
        repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(NotFoundException.class, () ->{repo.remove(100);});

    }

    @Test
    public void TestProductNumberTwo(){
        ShopRepository repo = new ShopRepository();

       repo.add(product1);
       repo.add(product2);
        repo.add(product3);

        Assertions.assertThrows(AlreadyExistsException.class, () ->{repo.add(product4);});

    }
}