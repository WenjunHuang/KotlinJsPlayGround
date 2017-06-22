package simple

import kotlin.browser.document
import kotlin.browser.window
import kotlinx.html.*
import kotlinx.html.dom.*
import org.w3c.dom.HTMLDivElement

/**
 * Created by rick on 2017/6/22.
 */

fun sayHi() {
    println("say hi")
    val div = document.getElementById("app") as HTMLDivElement
    val form = loginForm {
           println("on submit")
       }
    div.appendChild(form)
}
