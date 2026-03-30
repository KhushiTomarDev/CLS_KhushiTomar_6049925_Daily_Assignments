package com.example.Assignment7.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Assignment7.Entities.Trainee;
import com.example.Assignment7.Exceptions.TraineeIdNotFound;
import com.example.Assignment7.Service.ITraineeService;

import jakarta.validation.Valid;


@RestController
//@RequestMapping("/trainees") //i dont have to writes trainees again n again

//public class TraineeController {
//	
//	@Autowired
//	ITraineeService iTraineeService;
//	
//	@GetMapping("/trainees")
//	List<Trainee> getAllTrainees(){
//		return iTraineeService.getAllTrainees();
//	}
//	
//	@GetMapping("/trainees/{id}")
//    public Trainee getTrainee(@PathVariable int id) {
//        Optional<Trainee> trainee = iTraineeService.getTrainee(id);
//
//        if (trainee.isPresent()) {
//            return trainee.get();
//        }
//        return null;
//    }
////	@GetMapping("/trainees/{id}")
////    public ResponseEntity<Trainee> getTrainee(@PathVariable int id) {
////        Optional<Trainee> trainee = iTraineeService.getTrainee(id);
////        Trainee t=null;
////        if (trainee.isPresent()) {
////            t =  trainee.get();
////           // return new ResponseEntity<>(t,HttpStatus.ACCEPTED);
////            return ResponseEntity.ok(t);
////        
////        }
////        else {
////     
////        	return new ResponseEntity<>(t,HttpStatus.NOT_FOUND);
////        }
////    }
//
//    @GetMapping("/trainees/BytraineeName")
//    public ResponseEntity<Trainee> findBytraineeName(@RequestParam ("name") String tname) {
//        Optional<Trainee> trainee = iTraineeService.findBytraineeName(tname);
//
//        Trainee t=null;
//        if (trainee.isPresent()) {
//            t =  trainee.get();
//           // return new ResponseEntity<>(t,HttpStatus.ACCEPTED);
//            return ResponseEntity.ok(t);
//        
//        }
//        else {
//     
//        	return new ResponseEntity<>(t,HttpStatus.NOT_FOUND);
//        }
//    }
////    @GetMapping("/trainees/BytraineeName/{name}")
////    public Trainee findBytraineeName(@PathVariable String name) {
////        Optional<Trainee> trainee = iTraineeService.findBytraineeName(name);
////
////        if (trainee.isPresent()) {
////            return trainee.get();
////        }
////        return null;
////    }
//
//    @PostMapping("/trainees")
//    public ResponseEntity<Trainee> addTrainee(@Valid @RequestBody Trainee trainee) {
//        Trainee t = iTraineeService.addTrainee(trainee);
//        return ResponseEntity.ok(t);
//    }
//
//    @PutMapping("/trainees/{id}")
//    public ResponseEntity<Trainee> updateTrainee(@PathVariable int id, @RequestBody Trainee trainee) {
//
//        Trainee updated = iTraineeService.updateTrainee(id, trainee);
//        return ResponseEntity.ok(updated);
//    }
//    
//    @SuppressWarnings("unchecked")
//	@DeleteMapping("/trainees/{id}")
//    public ResponseEntity<String> deleteTrainee(@PathVariable int id) {
//
//        boolean status = iTraineeService.deleteTrainee(id);
//
//        if (status) {
//        	return ResponseEntity.ok("Trainee deleted successfully");
//           // return "Trainee deleted successfully";
//        } else {
//           // return "Trainee not found";
//        	return (ResponseEntity<String>) ResponseEntity.badRequest();
//        }
//    }
////    //Controller Level Exception Handling
////    @ExceptionHandler(TraineeIdNotFound.class)
////    ResponseEntity<String> handlerForIdNotFoundExcepti(TraineeIdNotFound ee)  {
////    	return new ResponseEntity<>(ee.getMessage(),HttpStatus.NOT_FOUND);
////    }
//    }



public class TraineeController {
	
	@Autowired
	ITraineeService iTraineeService;
	
	@GetMapping("/trainees")
  public List<Trainee> getAllTrainees(){
		return iTraineeService.getAllTrainees();
	}
	
	@GetMapping("/trainees/{id}")
    public Trainee getTrainee(@PathVariable int id) {
        Optional<Trainee> trainee = iTraineeService.getTrainee(id);

        if (trainee.isPresent()) {
            return trainee.get();
        }
        return null;
    }

    @GetMapping("/trainees/BytraineeName/{name}")
    public Trainee findBytraineeName(@PathVariable String name) {
        Optional<Trainee> trainee = iTraineeService.findBytraineeName(name);

        if (trainee.isPresent()) {
            return trainee.get();
        }
        return null;
    }

    @PostMapping("/trainees")
    public Trainee addTrainee(@Valid @RequestBody Trainee trainee) {
        return iTraineeService.addTrainee(trainee);
    }

    @PutMapping("/trainees/{id}")
    public Trainee updateTrainee(@PathVariable int id, @RequestBody Trainee trainee) {

        Trainee updated = iTraineeService.updateTrainee(id, trainee);
        return updated;
    }
    
    @DeleteMapping("/trainees/{id}")
    public String deleteTrainee(@PathVariable int id) {

        boolean status = iTraineeService.deleteTrainee(id);

        if (status) {
            return "Trainee deleted successfully";
        } else {
            return "Trainee not found";
        }
    }
    }
