package web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// Import your Calculator class - adjust package if your Calculator is in a package
// e.g. import com.example.calculator.Calculator;
import Calculator; // if Calculator is in default package; else change to real package

@RestController
@RequestMapping("/api")
public class CalculatorRestController {

    private final Calculator calc = new Calculator("web_calc");

    // GET /api/add?a=10&b=5
    @GetMapping("/add")
    public ResponseEntity<Double> add(@RequestParam double a, @RequestParam double b) {
        return ResponseEntity.ok(calc.add(a, b));
    }

    @GetMapping("/subtract")
    public ResponseEntity<Double> subtract(@RequestParam double a, @RequestParam double b) {
        return ResponseEntity.ok(calc.subtract(a, b));
    }

    @GetMapping("/multiply")
    public ResponseEntity<Double> multiply(@RequestParam double a, @RequestParam double b) {
        return ResponseEntity.ok(calc.multiply(a, b));
    }

    @GetMapping("/divide")
    public ResponseEntity<Double> divide(@RequestParam double a, @RequestParam double b) {
        return ResponseEntity.ok(calc.divide(a, b));
    }

    @GetMapping("/power")
    public ResponseEntity<Double> power(@RequestParam double a, @RequestParam int b) {
        return ResponseEntity.ok(calc.power(a, b));
    }

    @GetMapping("/sqrt")
    public ResponseEntity<Double> sqrt(@RequestParam double a) {
        return ResponseEntity.ok(calc.sqrt_f(a));
    }

    @GetMapping("/log")
    public ResponseEntity<Double> log(@RequestParam double a) {
        return ResponseEntity.ok(calc.logarithm(a));
    }

    @GetMapping("/factorial")
    public ResponseEntity<Integer> factorial(@RequestParam int n) {
        return ResponseEntity.ok(calc.factorial(n));
    }
}
