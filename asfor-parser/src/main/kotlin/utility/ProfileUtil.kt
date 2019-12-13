package utility

import kotlin.system.measureTimeMillis

fun profileTimeScope(name: String, block: () -> Unit) {
  println("Start scope: $name")

  val time = measureTimeMillis(block)

  val formatTime = timeToString(time)

  println("End scope: $name. Time: $formatTime")
}

private fun timeToString(durationInMillis: Long) : String {
  val millis: Long = durationInMillis % 1000
  val second: Long = durationInMillis / 1000 % 60
  val minute: Long = durationInMillis / (1000 * 60) % 60
  val hour: Long = durationInMillis / (1000 * 60 * 60) % 24

  return String.format("%02d:%02d:%02d.%d", hour, minute, second, millis)
}
