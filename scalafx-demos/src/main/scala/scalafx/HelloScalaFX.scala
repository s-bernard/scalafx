/*
 * Copyright (c) 2011-2015, ScalaFX Project
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of the ScalaFX Project nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL THE SCALAFX PROJECT OR ITS CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package scalafx

import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.scene.Scene
import scalafx.scene.effect._
import scalafx.scene.layout.HBox
import scalafx.scene.paint.Color._
import scalafx.scene.paint.{LinearGradient, Stops}
import scalafx.scene.text.Text

object HelloScalaFX extends JFXApp3 {
  override def start(): Unit = {
    stage = new PrimaryStage {
      title = "ScalaFX Hello World"
      width = 650
      height = 450
      scene = new Scene {
        fill = Black
        content = new HBox {
          children = Seq(
            new Text {
              text = "Scala"
              style = "-fx-font-size: 100pt"
              fill = new LinearGradient(endX = 0, stops = Stops(PaleGreen, SeaGreen))
            },
            new Text {
              text = "FX"
              style = "-fx-font-size: 100pt"
              fill = new LinearGradient(endX = 0, stops = Stops(Cyan, DodgerBlue))
              effect = new DropShadow {
                color = DodgerBlue
                radius = 25
                spread = 0.25d
              }
            }
          )
          effect = new Reflection {
            fraction = 0.5d
            topOffset = -5.0d
            bottomOpacity = 0.75d
            input = new Lighting { light = new Light.Distant { elevation = 60 } }
          }
        }
      }
    }
  }
}
