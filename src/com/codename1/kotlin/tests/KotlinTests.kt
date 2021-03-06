package com.codename1.kotlin.tests

import com.codename1.io.Log
import com.codename1.io.NetworkEvent
import com.codename1.testing.TestRunnerComponent
import com.codename1.ui.CN
import com.codename1.ui.Dialog
import com.codename1.ui.Form
import com.codename1.ui.Toolbar
import com.codename1.ui.plaf.UIManager
import com.codename1.ui.util.Resources


/**
 * This file was generated by [Codename One](https://www.codenameone.com/) for the purpose
 * of building native mobile applications using Java.
 */
open class KotlinTests {
    private var current: Form? = null
    private var theme: Resources? = null
    fun init(context: Any?) {
        // use two network threads instead of one
        CN.updateNetworkThreadCount(2)
        theme = UIManager.initFirstTheme("/theme")

        // Enable Toolbar on all Forms by default
        Toolbar.setGlobalToolbar(true)

        // Pro only feature
        Log.bindCrashProtection(true)
        CN.addNetworkErrorListener { err: NetworkEvent ->
            // prevent the event from propagating
            err.consume()
            if (err.error != null) {
                Log.e(err.error)
            }
            Log.sendLogAsync()
            Dialog.show("Connection Error", "There was a networking error in the connection to " + err.connectionRequest.url, "OK", null)
        }
    }

    fun start() {
        if (current != null) {
            current!!.show()
            return
        }
        val r = TestRunnerComponent()
        r.add(ArraysTest()
        )
        r.showForm()
    }

    fun stop() {
        current = CN.getCurrentForm()
        if (current is Dialog) {
            (current as Dialog).dispose()
            current = CN.getCurrentForm()
        }
    }

    fun destroy() {}
}