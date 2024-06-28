package br.com.bittencourt.payrollapi.resources;

import br.com.bittencourt.payrollapi.domain.Payroll;
import br.com.bittencourt.payrollapi.services.PayrollService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/payments")
public class PayrollResource {

    private final PayrollService payrollService;

    @GetMapping("/{workerId}")
    public ResponseEntity<Payroll> getPayment(@PathVariable Long workerId, @RequestBody Payroll payment) {

        return ResponseEntity.ok().body(payrollService.getPayment(workerId, payment));
    }
}
