import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
class product{
    private String name;
    private int hm;
    private double price;

    public product (String name, int hm, double price){
        this.name=name;
        this.hm=hm;
        this.price=price;
    }
    public String getName(){
        return name;
    }
    public int getHm(){
        return hm;
    }
    public double getPrice(){
        return price;
    }
}
public class streeampath {
    public static void main (String[] args){
        List<product> products = Arrays.asList(
        new product("молоко", 5, 2.5),
        new product("хліб", 3, 1.0),
        new product("яйця", 10, 0.5));

        int filterhm = 5;

        List<product> filterproducts = products.stream()
                .filter(product -> product.getHm()>filterhm)
                .collect(Collectors.toList());

        System.out.println("Відфільтровані продукти:");
        filterproducts.forEach(product -> System.out.println(product.getName()));

        writefille(filterproducts, "file.txt");

        long totalhm = products.stream()
                .mapToLong(product::getHm)
                .sum();

        System.out.println("Кількість продуктів: "+ totalhm);

        double gprice = products.stream()
                .mapToDouble(product::getPrice)
                .average()
                .orElse(0.0);

        System.out.println("Середня ціна продуктів: "+ gprice);

        List<product> listproducttoprice = products.stream()
                .sorted((p1, p2) -> Double.compare(p2.getPrice(), p1.getPrice()))
                .collect(Collectors.toList());
        System.out.println("ціни в порядку зменшення: ");
        listproducttoprice.forEach(product -> System.out.println(product.getName()));

        double totalprice = products.stream()
                .mapToDouble(product -> product.getPrice()*product.getHm())
                .sum();
        System.out.println("Чек:"+ totalprice);
    }
    public static void writefille(List<product> products, String filepath){
        List<String> lines = products.stream()
                .map(product -> String.format("%s, %d, %2f", product.getName(),product.getHm(),product.getPrice()))
                .collect(Collectors.toList());
        try{
            Files.write(Path.of(filepath), lines);
            System.out.println("список сформовано в файл: " + filepath);
        } catch (IOException e){
            System.err.println("Помилка при записі файлу: " + e.getMessage() );
        }
    }
}
