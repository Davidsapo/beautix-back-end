package com.beautix.backend.common.utils;

import com.beautix.backend.common.exceptions.CustomException;

import java.util.function.Supplier;

/**
 * Exception Thrower.
 *
 * @author David Sapozhnik
 */
public final class ExceptionThrower {

    private ExceptionThrower() {
    }

    public static <T extends CustomException> void throwsIf(boolean condition, Supplier<T> exceptionSupplier) throws T {
        if (condition) {
            throw exceptionSupplier.get();
        }
    }
}
