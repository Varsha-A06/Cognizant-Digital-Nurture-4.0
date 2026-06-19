public class SearchTest {

    // Linear Search
    public static Product linearSearch(Product[] products, int id) {

        for (int i = 0; i < products.length; i++) {
            if (products[i].productId == id) {
                return products[i];
            }
        }

        return null;
    }

    // Bubble Sort
    public static void bubbleSort(Product[] products) {

        for (int i = 0; i < products.length - 1; i++) {

            for (int j = 0; j < products.length - i - 1; j++) {

                if (products[j].productId > products[j + 1].productId) {

                    Product temp = products[j];
                    products[j] = products[j + 1];
                    products[j + 1] = temp;
                }
            }
        }
    }

    // Binary Search
    public static Product binarySearch(Product[] products, int id) {

        int first = 0;
        int last = products.length - 1;

        while (first <= last) {

            int middle = (first + last) / 2;

            if (products[middle].productId == id) {
                return products[middle];
            }

            if (id < products[middle].productId) {
                last = middle - 1;
            } else {
                first = middle + 1;
            }
        }

        return null;
    }

    public static void main(String[] args) {

        Product[] products = {
                new Product(105, "Laptop", "Electronics"),
                new Product(101, "Shoes", "Fashion"),
                new Product(103, "Mobile", "Electronics"),
                new Product(104, "Watch", "Accessories"),
                new Product(102, "Bag", "Travel")
        };

        int searchId = 103;

        System.out.println("Linear Search");
        Product result = linearSearch(products, searchId);

        if (result != null) {
            result.display();
        } else {
            System.out.println("Product Not Found");
        }

        bubbleSort(products);

        System.out.println("\nBinary Search");

        result = binarySearch(products, searchId);

        if (result != null) {
            result.display();
        } else {
            System.out.println("Product Not Found");
        }
    }
}