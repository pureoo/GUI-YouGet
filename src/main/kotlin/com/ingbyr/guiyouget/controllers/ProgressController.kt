package com.ingbyr.guiyouget.controllers

import com.ingbyr.guiyouget.core.YouGet
import com.ingbyr.guiyouget.core.YoutubeDL
import com.ingbyr.guiyouget.events.DownloadingRequestWithYouGet
import com.ingbyr.guiyouget.events.DownloadingRequestWithYoutubeDL
import org.slf4j.LoggerFactory
import tornadofx.*

class ProgressController : Controller() {
    private val logger = LoggerFactory.getLogger(this::class.java)

    fun subscribeEvents() {
        subscribe<DownloadingRequestWithYoutubeDL> {
            val youtubedl = YoutubeDL(it.url)
            youtubedl.runDownloadCommand(it.formatID)
        }

        subscribe<DownloadingRequestWithYouGet> {
            val youget = YouGet(it.url)
            youget.runDownloadCommand(it.formatID)
        }
    }
}
