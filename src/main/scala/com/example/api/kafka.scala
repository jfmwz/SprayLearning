package com.example.api

/**
 * Created with IntelliJ IDEA.
 * User: Cat
 * Date: 11/10/13
 * Time: 19:45
 * To change this template use File | Settings | File Templates.
 */

import java.util.Properties
import kafka.server.KafkaServer
import kafka.server.KafkaConfig
import kafka.producer.{KeyedMessage, ProducerConfig, Producer}
import kafka.message.Message

import kafka.consumer.ConsumerConfig
import kafka.consumer.Consumer
import kafka.utils.Utils
import kafka.consumer.SimpleConsumer
import kafka.api.{PartitionFetchInfo, FetchRequest}
import kafka.common.TopicAndPartition
import scala.collection.immutable.Stream.cons

object KafkaEmbedded {

  val props = new Properties()
  props.setProperty("hostname", "localhost")
  props.setProperty("port", "9092");
  props.setProperty("brokerid", "1")
  props.setProperty("log.dir", "/tmp/embeddedkafka/")
  props.setProperty("enable.zookeeper", "false")

  //val server = new KafkaServer(new KafkaConfig(props))
  //server.startup()

  val prodProps = new Properties()
  prodProps.setProperty("producer.type", "async")
  //prodProps.setProperty("queue.time", "2000")
  //prodProps.setProperty("queue.size", "100")
  //prodProps.setProperty("batch.size", "1000")
  prodProps.setProperty("serializer.class", "kafka.serializer.StringEncoder")
  prodProps.setProperty("broker.list", "192.168.116.200:9092")

  val prodConfig = new ProducerConfig(prodProps)
  //val prod = new Producer[String, Message](prodConfig)
  val prod = new Producer[String, String](prodConfig)

  def producir() = {
    for (i <- 1 to 200) {
      //prod.send(new KeyedMessage("scala10","scala10", new Message("testing 1 2 3".getBytes)))
      prod.send(new KeyedMessage("scala10","scala10", "testing 1 2 3"))
    }
    //prod.close()
  }

  def consumir() = {
    val cons = new SimpleConsumer("192.168.116.200", 9090, 100, 1024, "101")
    var offset = 0L

    var i = 0
    while (true) {
      val fetchRequest = new FetchRequest(101, "TEST", 0, 10, Map(TopicAndPartition("scala10", 0) -> PartitionFetchInfo(offset, 0)))

      /*
      for (fetchResponse <- cons.fetch(fetchRequest)) {
        i = i + 1
        println("consumed [ " + i + "]: offset = " + fetchResponse.offset + ", payload = " + Utils.toString(msg.message.payload, "UTF-8"))
        offset = msg.offset
      }
      */
    }
  }

  /*
  sys.addShutdownHook({
    prod.close()
    cons.close()
    //server.shutdown()
    //server.awaitShutdown()
  })
  */
}