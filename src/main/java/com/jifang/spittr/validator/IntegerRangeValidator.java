package com.jifang.spittr.validator;

import com.jifang.spittr.annotation.IntegerRange;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * author: jifang
 * date: 18-4-9 下午11:08
 */

public class IntegerRangeValidator implements ConstraintValidator<IntegerRange, Integer> {
    private Integer min;
    private Integer max;

    public void initialize(IntegerRange constraintAnnotation) {
        min = constraintAnnotation.min();
        max = constraintAnnotation.max();
    }

    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        boolean b = integer > min && integer < max ? true : false;
        return b;
    }
}
