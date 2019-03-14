package monitorData.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 切换数据源Advice
 * <p>
 * Created by Administrator on 2017/9/25.
 */

@Aspect
@Order(-1)// 保证该AOP在@Transactional之前执行
@Component
public class DynamicDataSourceAspect {

    private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

    @Before("@annotation(dataSource)")
    public void changeDataSource(JoinPoint point, TargetDataSource dataSource) throws Throwable {
        String dsId = dataSource.name();
        if (!DynamicDataSourceContextHolder.containsDataSource(dsId)) {
            logger.error("数据源[{}]不存在，使用默认数据源 > {}", dataSource.name(), point.getSignature());
        } else {
            logger.debug("Use DataSource : {} > {}", dataSource.name(), point.getSignature());
            DynamicDataSourceContextHolder.setDataSourceType(dataSource.name());
        }
    }

    @After("@annotation(dataSource)")
    public void restoreDataSource(JoinPoint point, TargetDataSource dataSource) {
        logger.debug("Revert DataSource : {} > {}", dataSource.name(), point.getSignature());
        DynamicDataSourceContextHolder.clearDataSourceType();
    }
}
