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

    void addField(String name, Class<Provider> generatorClass) {
//        container.registerSingleton(name, generatorClass)
        println container.getInstance(generatorClass).get()
    }

    Object generate() {
        return null
    }
}

