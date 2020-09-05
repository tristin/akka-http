/*
 * Copyright (C) 2009-2020 Lightbend Inc. <https://www.lightbend.com>
 */

package akka.http.scaladsl.server

package object util {
  type VarArgsFunction1[-T, +U] = (T*) => U
}
