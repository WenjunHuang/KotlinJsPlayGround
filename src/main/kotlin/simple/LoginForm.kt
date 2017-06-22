package simple

import org.w3c.dom.HTMLFormElement
import org.w3c.dom.events.EventListener
import kotlinx.html.*
import kotlinx.html.dom.*
import kotlinx.html.js.onSubmitFunction
import org.w3c.dom.HTMLBRElement
import org.w3c.dom.HTMLElement
import org.w3c.dom.events.Event
import kotlin.browser.document

/**
 * Created by rick on 2017/6/22.
 */

fun loginForm(onSubmit: (Event) -> Unit): HTMLElement =
        document.create.form {
            id = "loginform"
            onSubmitFunction = onSubmit
            span {
                id = "message"
            }

            lineBreak()

            input {
                id = "username"
                type = InputType.text
                placeholder = "Username"
            }

            input {
                id = "password"
                type = InputType.password
                placeholder = "Password"
            }

            lineBreak()

            button {
                type = ButtonType.submit
                text("Sign In")
            }
        }

fun lineBreak() = document.create.br {}