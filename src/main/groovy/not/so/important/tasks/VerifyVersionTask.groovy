package not.so.important.tasks

import groovy.transform.CompileStatic
import org.gradle.api.DefaultTask
import org.gradle.api.execution.TaskExecutionGraph
import org.gradle.api.provider.Provider
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

/**
 * Verifies that the release version has valid syntax
 */
@CompileStatic
class VerifyVersionTask extends DefaultTask {

  @Input
  final Provider<Object> projectVersion = project.provider { project.version }

  VerifyVersionTask() {
    project.gradle.taskGraph.whenReady { TaskExecutionGraph taskGraph ->
      // Further evaluation of task graph in order to
    }
  }

  @TaskAction
  void doStuff() {
    // More verification here in in real task
  }

}
