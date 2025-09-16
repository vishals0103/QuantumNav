plugins {
	java
}

dependencies {
	implementation(project(":data"))
	// WorldWind Java - use NASA WorldWind 2.2.1 from Maven Central
	implementation("gov.nasa.worldwind:worldwind:2.2.1")
}