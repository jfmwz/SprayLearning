package com.example.api

import com.mongodb.casbah.MongoConnection
import com.novus.salat.dao.SalatDAO
import com.novus.salat.annotations.Key
import com.novus.salat.global._



/**
 * Created with IntelliJ IDEA.
 * User: Cat
 * Date: 10/10/13
 * Time: 18:22
 * To change this template use File | Settings | File Templates.
 */

case class Person(firstName: String, lastName: String)

case class Friend(firstName: String, lastName: String)

case class Stream(@Key("_id") id: Int, name: Person, amigos: List[Friend], streamType: String, creator: String)


object StreamDAO extends SalatDAO[Stream, Int](collection = MongoConnection("192.168.116.200")("test")("stream"))


object MyMongo {

  def insert() = {
    val stream1 = Stream(101, Person("nombre", "lastname"), List(Friend("1", "1"), Friend("2", "2")), "class", "vikas")
    StreamDAO.insert(stream1)

  }

}
