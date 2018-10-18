package ink.baixin.scalalearning.example

import java.util.concurrent.TimeUnit
import java.util.concurrent.locks.ReentrantReadWriteLock

object LockExample extends App {
  val t1 = new Thread {
    override def run(): Unit = {
      runWithLock(this.getName ,3000, false)
    }
  }

  val t2 = new Thread {
    override def run(): Unit = {
      runWithLock(this.getName ,5000, false)
    }
  }

  val t3 = new Thread {
    override def run(): Unit = {
      runWithLock(this.getName ,7000, false)
    }
  }

  val t4 = new Thread {
    override def run(): Unit = {
      runWithLock(this.getName ,9000, true)
    }
  }

  private def runWithLock(threadName: String, time: Int, blocking: Boolean) = {
    if (!GlobalLockService.acquire(blocking)) {
      println("can't get lock!")
    }
    try {
      println(s"enter $threadName")
      val start = System.currentTimeMillis()
      Thread.sleep(time)
      val end = System.currentTimeMillis()
      println(s"leave $threadName, spend time: ${(end - start) / 1000}s")
    } finally {
      GlobalLockService.release(blocking)
    }
  }

  t1.start()
  t2.start()
  t3.start()
  t4.start()
}

object GlobalLockService {
  val lock = new ReentrantReadWriteLock()

  def acquire(blocking: Boolean) =
    if (blocking)
      lock.writeLock.tryLock(60, TimeUnit.MINUTES)
    else
      lock.readLock.tryLock(90, TimeUnit.MINUTES)

  def release(blocking: Boolean) =
    if (blocking)
      lock.writeLock.unlock()
    else
      lock.readLock.unlock()
}