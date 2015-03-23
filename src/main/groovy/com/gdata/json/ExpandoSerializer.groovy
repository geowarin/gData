package com.gdata.json

import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import org.codehaus.groovy.runtime.DefaultGroovyMethods

import java.lang.reflect.Type

/**
 *
 * Date: 23/03/15
 * Time: 23:34
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
class ExpandoSerializer implements JsonSerializer<Expando> {
    JsonElement serialize(Expando src, Type typeOfSrc, JsonSerializationContext context) {
        def object = new JsonObject()
        src.properties.each { k, v ->
            def isGData = v.class.package.name.startsWith('com.gdata')
            if (isGData) {
                object.addProperty(k, v.toString())
            } else {
                object.add(k, context.serialize(v))
            }
        }
        object
    }
}
