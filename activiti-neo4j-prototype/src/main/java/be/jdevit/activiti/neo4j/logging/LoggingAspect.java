package be.jdevit.activiti.neo4j.logging;

import be.jdevit.activiti.neo4j.logging.formatters.GenericFormatter;
import be.jdevit.activiti.neo4j.logging.formatters.TypeFormatter;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Aspect
@Component
public class LoggingAspect {

    @Autowired
    protected GenericFormatter genericFormatter;

    @Around("execution(* be.jdevit.activiti.neo4j.manager.*.*(..))")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
        StringBuilder sb = new StringBuilder();

        sb.append(joinPoint.getTarget().getClass().getSimpleName());
        sb.append(".");
        sb.append(joinPoint.getSignature().getName());
        sb.append("(");
        boolean sep = false;
        for (Object o : joinPoint.getArgs()) {
            if (sep) {
                sb.append(", ");
            } else {
                sep = true;
            }
            sb.append(genericFormatter.format(o));
        }
        sb.append(")");

        Object retVal = null;
        try {
            retVal = joinPoint.proceed();
        } finally {
            sb.append(" : ");
            sb.append(genericFormatter.format(retVal));
            System.out.println(sb.toString());
        }

        return retVal;
    }

}
