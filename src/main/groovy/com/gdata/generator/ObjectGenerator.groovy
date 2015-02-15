package com.gdata.generator

import com.google.inject.*

/**
 *
 * Date: 14/02/15
 * Time: 14:34
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
class ObjectGenerator extends Generator<Object> {
    private Injector container = Guice.createInjector(new GeneratorsModule())

    void addField(String name, Class<Generator> generatorClass) {
//        container.registerSingleton(name, generatorClass)
        println container.getInstance(generatorClass).generate()
    }

    @Override
    Object generate() {
        return null
    }
}

