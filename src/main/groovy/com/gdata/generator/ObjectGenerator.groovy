package com.gdata.generator

import com.gdata.generator.country.Country
import com.gdata.generator.country.CountryDataGenerator
import com.gdata.generator.name.NameDataGenerator
import com.google.inject.*

/**
 *
 * Date: 14/02/15
 * Time: 14:34
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
class ObjectGenerator extends Generator<Object> {
    private Injector container = Guice.createInjector(new MyModule())

    void addField(String name, Class<Generator> generatorClass) {
//        container.registerSingleton(name, generatorClass)
        println container.getInstance(generatorClass).generate()
    }

    @Override
    Object generate() {
        return null
    }
}

class MyModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(CountryDataGenerator).in(Singleton)
        bind(Country).toProvider(CountryDataGenerator)
        bind(NameDataGenerator)
    }
}
