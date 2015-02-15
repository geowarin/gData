package com.gdata.generator

import com.gdata.generator.injection.GeneratorContainer

/**
 *
 * Date: 14/02/15
 * Time: 14:34
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
class ObjectGenerator extends Generator<Object> {
    private GeneratorContainer container = new GeneratorContainer()

    void addField(String name, Class<Generator> generatorClass) {
        container.define(name, generatorClass)
    }

    @Override
    Object generate() {
        return container.generators
    }
}

