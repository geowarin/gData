package com.gdata.generator.injection

/**
 *
 * Date: 15/02/15
 * Time: 02:35
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
class UnsatisfiedDependencyException extends Exception {
    UnsatisfiedDependencyException(String message) {
        super(message)
    }
}
