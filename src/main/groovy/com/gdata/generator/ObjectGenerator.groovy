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

    void addField(String name, Class generatorClass) {
        object[name] = container.getInstance(generatorClass)
    }

    Object generate() {
        return object
    }
}

