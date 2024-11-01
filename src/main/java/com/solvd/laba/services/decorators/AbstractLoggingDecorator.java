package com.solvd.laba.services.decorators;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public abstract class AbstractLoggingDecorator {
    protected static final Logger logger = LoggerFactory.getLogger(AbstractLoggingDecorator.class);

    protected void logMethodEntry(String methodName, Object... params) {
        logger.info("Entering method {} with parameters: {}", methodName, Arrays.toString(params));
    }

    protected void logMethodExit(String methodName, Object result) {
        logger.info("Exiting method {} with result: {}", methodName, result);
    }

    protected void logException(String methodName, Exception e) {
        logger.error("Exception in method {}: {}", methodName, e.getMessage(), e);
    }
}