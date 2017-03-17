/*
 * TerminalSessionSocket.java
 *
 * Copyright (C) 2009-17 by RStudio, Inc.
 *
 * Unless you have received this program directly from RStudio pursuant
 * to the terms of a commercial license agreement with RStudio, then
 * this program is licensed to you under the terms of version 3 of the
 * GNU Affero General Public License. This program is distributed WITHOUT
 * ANY EXPRESS OR IMPLIED WARRANTY, INCLUDING THOSE OF NON-INFRINGEMENT,
 * MERCHANTABILITY OR FITNESS FOR A PARTICULAR PURPOSE. Please refer to the
 * AGPL (http://www.gnu.org/licenses/agpl-3.0.txt) for more details.
 *
 */

package org.rstudio.studio.client.workbench.views.terminal;

import org.rstudio.studio.client.common.console.ConsoleOutputEvent;
import org.rstudio.studio.client.common.console.ConsoleProcess;
import org.rstudio.studio.client.workbench.views.terminal.events.TerminalDataInputEvent;
import org.rstudio.studio.client.workbench.views.terminal.xterm.XTermWidget;

import com.google.gwt.event.shared.HandlerRegistration;

/**
 * Manages input and output for the terminal session. Uses a websocket to
 * communicate with the server, falling back to RPC if unable to establish
 * a websocket connection.
 */
public class TerminalSessionSocket
   implements ConsoleOutputEvent.Handler, 
              TerminalDataInputEvent.Handler
{
   public interface Session
   {
      void receivedInput(String input);
      void receivedOutput(String output);
   }
   
   public TerminalSessionSocket(
                       Session session, 
                       ConsoleProcess consoleProcess,
                       XTermWidget xterm)
   {
      session_ = session;
      xterm_ = xterm;
   }
   
   public void connect()
   {
      // We keep this handler connected after a disconnect so
      // user input sent via RPC can wake up a suspended session
      if (terminalInputHandler_ == null)
         terminalInputHandler_ = xterm_.addTerminalDataInputHandler(this);

   }
   
   public void disconnect()
   {
      
   }

   public void dispatchInput(String input)
   {
      
   }
   
   @Override
   public void onTerminalDataInput(TerminalDataInputEvent event)
   {
      // TODO Auto-generated method stub
      
   }

   @Override
   public void onConsoleOutput(ConsoleOutputEvent event)
   {
      // TODO Auto-generated method stub
      
   }

   private final XTermWidget xterm_;
   private final Session session_;

   private HandlerRegistration terminalInputHandler_;
}
