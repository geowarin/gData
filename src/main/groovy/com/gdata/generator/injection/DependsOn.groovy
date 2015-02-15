package com.gdata.generator.injection

import com.gdata.generator.Generator

import java.lang.annotation.*

/**
 *
 * Date: 14/02/15
 * Time: 14:51
 * @author Geoffroy Warin (http://geowarin.github.io)
 */

@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface DependsOn {
    Class<Generator> value() default Generator
}
