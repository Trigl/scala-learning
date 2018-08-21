package ink.baixin.scalalearning.calcite

import java.sql.DriverManager
import java.util.Properties

import org.apache.calcite.adapter.java.ReflectiveSchema
import org.apache.calcite.jdbc.CalciteConnection

class HrSchema {
  case class Employee(empid: Int, deptno: Int)
  case class Department(deptid: Int, deptno: Int)
  final val emps = (
    Employee(1, 100),
    Employee(2, 200),
    Employee(3, 100),
    Employee(4, 300),
  )

  final val depts = (
    Department(1, 100),
    Department(2, 200),
    Department(3, 300),
  )

}


object CalciteDemo extends App {
  Class.forName("org.apache.calcite.jdbc.Driver")
  val info = new Properties()
  info.setProperty("lex", "JAVA")
  val connection = DriverManager.getConnection("jdbc:calcite:", info)
  val calciteConnection = connection.unwrap(classOf[CalciteConnection])
  val rootSchema = calciteConnection.getRootSchema
  rootSchema.add("hr", new ReflectiveSchema(new HrSchema()))
//  val schema = rootSchema.add("s", new AbstractSchema())
//  calciteConnection.setSchema("hr")

  val statement = calciteConnection.createStatement()
  val resultSet = statement.executeQuery(
    """
      |select d.deptno, min(e.empid)
      |from hr.emps as e
      |join hr.depts as d on e.deptno = d.deptno
      |group by d.deptno
      |having count(*) > 1
    """.stripMargin
  )
  println(resultSet)
  resultSet.close()
  statement.close()
  connection.close()

}
