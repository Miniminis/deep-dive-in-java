public class Main {
    public static void main(String[] args) {
        CustomerService customerService = FlashContainer.getObject(CustomerService.class);
        customerService.join();

        //customerService:join
        //customerRepository:save
    }
}
