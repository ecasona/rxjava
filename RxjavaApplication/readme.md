最近看了下rxJava，rxAndroid，觉得满好用的(代码逻辑很清晰)，特意记录，作为学习笔记。

原理：
rxJava 主要有两个核心：subscribers(观察者，订阅) 和 observers (被观察者，事件源)，即observers发出一系列的事件，然后有observer去处理。
observers 通过create()创建，并由其subscribe的onNext()去发出事件，最后调用onComplete()或者onError()来结束这个事件。
observers 通过observable.subscribe(subscriber)方法与subscriber关联，即subscriber通过该方法去订阅observable。

Retrofit 早已经支持了rxJava，本项目是retrofit 与rxJava的浅试。


