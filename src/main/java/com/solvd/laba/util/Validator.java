package com.solvd.laba.util;

import com.solvd.laba.exceptions.ValidationException;

public interface Validator<T> {
    void validate(T entity) throws ValidationException;
}

