package ink.baixin.scalalearning.example

import java.io.{File, FileInputStream, FileOutputStream}

import ink.baixin.scalalearning.models.{AddressBook, Person}

object ProtocExample extends App {
  val p1 = Person(name = "Ink", id = 0, email = "ink@example.com")
  val p2 = p1.update(
    _.name := "Baixin",
    _.email := "baixin@example.com"
  )

  val a = AddressBook(Seq(p1, p2))
  println(a)

  val f = new File("address.txt")
  f.createNewFile()
  val oF = new FileOutputStream(f, false)
  oF.write(a.toByteArray)
  oF.close

  val iF = new FileInputStream(f)
  val a1 = AddressBook.parseFrom(iF)
  println(a1)
}