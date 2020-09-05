/*
 * Copyright (C) 2009-2020 Lightbend Inc. <https://www.lightbend.com>
 */

package akka.http.impl.engine.ws

import akka.annotation.InternalApi
import akka.http.impl.engine.server.InternalCustomHeader
import akka.http.scaladsl.model.HttpResponse
import akka.http.scaladsl.model.ws.UpgradeToWebSocket
import akka.http.scaladsl.model.ws.WebSocketUpgrade
import akka.stream.{ FlowShape, Graph }

/**
 * Currently internal API to handle FrameEvents directly.
 *
 * INTERNAL API
 */
@InternalApi
private[http] abstract class UpgradeToWebSocketLowLevel extends InternalCustomHeader("UpgradeToWebSocket") with UpgradeToWebSocket with WebSocketUpgrade {
  /**
   * The low-level interface to create WebSocket server based on "frames".
   * The user needs to handle control frames manually in this case.
   *
   * Returns a response to return in a request handler that will signal the
   * low-level HTTP implementation to upgrade the connection to WebSocket and
   * use the supplied handler to handle incoming WebSocket frames.
   *
   * INTERNAL API (for now)
   */
  @InternalApi
  private[http] def handleFrames(handlerFlow: Graph[FlowShape[FrameEvent, FrameEvent], Any], subprotocol: Option[String] = None): HttpResponse
}
