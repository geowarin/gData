package com.gdata.generator.injection

import com.gdata.generator.Generator

/**
 *
 * Date: 15/02/15
 * Time: 02:23
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
class GeneratorContainer {
    Map<Class<Generator>, Object> instances = new HashMap<>()
    Map<String, GeneratorRef> definitions = new LinkedHashMap<>()

    void define(String name, Class<Generator> generatorClass) {
        def generatorRef = new GeneratorRef(generatorClass)
        definitions.put(name, generatorRef)
        if (generatorRef.hasNoDependencies()) {
            instantiate(generatorRef)
        }
    }

    private boolean instantiate(GeneratorRef generatorRef) {
        def generator = generatorRef.create()
        if (generator) {
            instances.put(generatorRef.generatorClass, generatorRef.value)
        }
        return generator
    }

    Map<String, Generator> getGenerators() {
        Collection<GeneratorRef> nonInstantiated
        while (nonInstantiated = definitions.findAll { it.value.instance == null }.values()) {
            boolean hasInstantiated = false
            nonInstantiated.forEach {
                hasInstantiated |= instantiate(it)
            }
            if (!hasInstantiated)
                throw new UnsatisfiedDependencyException("")
        }
        return definitions.collectEntries { key, ref -> [(key): ref.value] }
    }

    private class GeneratorRef {
        Class<Generator> generatorClass
        List<Class<Generator>> dependencies
        Generator instance
        Object value

        GeneratorRef(Class<Generator> generatorClass) {
            this.generatorClass = generatorClass
            this.dependencies = getDependencies(generatorClass)
        }

        Generator create() {
            def satisfiedDeps = dependencies.collect { instances.get(it) }
            if (satisfiedDeps.size() == dependencies.size()) {
                instance = generatorClass.newInstance(*satisfiedDeps)
                value = instance.generate()
            }
            instance
        }

        boolean hasNoDependencies() {
            dependencies.empty
        }

        static List<Class<Generator>> getDependencies(Class<Generator> generatorClass) {
            return generatorClass.getAnnotationsByType(DependsOn).collect { it.value() }
        }
    }
}
