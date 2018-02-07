package ink.baixin.scalalearning.implicits

object ContextBound extends App {

  println(maxListOrdering(List(1, 5, 10, 3)))

  // no implicit
  def maxListOrdering0[T](elements: List[T])
                         (ordering: Ordering[T]): T =
    elements match {
      case List() =>
        throw new IllegalArgumentException("empty lists!")
      case List(x) => x
      case x :: rest =>
        val maxRest = maxListOrdering0(rest)(ordering)
        if (ordering.gt(x, maxRest)) x
        else maxRest
    }

  // with implicit
  def maxListOrdering1[T](elements: List[T])
                         (implicit ordering: Ordering[T]): T =
    elements match {
      case List() =>
        throw new IllegalArgumentException("empty lists!")
      case List(x) => x
      case x :: rest =>
        val maxRest = maxListOrdering1(rest)
        if (ordering.gt(x, maxRest)) x
        else maxRest
    }

  // with implicitly
  def maxListOrdering2[T](elements: List[T])
                         (implicit ordering: Ordering[T]): T =
    elements match {
      case List() =>
        throw new IllegalArgumentException("empty lists!")
      case List(x) => x
      case x :: rest =>
        val maxRest = maxListOrdering2(rest)
        if (implicitly[Ordering[T]].gt(x, maxRest)) x
        else maxRest
    }

  // context bound
  def maxListOrdering[T: Ordering](elements: List[T])
                                  (implicit ordering: Ordering[T]): T =
    elements match {
      case List() =>
        throw new IllegalArgumentException("empty lists!")
      case List(x) => x
      case x :: rest =>
        val maxRest = maxListOrdering(rest)
        if (implicitly[Ordering[T]].gt(x, maxRest)) x
        else maxRest
    }
}
