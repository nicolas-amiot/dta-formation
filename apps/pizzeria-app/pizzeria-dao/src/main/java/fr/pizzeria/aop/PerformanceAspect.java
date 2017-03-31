package fr.pizzeria.aop;

import java.time.LocalDateTime;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import fr.pizzeria.modele.Performance;
import fr.pizzeria.repos.PerformanceRepository;

@Component
@Transactional
@Aspect
public class PerformanceAspect {
	
	@Autowired
	private PerformanceRepository perfRepository;
	
	@Around("execution(* fr.pizzeria.dao.PizzaDaoSpringJpaImpl.*(..))")
	private Object addPerformance(ProceedingJoinPoint pjp) {
		LocalDateTime date = LocalDateTime.now();
		String service = pjp.getSignature().toString();
		long startTime = System.currentTimeMillis();
		try {
			Object proceed  =pjp.proceed();
			long endTime = System.currentTimeMillis();
			perfRepository.save(new Performance(service, date, endTime - startTime));
			return proceed;
		} catch (Throwable e) {
			e.printStackTrace();
			return null;
		}
	}

}
