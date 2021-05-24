/*
 * Copyright (c) 2011-2020, ScalaFX Project
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
package scalafx.scene.control.cell

import javafx.scene.control.{cell => jfxscc}
import javafx.scene.{control => jfxsc}
import javafx.{collections => jfxc, util => jfxu}
import scalafx.Includes._
import scalafx.collections.ObservableBuffer
import scalafx.delegate.SFXDelegate
import scalafx.scene.control.{ListCell, ListView}
import scalafx.util.StringConverter
import scalafx.util.StringConverter.sfxStringConverter2jfx

import scala.language.implicitConversions

/**
 * Companion Object for [[scalafx.scene.control.cell.ChoiceBoxListCell]].
 *
 * @define
 *   CBLC `ChoiceBoxListCell`
 * @define
 *   FLVINIT Creates a `ChoiceBox` cell factory for use in `ListView` controls.
 * @define
 *   TTYPE The type of the elements contained within the `ListView`.
 * @define
 *   CONVPARAM A `StringConverter` to convert the given item (of type T) to a String for displaying to the user.
 * @define
 *   ITEMSPARAM Zero or more items that will be shown to the user when the ChoiceBox menu is showing.
 * @define
 *   BUFITEMSPARAM A `ObservableBuffer` containing $ITEMSPARAM
 * @define
 *   FTVRET A Function that will return a ListCell that is able to work on the type of element contained within the
 *   ListView.
 */
object ChoiceBoxListCell {

  /**
   * Converts a ScalaFX $CBLC to its JavaFX counterpart.
   *
   * @param cell
   *   ScalaFX $CBLC
   */
  implicit def sfxChoiceBoxListCell2jfx[T](cell: ChoiceBoxListCell[T]): jfxscc.ChoiceBoxListCell[T] =
    if (cell != null) cell.delegate else null

  /**
   * $FLVINIT
   *
   * @tparam T
   *   $TTYPE
   * @param items
   *   $BUFITEMSPARAM
   * @return
   *   $FTVRET
   */
  def forListView[T](items: ObservableBuffer[T]): (ListView[T] => ListCell[T]) =
    (view: ListView[T]) => jfxscc.ChoiceBoxListCell.forListView[T](items).call(view)

  /**
   * Added to satisfy Spec tests.
   */
  @deprecated(message = "Use forListView[T](ObservableBuffer[T])", since = "1.0")
  def forListView[T](items: jfxc.ObservableList[T]): jfxu.Callback[jfxsc.ListView[T], jfxsc.ListCell[T]] =
    jfxscc.ChoiceBoxListCell.forListView[T](items)

  /**
   * $FLVINIT
   *
   * @tparam T
   *   $TTYPE
   * @param converter
   *   $CONVPARAM
   * @param items
   *   $BUFITEMSPARAM
   * @return
   *   $FTVRET
   */
  def forListView[T](converter: StringConverter[T], items: ObservableBuffer[T]): (ListView[T] => ListCell[T]) =
    (view: ListView[T]) => jfxscc.ChoiceBoxListCell.forListView[T](converter, items).call(view)

  /**
   * Added to satisfy Spec tests.
   */
  @deprecated(message = "Use forListView[T](StringConverter[T], ObservableBuffer[T])", since = "1.0")
  def forListView[T](
      converter: jfxu.StringConverter[T],
      items: jfxc.ObservableList[T]
  ): jfxu.Callback[jfxsc.ListView[T], jfxsc.ListCell[T]] =
    jfxscc.ChoiceBoxListCell.forListView[T](converter, items)

  /**
   * $FLVINIT
   *
   * @tparam T
   *   $TTYPE
   * @param converter
   *   $CONVPARAM
   * @param items
   *   $ITEMSPARAM
   * @return
   *   $FTVRET
   */
  def forListView[T](converter: StringConverter[T], items: T*): (ListView[T] => ListCell[T]) =
    (view: ListView[T]) => jfxscc.ChoiceBoxListCell.forListView[T](converter, items: _*).call(view)

  /**
   * Added to satisfy Spec tests.
   */
  @deprecated(message = "Use forListView[T](StringConverter[T], T*)", since = "1.0")
  def forListView[T](
      converter: jfxu.StringConverter[T],
      items: T*
  ): jfxu.Callback[jfxsc.ListView[T], jfxsc.ListCell[T]] = jfxscc.ChoiceBoxListCell.forListView[T](converter, items: _*)

  /**
   * $FLVINIT
   *
   * @tparam T
   *   $TTYPE
   * @param items
   *   $ITEMSPARAM
   * @return
   *   $FTVRET
   */
  def forListView[T](items: T*): (ListView[T] => ListCell[T]) =
    (view: ListView[T]) => jfxscc.ChoiceBoxListCell.forListView[T](items: _*).call(view)

  /**
   * Added to satisfy Spec tests.
   */
  @deprecated(message = "Use forListView[T](T*)", since = "1.0")
  def forListView[T](items: Array[T]): jfxu.Callback[jfxsc.ListView[T], jfxsc.ListCell[T]] =
    jfxscc.ChoiceBoxListCell.forListView[T](items: _*)

}

/**
 * Wraps [[http://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/cell/ChoiceBoxListCell.html$CBLC]]
 *
 * @tparam T
 *   Type used in this cell
 * @constructor
 *   Creates a new $CBLC from a JavaFX $CBLC
 * @param delegate
 *   JavaFX $CBLC
 * @define
 *   CBLC `ChoiceBoxListCell`
 * @define
 *   CONVPARAM A `StringConverter` to convert the given item (of type T) to a String for displaying to the user.
 * @define
 *   ITEMSPARAM Zero or more items that will be shown to the user when the ChoiceBox menu is showing.
 * @define
 *   BUFITEMSPARAM A `ObservableBuffer` containing $ITEMSPARAM
 */
class ChoiceBoxListCell[T](override val delegate: jfxscc.ChoiceBoxListCell[T] = new jfxscc.ChoiceBoxListCell[T])
    extends ListCell[T](delegate)
    with ConvertableCell[jfxscc.ChoiceBoxListCell[T], T, T]
    with UpdatableCell[jfxscc.ChoiceBoxListCell[T], T]
    with ItemableCell[jfxscc.ChoiceBoxListCell[T], T]
    with SFXDelegate[jfxscc.ChoiceBoxListCell[T]] {

  /**
   * Creates a default $CBLC instance with the given items being used to populate the ChoiceBox when it is shown.
   *
   * @param items
   *   $BUFITEMSPARAM
   */
  def this(items: ObservableBuffer[T]) = this(new jfxscc.ChoiceBoxListCell[T](items.delegate))

  /**
   * Creates a $CBLC instance with the given items being used to populate the `ChoiceBox` when it is shown, and the
   * StringConverter being used to convert the item in to a user-readable form.
   *
   * @param converter
   *   $CONVPARAM
   * @param items
   *   $BUFITEMSPARAM
   */
  def this(converter: StringConverter[T], items: ObservableBuffer[T]) =
    this(new jfxscc.ChoiceBoxListCell[T](sfxStringConverter2jfx(converter), items.delegate))

  /**
   * Creates a $CBLC instance with the given items being used to populate the `ChoiceBox` when it is shown, and the
   * StringConverter being used to convert the item in to a user-readable form.
   *
   * @param converter
   *   $CONVPARAM
   * @param items
   *   $ITEMSPARAM
   */
  def this(converter: StringConverter[T], items: T*) =
    this(new jfxscc.ChoiceBoxListCell[T](sfxStringConverter2jfx(converter), items: _*))

  /**
   * Creates a default `ChoiceBoxListCell` instance with the given items being used to populate the `ChoiceBox` when it
   * is shown.
   *
   * @param items
   *   $ITEMSPARAM
   */
  def this(items: T*) = this(new jfxscc.ChoiceBoxListCell[T](items: _*))

}
