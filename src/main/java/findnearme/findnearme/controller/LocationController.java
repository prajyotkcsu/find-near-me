//package findnearme.findnearme.controller;
//
//import findnearme.findnearme.model.Store;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@Slf4j
//
//public class LocationController {
//    @PostMapping("/store/add")
//    public void produce(@RequestBody Store store) {
//        log.info("New task list arrived: {}",store);
//
//    }
//    @GetMapping("/store/{storeId}")
//    public void consume(@PathVariable String storeId) {
//        //less likely used
//    }
//    @GetMapping("/store/{type}")
//    public void consume(@PathVariable String type) {
//        //return all stores.
//    }
//    @GetMapping("/store/{type}")
//    public void consume() {
//        //return all stores.
//    }
//}
//
