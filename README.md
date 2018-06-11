Step to reproduce
=================

**Issue link: N/A**

* `./gradlew build`
  * "not.so.important.tasks.VerifyVersionTaskSpec > can run VerifyVersionTask for gradle 4.8 " fails with error 
```
Caused by: java.lang.NoSuchMethodError: org.gradle.api.internal.GradleInternal.getTaskGraph()Lorg/gradle/execution/TaskGraphExecuter;
  at not.so.important.tasks.VerifyVersionTask.<init>(VerifyVersionTask.groovy:20)
  at not.so.important.tasks.VerifyVersionTask_Decorated.<init>(Unknown Source)
```
* Removing @CompileStatic in VerifyVersionTask seems to resolve the error... 