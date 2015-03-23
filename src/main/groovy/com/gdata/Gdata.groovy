package com.gdata

import com.gdata.generator.country.Country
import com.gdata.generator.generator.*
import com.gdata.generator.person.*
import com.gdata.json.ExpandoSerializer
import com.google.gson.*

/**
 *
 * Date: 14/02/15
 * Time: 12:17
 * @author Geoffroy Warin (http://geowarin.github.io)
 */
class Gdata {

    static void main(String[] args) {
        ObjectGenerator managerGenerator = new ObjectGenerator()
        managerGenerator.name = FirstName

        ObjectGenerator personGenerator = new ObjectGenerator()
        personGenerator.country = Country
        personGenerator.gender = Gender
        personGenerator.name = FirstName
        personGenerator.lastName = LastName
        personGenerator.email = Email
        personGenerator.managers = new ListGenerator(managerGenerator, 1, 2)


        List randomPersons = new ListGenerator(personGenerator, 2).get()

        println new GsonBuilder()
                .registerTypeAdapter(Expando.class, new ExpandoSerializer())
                .setPrettyPrinting()
                .create()
                .toJson(randomPersons)
    }
}

