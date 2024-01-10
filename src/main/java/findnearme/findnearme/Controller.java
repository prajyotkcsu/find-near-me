package findnearme.findnearme;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    ElasticsearchService elasticsearchService;
    @GetMapping("/status")
   public void findById() {
        System.out.println("status of elastic: "+elasticsearchService.isElasticsearchUp());
   }
}

//@RestController
//@RequestMapping("/api/employees")
//public class EmployeeController {
//    @Autowired
//    private EmployeeRepository repository;
//    @PostMapping
//    public Employee create(@RequestBody Employee employee) {
//        return repository.save(employee);
//    }
//    @GetMapping("/{id}")
//    public Optional<Employee> findById(@PathVariable String id) {
//        return repository.findById(id);
//    }