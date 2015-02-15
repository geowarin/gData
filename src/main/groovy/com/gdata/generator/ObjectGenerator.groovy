package com.gdata.generator

import org.springframework.context.support.StaticApplicationContext

/**
 *
 * Date: 14/02/15
 * Time: 14:34
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
class ObjectGenerator extends Generator<Object> {
    private StaticApplicationContext container = new StaticApplicationContext()

    void addField(String name, Class<Generator> generatorClass) {
        container.registerSingleton(name, generatorClass)
    }

    @Override
    Object generate() {
        List<String> names = container.beanDefinitionNames
        return names.collectEntries { [(it): container.getBean(it).generate()] }
    }
}

