package not.so.important

import groovy.transform.CompileStatic
import not.so.important.tasks.VerifyVersionTask
import org.gradle.api.Plugin
import org.gradle.api.Project

@CompileStatic
class SomePlugin implements Plugin<Project> {

  void apply(Project project) {
    project.tasks.create(name: "verifyVersion", type: VerifyVersionTask)
  }


}
