package com.wipro.practice;
/*
  Stream API Activity::

1.class Product::
id:Long
name:String
category:String
price:Double


2. class Customer:
id:Long
name:String
tier:Integer

3.class Order:
id:Long
status:String
orderDate:LocalDate
deliveryDate:LocalDate
products:List<Product>
customer:Customer

1.Obtain a list of products belongs to category  Books  with price > 100
2.Obtain a list of order with products belong to category  Baby 
3.Obtain a list of product with category =  Toys  and then apply 10% discount
4.Obtain a list of products ordered by customer of tier 2 between 01-Feb-2021 and 01-Apr-2021
5.Get the cheapest products of  Books  category hint: use findFirst()
6.Get the 3 most recent placed order( sort the order records by order date field. The tricky part is that the sorting this time should be in descending order such that you can obtain the order records with the most recent order date.)
7.Calculate total lump sum of all orders placed in Feb 2021
8.Obtain a collection of statistic figures (i.e. sum, average, max, min, count) for all products of category  Books 
What if you need to get sum, average, max, min and count at the same time? Should we run the data stream 5 times to get those figures one by one? Such an approach is not quite effective. Luckily, stream API provides a convenient way to get all those values at once by using terminal operation summaryStatistics(). It returns a data type DoubleSummaryStatistics which contains all the required figures.
9.Get the most expensive product by category hint:use Collectors.maxBy()

 */



import java.time.LocalDate;
import java.util.*;
import java.util.stream.*;
import java.util.List;

class Product {
    Long id;
    String name;
    String category;
    Double price;

    Product(Long id, String name, String category, Double price) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String toString() {
        return name + " (" + category + ") - Rs." + price;
    }
}


class Customer {
    Long id;
    String name;
    Integer tier;

    Customer(Long id, String name, Integer tier) {
        this.id = id;
        this.name = name;
        this.tier = tier;
    }
}

class Order {
    Long id;
    String status;
    LocalDate orderDate;
    LocalDate deliveryDate;
    List<Product> products;
    Customer customer;

    Order(Long id, String status, LocalDate orderDate, LocalDate deliveryDate, List<Product> products, Customer customer) {
        this.id = id;
        this.status = status;
        this.orderDate = orderDate;
        this.deliveryDate = deliveryDate;
        this.products = products;
        this.customer = customer;
    }

    public String toString() {
        return "Order " + id + " [" + status + "] " + orderDate;
    }
}


public class StreamAPIActivity {
    public static void main(String[] args) {
        // Products
        Product p1 = new Product(1L, "Java Book", "Books", 150.0);
        Product p2 = new Product(2L, "Baby Toy", "Baby", 80.0);
        Product p3 = new Product(3L, "Teddy", "Toys", 200.0);
        Product p4 = new Product(4L, "Comic", "Books", 90.0);
        Product p5 = new Product(5L, "Lego", "Toys", 300.0);

        // Customers
        Customer c1 = new Customer(1L, "Ravi", 2);
        Customer c2 = new Customer(2L, "Priya", 1);

        // Orders
        Order o1 = new Order(1L, "Delivered", LocalDate.of(2021, 2, 10), LocalDate.of(2021, 2, 15), Arrays.asList(p1, p2), c1);
        Order o2 = new Order(2L, "Pending", LocalDate.of(2021, 3, 5), LocalDate.of(2021, 3, 12), Arrays.asList(p3, p4), c1);
        Order o3 = new Order(3L, "Shipped", LocalDate.of(2021, 4, 2), LocalDate.of(2021, 4, 8), Arrays.asList(p5), c2);

        List<Order> orders = Arrays.asList(o1, o2, o3);

        // 1. Books with price > 100
        System.out.println("\nBooks > Rs.100:");
        orders.stream()
            .flatMap(o -> o.products.stream())
            .filter(p -> p.category.equals("Books") && p.price > 100)
            .forEach(System.out::println);

        // 2. Orders with Baby products
        System.out.println("\nOrders with Baby products:");
        orders.stream()
            .filter(o -> o.products.stream().anyMatch(p -> p.category.equals("Baby")))
            .forEach(System.out::println);

        // 3. Toys with 10% discount
        System.out.println("\nToys with 10% discount:");
        orders.stream()
            .flatMap(o -> o.products.stream())
            .filter(p -> p.category.equals("Toys"))
            .map(p -> new Product(p.id, p.name, p.category, p.price * 0.9))
            .forEach(System.out::println);

        // 4. Tier 2 customers between 1-Feb and 1-Apr
        System.out.println("\nTier 2 orders between 01-Feb and 01-Apr 2021:");
        orders.stream()
            .filter(o -> o.customer.tier == 2 &&
                    (o.orderDate.isAfter(LocalDate.of(2021, 1, 31)) &&
                     o.orderDate.isBefore(LocalDate.of(2021, 4, 2))))
            .forEach(System.out::println);

        // 5. Cheapest Book
        System.out.println("\nCheapest Book:");
        orders.stream()
            .flatMap(o -> o.products.stream())
            .filter(p -> p.category.equals("Books"))
            .sorted(Comparator.comparingDouble(p -> p.price))
            .findFirst()
            .ifPresent(System.out::println);

        // 6. 3 Most Recent Orders
        System.out.println("\n3 Most Recent Orders:");
        orders.stream()
            .sorted((o1x, o2x) -> o2x.orderDate.compareTo(o1x.orderDate))
            .limit(3)
            .forEach(System.out::println);

        // 7. Total amount in Feb 2021
        System.out.println("\nTotal Order Amount in Feb 2021:");
        double total = orders.stream()
            .filter(o -> o.orderDate.getMonthValue() == 2 && o.orderDate.getYear() == 2021)
            .flatMap(o -> o.products.stream())
            .mapToDouble(p -> p.price)
            .sum();
        System.out.println("Rs. " + total);

        // 8. Book Stats
        System.out.println("\nBook Price Statistics:");
        DoubleSummaryStatistics stats = orders.stream()
            .flatMap(o -> o.products.stream())
            .filter(p -> p.category.equals("Books"))
            .mapToDouble(p -> p.price)
            .summaryStatistics();
        System.out.println(stats);

        // 9. Most Expensive Product by Category
        System.out.println("\nMost Expensive Product by Category:");
        orders.stream()
            .flatMap(o -> o.products.stream())
            .collect(Collectors.groupingBy(p -> p.category,
                Collectors.maxBy(Comparator.comparingDouble(p -> p.price))))
            .forEach((category, product) -> System.out.println(category + ": " + product.get()));
    }
}


/*
 
Books > Rs.100:
Java Book (Books) - Rs.150.0

Orders with Baby products:
Order 1 [Delivered] 2021-02-10

Toys with 10% discount:
Teddy (Toys) - Rs.180.0
Lego (Toys) - Rs.270.0

Tier 2 orders between 01-Feb and 01-Apr 2021:
Order 1 [Delivered] 2021-02-10
Order 2 [Pending] 2021-03-05

Cheapest Book:
Comic (Books) - Rs.90.0

3 Most Recent Orders:
Order 3 [Shipped] 2021-04-02
Order 2 [Pending] 2021-03-05
Order 1 [Delivered] 2021-02-10

Total Order Amount in Feb 2021:
Rs. 230.0

Book Price Statistics:
DoubleSummaryStatistics{count=2, sum=240.000000, min=90.000000, average=120.000000, max=150.000000}

Most Expensive Product by Category:
Toys: Lego (Toys) - Rs.300.0
Baby: Baby Toy (Baby) - Rs.80.0
Books: Java Book (Books) - Rs.150.0
 
 */
