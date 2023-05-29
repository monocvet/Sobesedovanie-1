import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    /** Есть список товаров нескольких категорий: "Книги", "Канцтовары", "Головоломки".
     * У каждого товара есть id, наименование, категория, цена.
     * Необходимо отфильтровать товары категории "Книги" по алфавиту с ценой < 500.
     * Использовать Stream API
     *
     * На выходе программы должен быть распечатан список
     * Наименование: <Наименование>, Категория: <Категория>, Стоимость (руб.): <Стоимость>
     *
     * Пример выхода
     * Наименование: Чистый код, Категория: Книги, Стоимость (руб.): 465
     * Наименование: Загадки старого леса (Бугатти), Категория: Книги, Стоимость (руб.): 156
     * Наименование: Магия мозга (Бехтерева), Категория: Книги, Стоимость (руб.): 420
     *
     */
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "Чистый код",Category.BOOKS, 465));
        products.add(new Product(2, "Загадки старого леса", Category.BOOKS, 156));
        products.add(new Product(3, "Магия мозга (Бехтерева)", Category.BOOKS, 420));
        products.add(new Product(4, "Непобедимое солнце", Category.BOOKS, 640));
        products.add(new Product(5, "Война и Мир", Category.BOOKS, 499));
        products.add(new Product(6, "Ручка синяя", Category.STATIONERY, 85));
        products.add(new Product(7, "Сложный пазл", Category.PUZZLES, 230));

        products = products.stream()
                .filter(a -> a.getCategory().equals(Category.BOOKS) && a.getPrice() < 500)
                .sorted(Comparator.comparing(Product::getName))
                .collect(Collectors.toList());
        System.out.println("Книги стоимостью менее 500 рублей по алфавиту:");
        for (Product product : products) {
            System.out.println("Наименование: " + product.getName() + ", " +
                    "Категория: " + product.getCategory().getName() + ", " +
                    "Стоимость (руб.): "+ product.getPrice());
        }

    }
}