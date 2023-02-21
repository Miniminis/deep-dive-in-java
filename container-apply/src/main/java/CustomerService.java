public class CustomerService {

    @Inject CustomerRepository customerRepository;

    public void join() {
        System.out.println("customerService:join");
        customerRepository.save();
    }
}
