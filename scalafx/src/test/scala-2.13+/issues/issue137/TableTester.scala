/*
 * Copyright (c) 2011-2021, ScalaFX Project
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

package issues.issue137

import scalafx.application.JFXApp
import scalafx.application.JFXApp.PrimaryStage
import scalafx.collections.ObservableBuffer
import scalafx.scene.Scene
import scalafx.scene.control.{TableColumn, TableView}
import scalafx.scene.paint.Color

/**
 * Sample code from https://github.com/scalafx/scalafx/issues/137#issuecomment-45469050
 * In issue 137 code compilation fails on line with TableColumn
 * The issue is only reproducible in Scala 2.12, not in 2.13 and newer
 */
object TableTester extends JFXApp {

  val characters = ObservableBuffer[Person](
    new Person("Peggy", "Sue", "123", Color.Violet),
    new Person("Rocky", "Raccoon", "456", Color.GreenYellow),
    new Person("Bungalow ", "Bill", "789", Color.DarkSalmon)
  )

  stage = new PrimaryStage {
    title = "Simple Table View"
    scene = new Scene {
      content = new TableView[Person](characters) {
        columns ++= List(
          new TableColumn[Person, String] {
            text = "First Name"
            cellValueFactory = {
              _.value.firstName
            }
            prefWidth = 180
          },
          new TableColumn[Person, String]() {
            text = "Last Name"
            cellValueFactory = {
              _.value.lastName
            }
            prefWidth = 180
          }
        )
      }
    }
  }
}
