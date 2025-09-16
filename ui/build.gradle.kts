plugins {
	application
}

dependencies {
	implementation(project(":visual"))
	implementation(project(":core"))
}

application {
	mainClass.set("app.ui.MainApp")
}