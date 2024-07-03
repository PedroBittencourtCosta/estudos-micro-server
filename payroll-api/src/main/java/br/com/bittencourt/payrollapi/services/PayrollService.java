package br.com.bittencourt.payrollapi.services;

import br.com.bittencourt.payrollapi.domain.Payroll;
import br.com.bittencourt.payrollapi.domain.User;
import br.com.bittencourt.payrollapi.feignClients.UserFeign;
import br.com.bittencourt.payrollapi.services.exception.ObjectNotFoundException;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.util.Objects;

@RequiredArgsConstructor
@Slf4j     // usado apenas para mostrar a parte do load balance
@Service
public class PayrollService {

    private final Environment env;
    private final UserFeign userFeign;

    public Payroll getPayment(Long workerId, Payroll payroll){
        log.info("PAYROLL_SERVICE ::: Get request on " + env.getProperty("local.server.port") + " port");

        try {
            User user = userFeign.findById(workerId).getBody();

            if(Objects.nonNull(user))  return new Payroll(
                    user.getName(),
                    payroll.getDescription(),
                    user.getHourlyPrice(),
                    payroll.getWorkerHours(),
                    user.getHourlyPrice() * payroll.getWorkerHours()
            );

        }catch (FeignException.NotFound ex){
            throw new ObjectNotFoundException("User not found");
        }catch (Exception ex){
            throw new IllegalArgumentException("Ilegal argument exception");
        }

        return null;

    }
}
