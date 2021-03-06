
import shared.PresentationUtil._
import japgolly.scalajs.react.ScalaComponent
import japgolly.scalajs.react.vdom.html_<^._
import org.scalajs.dom

import scala.scalajs.js.JSApp
import scala.scalajs.js.annotation.JSExport

object MyTalk extends JSApp {

  import Enumeration._

  val chapter1 = chapter(
    chapterSlide(
      <.h2("Build your presentations with ScalaJS + reveal.js"),
      <.br,
      <.h4("move down (down-arrow)")
    ),

    headerSlide(
      "reveal.js commands",
      <.p("Press 'f' to go full-screen and ESC to see an overview of your slides."),
      <.br,
      <.p("You can navigate to the right and down.")
    ),

    headerSlide(
      "My Header",
      <.h3("Headers everywhere")
    ),

    headerSlide(
      "Enumeration",
      Enumeration(
        Item.stable("always show this item"),
        Item.fadeIn("I fade in"),
        Item.stable("I am also always here")
      )
    ),

    headerSlide(
      "Code, so much code",
      scalaC("""
        def main(args: Array[String]): Unit = {
          println("hello, world")
        }
      """),
      scalaFragment("""
        def moreSideEffects(): Unit = {
          println("pop in")
        }
      """)
    ),

    noHeaderSlide(
      <.h3("Or have a blank slide")
    )
  )

  val chapter2 = chapter(
    chapterSlide(
      <.h2("Where can I find more information?")
    ),

    headerSlide(
      "about reveal.js",
      <.a(
        ^.href := "https://github.com/hakimel/reveal.js/",
        "reveal.js"
      )
    ),

    headerSlide(
      "about ScalaJS",
      <.a(
        ^.href := "https://www.scala-js.org",
        "ScalaJS"
      )
    )
  )

  val Talk = ScalaComponent
    .builder[Unit]("Presentation")
    .renderStatic(
      <.div(
        ^.cls := "reveal",
        <.div(
          ^.cls := "slides",
          chapter1,
          chapter2
        )
      )
    )
    .build

  @JSExport
  override def main(): Unit = {
    Talk().renderIntoDOM(dom.document.body)
  }
}
