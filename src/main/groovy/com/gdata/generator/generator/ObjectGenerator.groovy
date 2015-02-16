package com.gdata.generator.generator

import com.gdata.generator.GeneratorsModule
import com.google.inject.*

/**
 *
 * Date: 14/02/15
 * Time: 14:34
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
class ObjectGenerator implements Provider {
    Map<String, Class> properties = new LinkedHashMap<>()
    Map<String, Provider> subGenerators = new LinkedHashMap<>()

    void setProperty(String property, Object value) {
        if (value instanceof Class) {
            properties.put(property, value)
        } else if (value instanceof Provider) {
            subGenerators.put(property, value)
        } else {
            throw new IllegalArgumentException()
        }
    }

    Object get() {
        Injector container = Guice.createInjector(new GeneratorsModule())
        Expando object = new Expando()
        properties.forEach { name, clazz ->
            object[name] = container.getInstance(clazz)
        }
        subGenerators.forEach { name, generator ->
            object[name] = generator.get()
        }
        return object
    }
}

