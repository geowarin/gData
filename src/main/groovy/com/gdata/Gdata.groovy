package com.gdata

import com.gdata.generator.generator.ListGenerator
import com.gdata.generator.generator.ObjectGenerator
import com.gdata.generator.country.Country
import com.gdata.generator.person.Email
import com.gdata.generator.person.FirstName
import com.gdata.generator.person.Gender
import com.gdata.generator.person.LastName

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
//
        ObjectGenerator personGenerator = new ObjectGenerator()
        personGenerator.country = Country
        personGenerator.gender = Gender
        personGenerator.name = FirstName
        personGenerator.lastName = LastName
        personGenerator.email = Email
        personGenerator.managers = new ListGenerator(managerGenerator, 1, 2)
        println new ListGenerator(personGenerator, 2).get()
    }
}
