package com.gatling.tests

import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class gatlingaddcomputer extends Simulation {

	val httpProtocol = http
		.baseUrl("https://computer-database.gatling.io")
		.inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*"""), WhiteList())
		.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9")
		.acceptEncodingHeader("gzip, deflate")
		.acceptLanguageHeader("en-GB,en;q=0.9")
		.userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/101.0.4951.67 Safari/537.36")

	val headers_0 = Map(
		"Cache-Control" -> "max-age=0",
		"Sec-Fetch-Dest" -> "document",
		"Sec-Fetch-Mode" -> "navigate",
		"Sec-Fetch-Site" -> "none",
		"Sec-Fetch-User" -> "?1",
		"Upgrade-Insecure-Requests" -> "1",
		"sec-ch-ua" -> """ Not A;Brand";v="99", "Chromium";v="101", "Google Chrome";v="101""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-ch-ua-platform" -> "Windows")

	val headers_1 = Map(
		"accept" -> "*/*",
		"sec-ch-ua" -> """ Not A;Brand";v="99", "Chromium";v="101", "Google Chrome";v="101""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-ch-ua-platform" -> "Windows",
		"sec-fetch-dest" -> "script",
		"sec-fetch-mode" -> "no-cors",
		"sec-fetch-site" -> "cross-site")

	val headers_2 = Map(
		"accept" -> "text/css,*/*;q=0.1",
		"origin" -> "https://computer-database.gatling.io",
		"sec-ch-ua" -> """ Not A;Brand";v="99", "Chromium";v="101", "Google Chrome";v="101""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-ch-ua-platform" -> "Windows",
		"sec-fetch-dest" -> "style",
		"sec-fetch-mode" -> "cors",
		"sec-fetch-site" -> "cross-site")

	val headers_3 = Map(
		"Sec-Fetch-Dest" -> "document",
		"Sec-Fetch-Mode" -> "navigate",
		"Sec-Fetch-Site" -> "same-origin",
		"Sec-Fetch-User" -> "?1",
		"Upgrade-Insecure-Requests" -> "1",
		"sec-ch-ua" -> """ Not A;Brand";v="99", "Chromium";v="101", "Google Chrome";v="101""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-ch-ua-platform" -> "Windows")

	val headers_6 = Map(
		"Cache-Control" -> "max-age=0",
		"Origin" -> "https://computer-database.gatling.io",
		"Sec-Fetch-Dest" -> "document",
		"Sec-Fetch-Mode" -> "navigate",
		"Sec-Fetch-Site" -> "same-origin",
		"Sec-Fetch-User" -> "?1",
		"Upgrade-Insecure-Requests" -> "1",
		"sec-ch-ua" -> """ Not A;Brand";v="99", "Chromium";v="101", "Google Chrome";v="101""",
		"sec-ch-ua-mobile" -> "?0",
		"sec-ch-ua-platform" -> "Windows")

	val uri2 = "https://gc.kis.v2.scr.kaspersky-labs.com"

	val scn = scenario("gatlingaddcomputer")
		.exec(http("request_0")
			.get("/computers")
			.headers(headers_0)
			.resources(http("request_1")
			.get(uri2 + "/FD126C42-EBFA-4E12-B309-BB3FDD723AC1/main.js?attr=cflfikX2lmGXdg5n07zNDgPZOv-_2mnn3Q8oEYgwbofvG5YMbosPZOqfaq0SRihZe-urCQdv_GD-uwib4bhqAQ")
			.headers(headers_1),
				http("request_2")
			.get(uri2 + "/E3E8934C-235A-4B0E-825A-35A08381A191/abn/main.css?attr=aHR0cHM6Ly9jb21wdXRlci1kYXRhYmFzZS5nYXRsaW5nLmlvL2NvbXB1dGVycw")
			.headers(headers_2)))
		.pause(2)
		.exec(http("request_3")
			.get("/computers/new")
			.headers(headers_3)
			.resources(http("request_4")
			.get(uri2 + "/FD126C42-EBFA-4E12-B309-BB3FDD723AC1/main.js?attr=dn0DYG5wzdESyTvDA3y8EBJZw_Z-_gWGsffKcrEYEZCYtJDUWKgungreku8ioBqMJBkHkjvmWKc2gVPGRpiIxzqageBgvoKrbA-6Ow99Gaw")
			.headers(headers_1),
				http("request_5")
			.get(uri2 + "/E3E8934C-235A-4B0E-825A-35A08381A191/abn/main.css?attr=aHR0cHM6Ly9jb21wdXRlci1kYXRhYmFzZS5nYXRsaW5nLmlvL2NvbXB1dGVycy9uZXc")
			.headers(headers_2)))
		.pause(24)
		.exec(http("request_6")
			.post("/computers")
			.headers(headers_6)
			.formParam("name", "win10comp")
			.formParam("introduced", "2010-01-01")
			.formParam("discontinued", "2012-01-01")
			.formParam("company", "3"))

	setUp(scn.inject(atOnceUsers(1))).protocols(httpProtocol)
}