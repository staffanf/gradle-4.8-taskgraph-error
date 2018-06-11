package not.so.important.tasks

import org.gradle.testkit.runner.GradleRunner
import org.junit.Rule
import org.junit.rules.TemporaryFolder
import spock.lang.Specification
import spock.lang.Unroll

import static org.gradle.testkit.runner.TaskOutcome.SUCCESS

class VerifyVersionTaskSpec extends Specification {

  File buildFile

  @Rule
  public TemporaryFolder tempFolder = new TemporaryFolder()

  def setup() {
    buildFile = tempFolder.newFile('build.gradle')
  }

  @Unroll
  def "can run VerifyVersionTask for gradle #gradleVersion"() {
    when:
    buildFile << """
plugins {
  id 'some-plugin'
}
"""
    def result = GradleRunner.create()
        .withProjectDir(tempFolder.root)
        .withArguments(['-s', 'verifyVersion'])
        .withGradleVersion(gradleVersion)
        .withPluginClasspath()
        .forwardOutput()
        .build()

    then:
    result.task(":verifyVersion").outcome == SUCCESS

    where:
    gradleVersion << ['4.7', '4.8']
  }


}
