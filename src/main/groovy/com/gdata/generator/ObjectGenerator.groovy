package com.gdata.generator

import com.google.inject.*

/**
 *
 * Date: 14/02/15
 * Time: 14:34
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
class ObjectGenerator {
    private Injector container = Guice.createInjector(new GeneratorsModule())
    private Expando object = new Expando()

    void setProperty(String property, Object value) {
        if (value instanceof Class) {
            object[property] = container.getInstance((Class) value)
        } else {
            throw new IllegalArgumentException()
        }
    }

    Object generate() {
        return object
    }
}

