package com.gdata.generator

import com.google.inject.*

/**
 *
 * Date: 14/02/15
 * Time: 14:34
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
class ObjectGenerator {
    Map<String, Class> properties = new LinkedHashMap<>()

    void setProperty(String property, Object value) {
        if (value instanceof Class) {
            properties.put(property, value)
        } else {
            throw new IllegalArgumentException()
        }
    }

    Object generate() {
        Injector container = Guice.createInjector(new GeneratorsModule())
        Expando object = new Expando()
        properties.forEach { name, clazz ->
            object[name] = container.getInstance(clazz)
        }
        return object
    }
}

