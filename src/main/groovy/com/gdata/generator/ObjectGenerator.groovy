package com.gdata.generator

import com.gdata.generator.injection.GeneratorContainer

/**
 *
 * Date: 14/02/15
 * Time: 14:34
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
class ObjectGenerator extends Generator<Expando> {
    private final Expando object = new Expando()
    private GeneratorContainer container = new GeneratorContainer()

    void addField(String name, Class<Generator> generatorClass) {
        container.define(name, generatorClass)
    }

    @Override
    Expando generate() {
        Map<String, Generator> generators = container.generators
        println generators
        return object
    }


}

